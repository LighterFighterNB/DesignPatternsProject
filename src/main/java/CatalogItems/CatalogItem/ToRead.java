package CatalogItems.CatalogItem;

public class ToRead implements BookState {
    @Override
    public void goNext(Book wrapper) {
        wrapper.setState(new CurrentlyReading());
        wrapper.startedReading();
        System.out.println("State test: " + wrapper.getStartDate());
    }

    @Override
    public String getState() {
        return "To Read";
    }
}
