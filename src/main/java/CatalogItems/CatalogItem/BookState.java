package CatalogItems.CatalogItem;

public interface BookState {
    void goNext(Book wrapper);
    String getState();
}
