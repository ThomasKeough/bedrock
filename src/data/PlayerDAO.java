package data;

import entities.*;
import view.Observer;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PlayerDAO {
    private static final String CSV_FILE_PATH = "./player_data.csv";

    public static void update(Player player) {
        savePlayer(player);
    }

    public static boolean playerDataExists(){
        File file = new File(CSV_FILE_PATH);
        return file.exists() && file.length() > 0;
    }

    public static void savePlayer(Player player) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE_PATH))) {
            // Write the player data to the file
            writer.println(player.getName());
            writer.println(player.getCurrentDeck().getDeckName());

            // Save the player's collection
            writer.println("COLLECTION_START");
            for (Card card : player.getCollection().getCards()) {
                writer.println(card.getId());
                writer.println(card.getName());
            }
            writer.println("COLLECTION_END");

            // Save the player's decks
            writer.println("DECKS_START");
            for (Deck deck : player.getDecks().values()) {
                writer.println(deck.getDeckName());
                // Write other deck attributes...
                for (Card card : deck.getCards()) {
                    writer.println(card.getId());
                }
            }
            writer.println("DECKS_END");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Player loadPlayer() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            // Read the player data from the file
            String playerName = reader.readLine();
            String currentDeckName = reader.readLine();

            // Load and build the player's collection
            ArrayList<Card> cards = new ArrayList<Card>();
            CommonCardFactory factory = new CommonCardFactory();
            String cardId;
            String cardName;

            // Skip to the start of the collection
            while (!reader.readLine().equals("COLLECTION_START")) {}

            while (!(cardId = reader.readLine()).equals("COLLECTION_END") && (cardName = reader.readLine()) != null) {
                Card card = factory.create(cardId, cardName);
                cards.add(card);
            }
            Collection collection = new CommonCollection(cards);

            // Load the player's decks from collection
            HashMap<String, Deck> decks = new HashMap<>();
            String deckName;

            // Skip to the start of the decks
            while (!reader.readLine().equals("DECKS_START")) {}

            while ((deckName = reader.readLine()) != null && !deckName.equals("DECKS_END")) {
                ArrayList<Card> deckCards = new ArrayList<>();
                String cardIdInDeck;
                while ((cardIdInDeck = reader.readLine()) != null && !cardIdInDeck.equals("DECK_END")) {
                    deckCards.add(collection.getCard(cardIdInDeck));
                }

                Deck deck = new CommonDeck(deckName, deckCards.get(0), deckCards.get(1), deckCards.get(2),
                        deckCards.get(3), deckCards.get(4), deckCards.get(5));
                decks.put(deckName, deck);
            }

            // Create and return the player
            Player player = new CommonPlayer(playerName, decks.get(currentDeckName), collection, decks);
            return player;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }


}