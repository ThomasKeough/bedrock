package entities;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;

public class QueryCard implements Card{
    String API_URL = "https://api.pokemontcg.io/v2/cards";
    String API_TOKEN = "d21c262a-936b-4dfb-bc81-36e05d8c8ce7";

    private final List<String> id;

    public String query_id(String name, boolean searchByName, String type, boolean searchByType,
                    boolean hasHighHP, boolean isMega){
        // to implement
    }
    public String apply_search_parameters(String name, boolean searchByName, String type, boolean searchByType,
                        boolean hasHighHP, boolean isMega){

        String cloned_url = API_URL + "?q=";
        List<String> query_parameters = new ArrayList<>();

        if (searchByName){
            query_parameters.add("name:" + name);
        }
        else if (searchByType){
            query_parameters.add("types:" + type);
        }
        else if (hasHighHP){
            query_parameters.add("hp:[150 TO *]");
        }
        else if (isMega){
            query_parameters.add("subtypes:mega");
        }

        for (int i = 0; i < query_parameters.size(); i++){
            // if first parameter, URL does not need to concatenate between parameters with %20.
            if (i == 0){
                cloned_url += query_parameters.get(i);
            }

            else{
                cloned_url += "%20" + query_parameters.get(i);
            }
        }

        return cloned_url;
    }


    public void pickCardFromQueryResults(String url)
    {

    }



}