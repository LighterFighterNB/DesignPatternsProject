package CatalogItems.CatalogItem;

public class Book implements CatalogItem
{
    private String title;
    private String creator;
    private String description;
    private int year;
    private String genre;
    private BookState state;

    public Book(String title, String creator, String description, int year, String genre, BookState state)
    {
        this.title = title;
        this.creator=creator;
        this.description = description;
    }

    public Book()
    {

    }

    public String getTitle() {
        return null;
    }

    public void setTitle(String title) {

    }

    public String getCreator() {
        return null;
    }

    public void setCreator(String creator) {

    }

    public String getDescription() {
        return null;
    }

    public void setDescription() {

    }

    public int getYear() {
        return 0;
    }

    public void setYear() {

    }

    public String getGenre() {
        return null;
    }

    public void setGenre() {

    }

    public String getRating() {
        return null;
    }

    public void setRating() {

    }

    public Object getState() {
        return null;
    }

    public void setState(String state) {

    }

    public void nextState() {

    }
}
