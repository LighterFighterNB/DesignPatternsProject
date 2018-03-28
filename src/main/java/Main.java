import API.BookAPI;
import CatalogItems.CatalogItem.Book;
import CatalogItems.CatalogItem.CatalogItem;
import CatalogItems.CatalogItem.Movie;
import Storage.TextFile;

import java.util.ArrayList;

public class Main {
    public static void main(String[]args)
    {
        TextFile textFile = new TextFile();

        ArrayList<CatalogItem> catalogItems = new ArrayList<>();

        catalogItems.add(new Movie("Hello", "me","All about me",1999,"horror",5,"2500"));
        catalogItems.add(new Book("Hello", "me","All about me",1999,"horror",5,"24021996","30021996"));

        textFile.saveToTextFile("Eric", catalogItems);
        textFile.loadCatalog("Eric");
    }
}
