package CatalogItems.CatalogItem;

public abstract class CatalogItem {

    private String title;
    private String creator;
    private int year;
    private double rating;

    public CatalogItem(String title, String creator, int year, double rating)
    {
        this.title = title;
        this.creator=creator;
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


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public double getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public abstract String getState();

    public abstract void nextState();
}
