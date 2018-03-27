package CatalogItems.CatalogItem;

public class CurrentlyReading implements BookState{
    @Override
    public void goNext(Book wrapper) {
        wrapper.setState(new Read());
    }

    @Override
    public String getState() {
        return "Currently Reading";
    }
}
