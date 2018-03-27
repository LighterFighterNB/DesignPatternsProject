package Storage;

import CatalogItems.CatalogItem.CatalogItem;

import java.util.ArrayList;

public class Database implements StorageInterface {
    @Override
    public void createNewCatalog(String userName) {

    }

    @Override
    public boolean checkUser(String userName) {
        return false;
    }

    @Override
    public void saveCatalog(String userName) {

    }

    @Override
    public ArrayList<CatalogItem> loadCatalog(String userName) {
        return null;
    }
}
