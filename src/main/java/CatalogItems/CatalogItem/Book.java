package CatalogItems.CatalogItem;

import java.time.LocalDate;

public class Book implements CatalogItem
{
    private String title;
    private String creator;
    private String description;
    private int year;
    private String genre;
    private int rating;
    private String startedReading;
    private String finishedReading;
    private BookState state;

    public Book(String title, String creator, String description, int year, String genre, int rating,String startedReading, String finishedReading)
    {
        this.title = title;
        this.creator=creator;
        this.description = description;
        this.year = year;
        this.rating = rating;
        this.startedReading = startedReading;
        this.finishedReading = finishedReading;
        if(startedReading.equalsIgnoreCase(""))
        {
            state = new ToRead();
        }
        else if(finishedReading.equalsIgnoreCase(""))
        {
            state = new CurrentlyReading();
        }
        else
        {
            state = new Read();
        }
    }

    public Book()
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

    public String getStartDate()
    {
        return startedReading;
    }

    public void setStartDate(String startedReading)
    {
        this.startedReading = startedReading;
    }

    public void StartedReading()
    {
        startedReading = LocalDate.now().toString();
    }

    public String getFinishedDate()
    {
        return finishedReading;
    }

    public void setFinishedDate(String finishedReading)
    {
        this.finishedReading = finishedReading;
    }

    public void finishedReading()
    {
        finishedReading = LocalDate.now().toString();
    }

    public String getState() {
        return state.getState();
    }

    public void setState(BookState s) {
        state = s;
    }

    public void nextState() {
        state.goNext(this);
    }
}
