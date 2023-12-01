package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommonCollection implements Collection {
    private Integer limit;
    private ArrayList<Card> cards;

    public CommonCollection() {
        this.limit = 100;
    }

    public CommonCollection(Integer limit) {
        this.limit = limit;
    }

    public void initializeCollection() {
        // Read the data from the CSV file
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("circulating_pokemon_cards.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Randomly pick 100 lines and call csv_to_card on each
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int randomIndex = rand.nextInt(lines.size());
            String randomLine = lines.get(randomIndex);
            csv_to_card(randomLine);
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

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Integer getLimit() {
        return limit;
    }

    public Boolean atLimit() {
        return cards.size() <= limit;
    }
}