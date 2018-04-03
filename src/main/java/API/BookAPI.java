package API;
import okhttp3.*;

public class BookAPI extends API{
    private final String secret = "iw2K3xHouX1j9mCfQwjGEX79UgQpB7FBOFN0pUWzuU";


    public BookAPI()
    {
        super("https://www.goodreads.com/search.xml?", "key=RIWQy80W6TBDYlMptXJyQ");
    }

    public String basicSearch(String query)
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
