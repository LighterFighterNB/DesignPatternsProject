package CatalogItems.CatalogItem;

public class Movie implements CatalogItem {

    private String title;
    private String creator;
    private String description;
    private int year;
    private String genre;
    private int rating;
    private String watchedDate;
    private MovieState state;

    public Movie(String title, String creator, String description, int year, String genre, int rating, String watchedDate)
    {
        this.title = title;
        this.creator=creator;
        this.description = description;
        this.year = year;
        this.rating = rating;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating =rating;
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
