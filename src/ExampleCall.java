// Example Call to the Pokemon TCG API

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class ExampleCall {
    private static final String API_URL = "https://pokemontcg.io/";
    private static final String API_TOKEN = "d21c262a-936b-4dfb-bc81-36e05d8c8ce7"; // use env variable?

    // add intializer

    public static String getApiToken() {return API_TOKEN;} // API_TOKEN getter method

    public String[] getCard(String cardID) { // minimal example, return a String array of name, type, attacks?
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format("https://api.pokemontcg.io/v2/cards/%s", cardID))
                .addHeader("Authorization", API_TOKEN)
                .addHeader("Content-Type", "application/json")
                .build();
    }
    public static void main(String[] args) {
        String venusaurEX = "xy1-1";
    }
}
