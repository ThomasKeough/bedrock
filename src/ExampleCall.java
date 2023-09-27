import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class ExampleCall {
    private static final String API_URL = "https://api.pokemontcg.io/";
    private static final String API_TOKEN = "d21c262a-936b-4dfb-bc81-36e05d8c8ce7"; // Replace with your API token

    public static String getApiToken() {
        return API_TOKEN;
    }

    public String getCardName(String cardID) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(API_URL + "v2/cards/" + cardID)
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
            return card.getString("name");
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ExampleCall example = new ExampleCall();
        System.out.print("Test 1\nExpected: Venusaur-EX\nActual: " + example.getCardName("xy1-1"));
    }
}
