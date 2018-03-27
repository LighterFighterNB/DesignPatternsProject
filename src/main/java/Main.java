import API.BookAPI;
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
import Storage.TextFile;
>>>>>>> 23cc42d3f46fbc4ce31e801051d5120f777fe6af

public class Main {
    public static void main(String[]args)
    {
<<<<<<< HEAD
//        XMLReader bAPI = new XMLReader();
//        BookAPI book = new BookAPI();

        //System.out.println(book.basicSearch("Illuminae"));

//        bAPI.createXML("Illuminae");

//        MovieAPI movie = new MovieAPI();
//        System.out.println(movie.detailedSearch("About time"));
=======
        TextFile textFile = new TextFile();

        textFile.createNewTextFile("Eric");
>>>>>>> 23cc42d3f46fbc4ce31e801051d5120f777fe6af
    }
}
