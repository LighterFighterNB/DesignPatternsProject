import API.BookAPI;
import CatalogItems.CatalogItem.Book;
import CatalogItems.CatalogItem.CatalogItem;
import CatalogItems.CatalogItem.Movie;

import API.JSONReader;
import API.MovieAPI;
import API.XMLReader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


import Storage.TextFile;

import java.util.ArrayList;

public class Main {
    public static void main(String[]args)
    {
//        XMLReader bAPI = new XMLReader();
//        BookAPI book = new BookAPI();

        //System.out.println(book.basicSearch("Illuminae"));

//        bAPI.createXML("Illuminae");

//        MovieAPI movie = new MovieAPI();
//        System.out.println(movie.detailedSearch("About time"));
        TextFile textFile = new TextFile();

        ArrayList<CatalogItem> catalogItems = new ArrayList<>();

        catalogItems.add(new Movie("Hello", "me","All about me",1999,"horror",5,"2500"));
        catalogItems.add(new Book("Hello", "me","All about me",1999,"horror",5,"24021996","30021996"));

        textFile.saveToTextFile("Eric", catalogItems);
        textFile.loadCatalog("Eric");
        textFile.createNewTextFile("Eric");

    }
}
