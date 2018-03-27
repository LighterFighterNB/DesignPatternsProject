import API.BookAPI;
import Storage.TextFile;

public class Main {
    public static void main(String[]args)
    {
        TextFile textFile = new TextFile();

        textFile.createNewTextFile("Eric");
    }
}
