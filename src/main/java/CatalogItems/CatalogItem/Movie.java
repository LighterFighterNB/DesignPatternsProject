package CatalogItems.CatalogItem;

public class Movie extends CatalogItem {

    private String watchedDate;
    private MovieState state;

    public Movie(String title, String creator, String description, int year, String genre, int rating, String watchedDate)
    {
        super(title, creator, description, year, genre, rating);
        this.watchedDate = watchedDate;
        if(watchedDate.equalsIgnoreCase(""))
        {
            state = new ToWatch();
        }
        else
        {
            state = new Watched();
        }
    }

    public Movie()
    {

    }

    public String getState() {
        return state.getState();
    }

    public void setState(MovieState s) {
        state = s;
    }

    public void nextState() {
        state.goNext(this);
    }
}
