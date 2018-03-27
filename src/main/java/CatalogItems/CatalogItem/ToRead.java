package CatalogItems.CatalogItem;

public class ToRead implements BookState {
    @Override
    public void goNext(Book wrapper) {
        wrapper.setState(new CurrentlyReading());
    }

    @Override
    public String getState() {
        return "To Read";
    }
}
