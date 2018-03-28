import API.JSONReader;
import API.XMLReader;
import API.XMLReaderAdapter;
import CatalogItems.CatalogItem.CatalogItem;
import CatalogItems.CatalogItem.Command.CatalogItemEvent;
import CatalogItems.CatalogItem.Command.GetState;
import Storage.TextFile;
import Storage.TextFileAdapter;

import java.util.ArrayList;

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

        }
        else if(command.equalsIgnoreCase("save"))
        {
            output.printMessage("saving");
            textFileAdapter.saveCatalog(user,catalogItems);
        }
        else if(command.equalsIgnoreCase("add"))
        {

        }
        else if(command.equalsIgnoreCase("view"))
        {
            view(input.getInput("Would you like to view your books or movies?"));
        }
        else if(command.equalsIgnoreCase("change state"))
        {

        }
        else if(command.equalsIgnoreCase("help"))
        {

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


}
