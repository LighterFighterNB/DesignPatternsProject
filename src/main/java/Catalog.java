import API.JSONReader;
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

    public Catalog()
    {
        catalogItems = new ArrayList<>();
        jsonReader = new JSONReader();
        xmlReaderAdapter = new XMLReaderAdapter();
        textFileAdapter = new TextFileAdapter(new TextFile());
        input = new UserInput();
        output = new UserOutput();
    }

    public void start()
    {

    }


}
