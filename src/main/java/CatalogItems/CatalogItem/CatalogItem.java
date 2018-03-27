package CatalogItems.CatalogItem;

public abstract class CatalogItem {

    private String title;
    private String creator;
    private String description;
    private int year;
    private String genre;
    private int rating;

    public CatalogItem(String title, String creator, String description, int year, String genre, int rating)
    {
        this.title = title;
        this.creator=creator;
        this.description = description;
        this.year = year;
        this.rating = rating;
    }

    public CatalogItem()
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
        this.rating = rating;
    }

    abstract String getState();

    abstract void nextState();
}
