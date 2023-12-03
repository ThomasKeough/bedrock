package entities;

import data.TradingCardGameDAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommonCollection implements Collection {
    private Integer limit = 25;
    private ArrayList<Card> cards;

    // For deck
    public CommonCollection(ArrayList<Card> cards, int i) {
        this.cards = cards;
        limit = i;
    }

    public CommonCollection() {
        this.cards = new ArrayList<>();
    }

    public CommonCollection(Integer limit) {
        this.limit = limit;
        this.cards = new ArrayList<>();
    }


    public void initializeCollection(boolean onlySpecials) {
        // Read the data from the CSV file
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("circulating_pokemon_cards.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (!onlySpecials || "true".equals(parts[4].trim())) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Randomly pick initialized amount of lines and call csv_to_card on each
        Random rand = new Random();
        int lineSize = lines.size();
        for (int i = 0; i < limit; i++) {
//            int randomIndex = rand.nextInt(TradingCardGameDAO.circulating_card_count());
            int randomIndex = rand.nextInt(lineSize);
            String randomLine = lines.get(randomIndex);
            csv_to_card(randomLine);

            // If there are enough cards in circulation, remove the selected card from the list (sampling without replacement)
            if (lineSize > limit) {
                lines.remove(randomIndex);
                lineSize--;
            }
        }
    }

    public void csv_to_card(String line){
        CommonCardFactory factory = new CommonCardFactory();
        String[] parts = line.split(",");

        String id = parts[0];  // "sv3pt5-25"
        String name = parts[1];  // "Pikachu"

        Card card = factory.create(id, name);

        cards.add(card);
    }

    @Override
    public void replace_card(int card_index, Card replacement_card)
    {
        // Replace the card at the specified index with the replacement card
        cards.set(card_index, replacement_card);

    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Integer getLimit() {
        return limit;
    }

    public Boolean atLimit() {
        return cards.size() >= limit;
    }
}