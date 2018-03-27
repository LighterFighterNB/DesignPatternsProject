package API;
import okhttp3.*;

public class BookAPI {
    private final String URL = "https://www.goodreads.com/search.xml?";
    private final String key = "key=RIWQy80W6TBDYlMptXJyQ";
    private final String secret = "iw2K3xHouX1j9mCfQwjGEX79UgQpB7FBOFN0pUWzuU";

    private OkHttpClient client;
    private Request request;
    private Response response;

    public BookAPI()
    {
        client = new OkHttpClient();
        request = null;
        response = null;
    }

    public String search(String query)
    {
        request = new Request.Builder().url(URL+key+"&q="+query).get().build();
        String finalResponse = "";
        try{
            response = client.newCall(request).execute();
            finalResponse = response.body().string();
        }
        catch (Exception e)
        {
            System.out.print("The Book API is not available.");
        }
        return finalResponse;
    }
}
