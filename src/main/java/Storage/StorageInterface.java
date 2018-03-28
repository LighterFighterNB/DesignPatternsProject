package Storage;

import CatalogItems.CatalogItem.CatalogItem;

import java.util.ArrayList;

public interface StorageInterface {
    void createNewCatalog(String userName);
    boolean checkUser(String userName);
    void saveCatalog(String userName, ArrayList<CatalogItem> catalogItems);
    ArrayList<CatalogItem> loadCatalog(String userName);
}
