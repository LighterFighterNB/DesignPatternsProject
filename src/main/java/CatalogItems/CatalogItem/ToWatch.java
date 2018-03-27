package CatalogItems.CatalogItem;

public class ToWatch implements MovieState{
    @Override
    public void goNext(Movie wrapper) {
        wrapper.setState(new Watched());
    }

    @Override
    public String getState() {
        return "To Watch";
    }
}
