package CatalogItems.CatalogItem;

import java.time.LocalDate;

public class Book extends CatalogItem
{
    private String startedReading;
    private String finishedReading;
    private BookState state;

    public Book(String title, String creator, int year, double rating,String startedReading, String finishedReading)
    {
        super(title,creator,year,rating);
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
