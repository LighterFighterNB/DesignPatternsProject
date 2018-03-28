import API.*;
import CatalogItems.CatalogItem.Book;
import CatalogItems.CatalogItem.CatalogItem;
import CatalogItems.CatalogItem.Movie;
import API.XMLReader;
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
        Catalog catalog = new Catalog();

        catalog.start();
    }
}
