package API;

import okhttp3.*;

public class MovieAPI extends API{

    public MovieAPI()
    {
        super("http://www.omdbapi.com/?i=tt3896198", "&apikey=b65777aa");
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
