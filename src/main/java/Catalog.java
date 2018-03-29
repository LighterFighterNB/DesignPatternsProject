import API.JSONReader;
import API.XMLReader;
import API.XMLReaderAdapter;
import CatalogItems.CatalogItem.Book;
import CatalogItems.CatalogItem.CatalogItem;
import CatalogItems.CatalogItem.Command.CatalogItemEvent;
import CatalogItems.CatalogItem.Command.GetState;
import CatalogItems.CatalogItem.Command.SwitchState;
import CatalogItems.CatalogItem.Movie;
import Storage.TextFile;
import Storage.TextFileAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Catalog {

    //API
    private JSONReader jsonReader;
    private XMLReaderAdapter xmlReaderAdapter;

    //Display
    private UserInput input;
    private UserOutput output;

    //CatalogItems
    private ArrayList<CatalogItem> catalogItems;
    private CatalogItemEvent getStateEvent;
    private CatalogItemEvent switchStateEvent;

    //Storage
    //Adapter
    private TextFileAdapter textFileAdapter;

    private String user;
    private String command;

    public Catalog()
    {
        catalogItems = new ArrayList<>();
        jsonReader = new JSONReader();
        xmlReaderAdapter = new XMLReaderAdapter(new XMLReader());
        textFileAdapter = new TextFileAdapter(new TextFile());
        input = new UserInput();
        output = new UserOutput();
        user = "";
    }

    public void start()
    {
        output.printMessage("Welcome to the Catalog!");
        output.printLineSeperator();
        user = input.getInput("Please enter a username:");
        if(!textFileAdapter.checkUser(user)) {
            output.printLineSeperator();
            output.printMessage("This user has not been used, a new file will be created");
            textFileAdapter.createNewCatalog(user);
            output.printLineSeperator();
            executeCommand(input.getInput("Please enter a command"));
        }
        else
        {
            output.printLineSeperator();
            output.printMessage("This user is already in use please try another");
        }
    }

    public void executeCommand(String command)
    {
        output.printLineSeperator();
        if(command.equalsIgnoreCase("search"))
        {
            search(input.getInput("Would you like to search for movies or books?"));
        }
        else if(command.equalsIgnoreCase("save"))
        {
            output.printMessage("saving");
            textFileAdapter.saveCatalog(user,catalogItems);
        }
        else if(command.equalsIgnoreCase("view"))
        {
            view(input.getInput("Would you like to view your books or movies?"));
        }
        else if(command.equalsIgnoreCase("help"))
        {
            output.printMessage("Commands that can be used are:");
            output.printMessage("search");
            output.printMessage("save");
            output.printMessage("view");
            output.printMessage("help");
            output.printMessage("exit");
            output.printLineSeperator();
            executeCommand(input.getInput("Please enter a command"));
        }
        else if(command.equalsIgnoreCase("exit"))
        {
            output.printMessage("Exiting");
        }
        else
        {
            executeCommand(input.getInput("Incorrect command, please enter another command"));
        }
    }

    public void view(String option)
    {
        if(option.equalsIgnoreCase("books"))
        {
            for (CatalogItem item:catalogItems)
            {
                if(item.getClass().getName().equalsIgnoreCase("CatalogItems.CatalogItem.Book"))
                {
                    output.printMessage("Title: "+item.getTitle()+" State: "+item.getState());
                }
            }
            selectView(input.getInput("Please type your selected item to view in more detail"),"books");
        }
        else if(option.equalsIgnoreCase("movies"))
        {

        }
        else if(option.equalsIgnoreCase("back"))
        {
            executeCommand(input.getInput("Please enter a command"));
        }
        else {
            output.printMessage("This is not one of the options please try again:");
            executeCommand("view");
        }
    }

    public void selectView(String option, String type)
    {
        if(type.equalsIgnoreCase("books"))
        {
            for (CatalogItem item:catalogItems)
            {
                if(item.getTitle().equalsIgnoreCase(option))
                {
                    printCatalogItem(item);
                }
            }
            String response = input.getInput("If you would like to change the state of this item please type 'Change state' else type 'back'");

            if(response.equalsIgnoreCase("Change state"))
            {
                for (CatalogItem item:catalogItems)
                {
                    if(item.getTitle().equalsIgnoreCase(option))
                    {
                        switchStateEvent = new CatalogItemEvent(new SwitchState(item));
                        switchStateEvent.event();
                    }
                }
            }
            else
            {
                view("books");
            }
        }
        else if(type.equalsIgnoreCase("movies"))
        {
            output.printMessage("Test");
        }
    }

    public void search(String option)
    {
        if(option.equalsIgnoreCase("books"))
        {
            for (String title:xmlReaderAdapter.getTitles(input.getInput("Please enter a search query:")))
            {
                output.printMessage(title);
            }
            selectSearch(input.getInput("Please type your selected title to view in more detail"),"books");
        }
        else if(option.equalsIgnoreCase("movies"))
        {
            for(String title:jsonReader.getTitles(input.getInput("Please enter a search query:")))
            {
                output.printMessage(title);
            }
            selectSearch(input.getInput("Please type your selected title to view in more detail"),"movies");
        }
        else if(option.equalsIgnoreCase("back"))
        {
            executeCommand(input.getInput("Please enter a command"));
        }
        else {
            output.printMessage("This is not one of the options please try again:");
            executeCommand("search");
        }
    }

    public void selectSearch(String option, String type)
    {
        if(type.equalsIgnoreCase("books"))
        {
            printItem(xmlReaderAdapter.createDetails(option),"book");
            if(input.getInput("Would you like to add this to your catalog? Y/N").equalsIgnoreCase("y"))
            {
                createItem(xmlReaderAdapter.createDetails(option),"book");
                output.printMessage("added");
                executeCommand(input.getInput("Please enter a command"));
            }
            else
            {
                search("books");
            }
        }
        else if(type.equalsIgnoreCase("movies"))
        {
            printItem(jsonReader.createDetails(option),"movie");
            if(input.getInput("Would you like to add this to your catalog? Y/N").equalsIgnoreCase("y"))
            {
                createItem(jsonReader.createDetails(option),"movie");
                output.printMessage("added");
                executeCommand("Please enter a command");
            }
            else
            {
                search("movies");
            }
        }
    }

    public void createItem(HashMap<String, String> object, String objectType)
    {
        if(objectType.equalsIgnoreCase("book"))
        {
            catalogItems.add(new Book(object.get("Title"),object.get("Author"),Integer.parseInt(object.get("Year")),Double.parseDouble(object.get("Rated")),"",""));
        }
        else if(objectType.equalsIgnoreCase("movie"))
        {
            catalogItems.add(new Movie(object.get("Title"),object.get("Director"),object.get("Plot"),Integer.parseInt(object.get("Year")),object.get("Genre"),Double.parseDouble(object.get("Rated")),""));
        }
    }

    public void printItem(HashMap<String,String> object, String objectType)
    {
        if(objectType.equalsIgnoreCase("book"))
        {
            output.printMessage("Title: "+object.get("Title"));
            output.printMessage("Author: "+object.get("Author"));
            output.printMessage("Year: "+object.get("Year"));
            output.printMessage("Rated: "+object.get("Rated"));
        }
        else if(objectType.equalsIgnoreCase("movie"))
        {
            output.printMessage("Title: "+object.get("Title"));
            output.printMessage("Director: "+object.get("Director"));
            output.printMessage("Year: "+object.get("Year"));
            output.printMessage("Rated: "+object.get("Rated"));
            output.printMessage("Genre: "+object.get("Genre"));
            output.printMessage("Plot: "+ object.get("Plot"));
        }
    }

    public void printCatalogItem(CatalogItem item)
    {
        if(item.getClass().getName().equalsIgnoreCase("CatalogItems.CatalogItem.Book"))
        {
            Book bookItem = (Book)item;
            output.printMessage("Title: "+bookItem.getTitle());
            output.printMessage("Author: "+bookItem.getCreator());
            output.printMessage("Year: "+bookItem.getYear());
            output.printMessage("Rated: "+bookItem.getRating());
            output.printMessage("State: "+bookItem.getState());
            output.printMessage("Start Date:"+ bookItem.getStartDate());
            output.printMessage("End Date:"+ bookItem.getFinishedDate());
        }
        else if(item.getClass().getName().equalsIgnoreCase("CatalogItems.CatalogItem.Movie"))
        {
            Movie movieItem = (Movie)item;
            output.printMessage("Title: "+movieItem.getTitle());
            output.printMessage("Director: "+movieItem.getCreator());
            output.printMessage("Year: "+movieItem.getYear());
            output.printMessage("Rated: "+movieItem.getRating());
            output.printMessage("Genre: "+movieItem.getGenre());
            output.printMessage("Plot: "+movieItem.getDescription());
            output.printMessage("State: "+movieItem.getState());
            output.printMessage("Watched Date: "+movieItem.getWatchedDate());
        }
    }

}
