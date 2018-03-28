package API;

import okhttp3.*;

public class MovieAPI implements API{
    private String URL = "http://www.omdbapi.com/?i=tt3896198";
    private String key = "&apikey=b65777aa";

    private OkHttpClient client;
    private Request request;
    private Response response;

    public MovieAPI()
    {
        client = new OkHttpClient();
        request = null;
        response = null;
    }

    public String basicSearch(String query)
    {
        request = new Request.Builder().url(URL+key+"&s="+query).get().build();
        String finalResponse = "";
        try{
            response = client.newCall(request).execute();
            finalResponse = response.body().string();
        }
        catch (Exception e)
        {
            System.out.print("The Movie API is not available.");
        }
        return finalResponse;
    }

    public String detailedSearch(String query)
    {
        request = new Request.Builder().url(URL+key+"&t="+query).get().build();
        String finalResponse = "";
        try{
            response = client.newCall(request).execute();
            finalResponse = response.body().string();
        }
        catch (Exception e)
        {
            System.out.print("The Movie API is not available.");
        }
        return finalResponse;
    }
}
