package API;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public abstract class API
{
    protected String URL;
    protected String key;
    protected OkHttpClient client;
    protected Request request;
    protected Response response;

    public API(String URL, String key)
    {
        this.URL = URL;
        this.key = key;
        client = new OkHttpClient();
        request = null;
        response = null;
    }

    abstract String basicSearch(String query);
}
