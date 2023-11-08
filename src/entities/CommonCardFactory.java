package entities;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class CommonCardFactory implements CardFactory {

    @Override
    public Card create(String id, String name) {
        return getCardFromAPI(id);
    }

    public CommonCard getCardFromAPI(String id) {
        String API_URL = "https://api.pokemontcg.io/";
        String API_TOKEN = "d21c262a-936b-4dfb-bc81-36e05d8c8ce7";

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(API_URL + "v2/cards/" + id)
                .header("Authorization", API_TOKEN)
                .header("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new RuntimeException("API request failed: Code " + response.code());
            }
            JSONObject responseBody = new JSONObject(response.body().string());
            JSONObject card = responseBody.getJSONObject("data");

            String name = card.getString("name");
            Integer hp = card.getInt("hp");

            String cardType = card.getJSONArray("types").getString(0); // ex: ["Metal"]

            JSONObject cardWeaknessesObj = card.getJSONArray("weaknesses").getJSONObject(0);
            HashMap<String, Integer> cardWeaknesses = new HashMap<>();
            cardWeaknesses.put(cardWeaknessesObj.getString("type"), cardWeaknessesObj.getInt("value"));

            HashMap<String, Integer> cardResistances = new HashMap<>();
            if (card.has("resistances")) {
                JSONObject cardResistancesObj = card.getJSONArray("resistances").getJSONObject(0);
                cardResistances.put(cardResistancesObj.getString("type"), cardResistancesObj.getInt("value"));
            }

            Type type = new CommonType(cardType, cardWeaknesses, cardResistances);

            HashMap<String, Integer> attacks = new HashMap<>();
            JSONArray attacksObj = card.getJSONArray("attacks");
            for (int i = 0; i < attacksObj.length(); i++) {
                attacks.put(attacksObj.getJSONObject(i).getString("name"), Integer.parseInt(attacksObj.getJSONObject(i).getString("damage")));
            }


            String rarity = card.getString("rarity");
            String image = card.getJSONObject("images").getString("large");

            return new CommonCard(name, id, hp, type, attacks, rarity, image);

        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
