package CatalogItems.CatalogItem.Command;

public class CatalogItemEvent {
    private CatalogItemCommand command;

    public CatalogItemEvent(CatalogItemCommand command)
    {
        this.command = command;
    }
    public void event()
    {
        command.execute();
    }
}
