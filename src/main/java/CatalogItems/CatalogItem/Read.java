package CatalogItems.CatalogItem;

public class Read implements BookState{
    @Override
    public void goNext(Book wrapper) {
        wrapper.setState(new CurrentlyReading());
    }

    @Override
    public String getState() {
        return "Read";
    }
}
