package data;

import entities.Card;
import entities.CardFactory;
import use_cases.build_deck.BuildDeckDataAccessInterface;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


// reads cards from the collection (stored in a csv file)
public class CardDAO implements CardDataAccessInterface, BuildDeckDataAccessInterface {

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, Card> cards = new HashMap<>(); // mapping of the pokemon's id to the pokemon itself (this is in the user's use_cases.collection)

    private CardFactory cardFactory;

    public CardDAO(String csvPath, CardFactory cardFactory) throws IOException {
        this.cardFactory = cardFactory;

        csvFile = new File(csvPath);
        headers.put("id", 0);
        headers.put("name", 1);
        headers.put("isHighHp", 2);
        headers.put("isSpecial", 3);


        if (csvFile.length() == 0) {
            save();
        } else {

            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();
                assert header.equals("id,name,isHighHp,isSpecial");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String id = String.valueOf(col[headers.get("id")]);
                    String name = String.valueOf(col[headers.get("name")]);

                    Card card = cardFactory.create(id, name);
                    cards.put(id, card);
                }
            }
        }
    }
    @Override
    public void save(Card card) {
        cards.put(card.getId(), card);
        this.save();
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (Card card : cards.values()) {
                String line = String.format("%s,%s", card.getId(), card.getName(), card.isHighHp(), card.isSpecial());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
