import API.BookAPI;

public class Main {
    public static void main(String[]args)
    {
        BookAPI bAPI = new BookAPI();

        System.out.println(bAPI.search("Illuminae"));
    }
}
