package data;

import entities.Card;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import use_cases.wonder_trade.WonderTradeDataAccessInterface;

import java.io.*;
import java.util.*;


public class TradingCardGameDAO implements WonderTradeDataAccessInterface {

    // Specify the CSV file path
    public static File csvFile = new File("circulating_pokemon_cards.csv");

    // the current set being used for the game, our default is sv3pt5, but feel free to change to any eligible set name
    private static String setID = "bw10";
    private final String API_URL = "https://api.pokemontcg.io/";
    private final String API_TOKEN = "d21c262a-936b-4dfb-bc81-36e05d8c8ce7";

    public static void fetch_and_write_data() {
        try{
            // Check if the file is empty
            if (csvFile.length() == 0) {

                // Create an instance of TradingCardGameDAO
                TradingCardGameDAO dao = new TradingCardGameDAO();

                // Call the getAllCards method to fetch data from the API and write to the CSV file
                dao.writeAllCards(setID);

                System.out.println("API data has been fetched and written to the CSV file.");
            }
            else{
                System.out.println("The CSV file is not empty.");
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    // pulling all 151 pokemon from the modern set ScarletViolet151 to store in a csv, so that we can have a circulation
    // of card info and their data,either to be added into user's use_cases.collection or used by bot. Made so set in
    // circulation can be switched out anytime.

    // should not store all card data, instead only store: pokemonName, id, type, isHighHP (110+), isSpecial(ex/mega),

    public void writeAllCards(String setID){
        // Create a map to store the information
        Map<String, String> pokemonInfoMap = new HashMap<>();

        String search_url = API_URL + "v2/cards/?q=set.id:" + setID;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(search_url)
                .header("Authorization", API_TOKEN)
                .header("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new RuntimeException("API request failed: Code " + response.code());
            }
            JSONObject responseBody = new JSONObject(response.body().string());
            JSONArray set = responseBody.getJSONArray("data");

            // Iterate through the array of cards in set
            for (int i = 0; i < set.length(); i++) {
                JSONObject pokemonObject = set.getJSONObject(i);

                // check that card is a Pokémon, not a trainer or item card
                String supertype = pokemonObject.getString("supertype");
                if (Objects.equals(supertype, "Pokémon"))
                {
                    // Extract the desired information
                    String id = pokemonObject.getString("id");
                    String name = pokemonObject.getString("name");
                    String type = pokemonObject.getJSONArray("types").getString(0);
                    boolean isHighHp = false;
                    if (Integer.parseInt(pokemonObject.getString("hp")) >= 110){
                        isHighHp = true;
                    }
                    boolean isSpecial = false;
                    JSONArray subtypesArray = pokemonObject.getJSONArray("subtypes");

                    // check if card subtype is ex or mega
                    for (int a = 0; a < subtypesArray.length(); a++) {
                        String subtype = subtypesArray.getString(a);
                        if ("ex".equalsIgnoreCase(subtype) || "mega".equalsIgnoreCase(subtype)) {
                            isSpecial = true;
                            break; // No need to continue checking once found
                        }
                    }

                    // Store the information in the map
                    // Write the information to a CSV file
                    writeDataToCSV(csvFile.getName(), id, name, type, isHighHp, isSpecial);
                }
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeDataToCSV(String fileName, String id, String name, String type,
                                       boolean isHighHp, boolean isSpecial)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            // Append the data to the CSV file
            writer.write(id + "," + name + "," + type + "," + isHighHp + "," + isSpecial);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Something went wrong - CSV data not written correctly.");
            e.printStackTrace(); // Print the stack trace for debugging purposes
        }
    }

    public String fetch_similar_card(boolean isHighHp, boolean isSpecial){
        String line = "";
        String csvFile = TradingCardGameDAO.csvFile.getName(); // replace with your file path
        List<String> matchingCards = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] card = line.split(",");

                // check if the line matches the parameters
                boolean lineIsHighHp = Boolean.parseBoolean(card[3].trim());
                boolean lineIsSpecial = Boolean.parseBoolean(card[4].trim());

                if (lineIsHighHp == isHighHp && lineIsSpecial == isSpecial) {
                    matchingCards.add(card[0]);  // add the card ID to the list
                }
            }

            if (!matchingCards.isEmpty()) {
                // Randomly select a card from the list of matching cards
                Random rand = new Random();
                return matchingCards.get(rand.nextInt(matchingCards.size()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "No matching card found";
    }

    public static int circulating_card_count(){
        String line = "";
        String csvFile = TradingCardGameDAO.csvFile.getName(); // replace with your file path
        int num = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                num += 1;
            }
            return num;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return num;
    }

}
