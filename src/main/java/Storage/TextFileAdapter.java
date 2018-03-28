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
<<<<<<< HEAD
    public void saveCatalog(String userName) {
        //textFile.saveToTextFile(userName);
=======
    public void saveCatalog(String userName, ArrayList<CatalogItem> catalogItems) {
        textFile.saveToTextFile(userName, catalogItems);
>>>>>>> f50b7886f22b660a5158319c451d16296a050799
    }

    @Override
    public ArrayList<CatalogItem> loadCatalog(String userName) {
        return textFile.loadCatalog(userName);
    }
}
