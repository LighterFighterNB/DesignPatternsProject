<<<<<<< HEAD
import API.*;
import CatalogItems.CatalogItem.Book;
import CatalogItems.CatalogItem.CatalogItem;
import CatalogItems.CatalogItem.Movie;
=======
import API.XMLReader;
import API.BookAPI;
import CatalogItems.CatalogItem.Book;
import CatalogItems.CatalogItem.CatalogItem;
import CatalogItems.CatalogItem.Movie;

import API.JSONReader;
import API.MovieAPI;
>>>>>>> b382e2d591095bb0d30142118ce9d27b22c517a3
import API.XMLReader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
<<<<<<< HEAD
=======


>>>>>>> b382e2d591095bb0d30142118ce9d27b22c517a3
import Storage.TextFile;

import java.util.ArrayList;

public class Main {
    public static void main(String[]args)
    {
<<<<<<< HEAD
//        JSONReader json = new JSONReader();
//        XMLReader xml = new XMLReader();
//        APIReader xmlAdapter = new XMLReaderAdapter(xml);
//
//        System.out.println("XMLReader");
//        xml.createBookDetails("Illuminae");
//
//        System.out.println("all titles");
//        xml.getBooksTitle("About time");
//
//        System.out.println("Movies");
//        json.createDetails("About time");
//
//        System.out.println("All titles movies:");
//        json.getTitles("Harry Potter");
//
//        System.out.println("XMLAdapter part");
//        xmlAdapter.createDetails("Harry Potter");
//
//        System.out.println("All titles:");
//        xmlAdapter.getTitles("If I stay");

//        TextFile textFile = new TextFile();
//       // textFile.createNewTextFile("Eric");
//        ArrayList<CatalogItem> catalogItems = new ArrayList<>();
//
//        catalogItems.add(new Movie("Hello", "me","All about me",1999,"horror",5,"2500"));
//        catalogItems.add(new Book("Hello", "me","All about me",1999,"horror",5,"24021996","30021996"));
//
//        textFile.saveToTextFile("Eric", catalogItems);
//        textFile.loadCatalog("Eric");
//        textFile.createNewTextFile("Eric");
=======
//        XMLReader bAPI = new XMLReader();
//        BookAPI book = new BookAPI();
        XMLReader bAPI = new XMLReader();
       // BookAPI book = new BookAPI();

       // System.out.println(book.basicSearch("Illuminae"));

        //bAPI.createBookDetails("Harry Potter");

//        MovieAPI movie = new MovieAPI();
//        System.out.println(movie.detailedSearch("About time"));
        TextFile textFile = new TextFile();

        //TextFile textFile = new TextFile();

       // textFile.createNewTextFile("Eric");
        ArrayList<CatalogItem> catalogItems = new ArrayList<>();

        catalogItems.add(new Movie("Hello", "me","All about me",1999,"horror",5,"2500"));
        catalogItems.add(new Book("Hello", "me","All about me",1999,"horror",5,"24021996","30021996"));

        textFile.saveToTextFile("Eric", catalogItems);
        textFile.loadCatalog("Eric");
        textFile.createNewTextFile("Eric");

>>>>>>> b382e2d591095bb0d30142118ce9d27b22c517a3
    }
}
