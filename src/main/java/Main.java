<<<<<<< HEAD
import API.XMLReader;
=======
import API.BookAPI;
<<<<<<< HEAD
import CatalogItems.CatalogItem.Book;
import CatalogItems.CatalogItem.CatalogItem;
import CatalogItems.CatalogItem.Movie;
=======
<<<<<<< HEAD
import API.JSONReader;
import API.MovieAPI;
import API.XMLReader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
=======
>>>>>>> 4e0f5db686ecc37b0bad508c0269d8996c4cefcf
>>>>>>> f50b7886f22b660a5158319c451d16296a050799
import Storage.TextFile;

import java.util.ArrayList;

public class Main {
    public static void main(String[]args)
    {
        XMLReader bAPI = new XMLReader();
       // BookAPI book = new BookAPI();

       // System.out.println(book.basicSearch("Illuminae"));

        //bAPI.createBookDetails("Harry Potter");

//        MovieAPI movie = new MovieAPI();
//        System.out.println(movie.detailedSearch("About time"));
        //TextFile textFile = new TextFile();

<<<<<<< HEAD
       // textFile.createNewTextFile("Eric");
=======
<<<<<<< HEAD
        ArrayList<CatalogItem> catalogItems = new ArrayList<>();

        catalogItems.add(new Movie("Hello", "me","All about me",1999,"horror",5,"2500"));
        catalogItems.add(new Book("Hello", "me","All about me",1999,"horror",5,"24021996","30021996"));

        textFile.saveToTextFile("Eric", catalogItems);
        textFile.loadCatalog("Eric");
=======
        textFile.createNewTextFile("Eric");
>>>>>>> 23cc42d3f46fbc4ce31e801051d5120f777fe6af
>>>>>>> 4e0f5db686ecc37b0bad508c0269d8996c4cefcf
>>>>>>> f50b7886f22b660a5158319c451d16296a050799
    }
}
