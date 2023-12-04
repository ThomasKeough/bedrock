package entities;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class CommonCardFactory implements CardFactory {

    @Override
    public Card create(String id, String name) {

        return build_card(getCardFromAPI(id), id);
    }

    public JSONObject getCardFromAPI(String id) {
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

            return card;

        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public Card build_card(JSONObject card, String id) {
        String name = card.getString("name");
        Integer hp = card.getInt("hp");

        String cardType = card.getJSONArray("types").getString(0); // ex: ["Metal"]

        HashMap<String, Integer> cardWeaknesses = new HashMap<>();

        if (card.has("weaknesses")) {
            JSONObject cardWeaknessesObj = card.getJSONArray("weaknesses").getJSONObject(0);
            String weaknessValue = cardWeaknessesObj.getString("value");
            if (!Objects.equals(weaknessValue, "")) {
                weaknessValue = cleanNumberString(weaknessValue);
            } else {
                weaknessValue = "0";
            }
            cardWeaknesses.put(cardWeaknessesObj.getString("type"), Integer.parseInt(weaknessValue));
//        cardWeaknesses.put(cardWeaknessesObj.getString("type"), cardWeaknessesObj.getInt("value"));
        }
        HashMap<String, Integer> cardResistances = new HashMap<>();
        if (card.has("resistances")) {
            JSONObject cardResistancesObj = card.getJSONArray("resistances").getJSONObject(0);

            String resistanceValue = cardResistancesObj.getString("value");
            if (!Objects.equals(resistanceValue, "")) {
                resistanceValue = cleanNumberString(resistanceValue);
            } else {
                resistanceValue = "0";
            }
            cardResistances.put(cardResistancesObj.getString("type"), Integer.parseInt(resistanceValue));

//            cardResistances.put(cardResistancesObj.getString("type"), cardResistancesObj.getInt("value"));
        }

        Type type = new CommonType(cardType, cardWeaknesses, cardResistances);

        HashMap<String, Integer> attacks = new HashMap<>();
        if (card.has("attacks"))
        {
            JSONArray attacksObj = card.getJSONArray("attacks");
            for (int i = 0; i < attacksObj.length(); i++) {
                String damage = attacksObj.getJSONObject(i).getString("damage");
                if (!Objects.equals(damage, "")) {
                    damage = cleanNumberString(damage); // refactored the code below so we can reuse it in weakness and resistance
    //                damage = damage.replace("×", "");
    //                damage = damage.replace("+", "");
    //                damage = damage.replace("-", "");
                    attacks.put(attacksObj.getJSONObject(i).getString("name"), Integer.parseInt(damage));
                } else {
                    attacks.put(attacksObj.getJSONObject(i).getString("name"), 0);
                }
            }
        }

        boolean isSpecial = false;
        JSONArray subtypesArray = card.getJSONArray("subtypes");

        // check if card subtype is ex or mega
        for (int a = 0; a < subtypesArray.length(); a++) {
            String subtype = subtypesArray.getString(a);
            if ("ex".equalsIgnoreCase(subtype) || "mega".equalsIgnoreCase(subtype)) {
                isSpecial = true;
                break; // No need to continue checking once found
            }
        }
        String image = card.getJSONObject("images").getString("large");

        return new CommonCard(name, id, hp, type, attacks, isSpecial, image);
    }

    private String cleanNumberString(String s) {
        s = s.replace("×", "");
        s = s.replace("+", "");
        s = s.replace("-", "");
        return s;
    }
}
