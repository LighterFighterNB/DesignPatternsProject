package CatalogItems.CatalogItem;

public interface CatalogItem {

    String getTitle();
    void setTitle(String title);

    String getCreator();
    void setCreator(String creator);

    String getDescription();
    void setDescription(String description);

    int getYear();
    void setYear(int year);

    String getGenre();
    void setGenre(String genre);

    int getRating();
    void setRating(int rating);
}
