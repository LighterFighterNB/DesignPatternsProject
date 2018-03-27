package CatalogItems.CatalogItem;

public interface CatalogItem {

    String getTitle();
    void setTitle(String title);

    String getCreator();
    void setCreator(String creator);

    String getDescription();
    void setDescription();



    int getYear();
    void setYear();

    String getGenre();
    void setGenre();

    String getRating();
    void setRating();

    Object getState();
    void setState(String state);
    void nextState();
}
