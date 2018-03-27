package CatalogItems.CatalogItem;

public class Watched implements MovieState{
    @Override
    public void goNext(Movie wrapper) {
        wrapper.setState(new ToWatch());
    }

    @Override
    public String getState() {
        return "Watched";
    }
}
