package API;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class JSONReader {
    private MovieAPI movieAPI;
    private ArrayList<String> arrayOfTitles;

    public JSONReader()
    {
        movieAPI = new MovieAPI();
        arrayOfTitles = new ArrayList<String>();
    }

    private JSONArray createJSONMovieArray(String query)
    {
        String JSONtext = movieAPI.basicSearch(query);
        JSONObject jsonObject = new JSONObject(JSONtext);
        JSONArray arrayOfMovies = (JSONArray) jsonObject.get("Search");

        return arrayOfMovies;
    }

    public ArrayList<String> getTitles(String query)
    {
        JSONArray arrayOfMovies = createJSONMovieArray(query);

        for (int i = 0; i < arrayOfMovies.length(); i++) {
            JSONObject jsonObject = arrayOfMovies.getJSONObject(i);
            String title = jsonObject.getString("Title");
            arrayOfTitles.add(title);
        }
        return arrayOfTitles;
    }

    public HashMap<String, String> createDetails(String query)
    {
        String JSONtext = movieAPI.detailedSearch(query);
        JSONObject jsonObject = new JSONObject(JSONtext);
        HashMap<String, String> arrayOfMoviesDetails = new HashMap<>();
        arrayOfMoviesDetails.put("Title",jsonObject.get("Title").toString());
        arrayOfMoviesDetails.put("Year",jsonObject.get("Year").toString());
        arrayOfMoviesDetails.put("Rated",jsonObject.get("Rated").toString());
        arrayOfMoviesDetails.put("Genre",jsonObject.get("Genre").toString());
        arrayOfMoviesDetails.put("Director",jsonObject.get("Director").toString());
        arrayOfMoviesDetails.put("Plot",jsonObject.get("Plot ").toString());

        return arrayOfMoviesDetails;
    }
}
