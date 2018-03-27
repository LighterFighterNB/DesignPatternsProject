package Storage;

import CatalogItems.CatalogItem.CatalogItem;

import java.util.ArrayList;

public class TextFileAdapter implements StorageInterface {

    TextFile textFile;

    public TextFileAdapter(TextFile textFile)
    {
        this.textFile = textFile;
    }

    @Override
    public void createNewCatalog(String userName) {
        textFile.createNewTextFile(userName);
    }

    @Override
    public boolean checkUser(String userName) {
        return textFile.findTextFileBasedOn(userName);
    }

    @Override
    public void saveCatalog(String userName) {
        textFile.saveToTextFile(userName);
    }

    @Override
    public ArrayList<CatalogItem> loadCatalog(String userName) {
        return textFile.loadCatalog(userName);
    }
}
