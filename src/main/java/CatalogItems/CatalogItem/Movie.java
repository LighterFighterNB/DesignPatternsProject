package CatalogItems.CatalogItem;

import java.time.LocalDate;

public class Movie extends CatalogItem {

    private String description;
    private String genre;
    private String watchedDate;
    private MovieState state;

    public Movie(String title, String creator, String description, int year, String genre, double rating, String watchedDate)
    {
        super(title, creator, year, rating);
        this.description = description;
        this.genre = genre;
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

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public String getWatchedDate()
    {
        return watchedDate;
    }

    public void watched()
    {
        watchedDate = LocalDate.now().toString();
    }

    public void setWatchedDate(String watchedDate)
    {
        this.watchedDate = watchedDate;
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
