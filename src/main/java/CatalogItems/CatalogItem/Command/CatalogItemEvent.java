package CatalogItems.CatalogItem.Command;

public class CatalogItemEvent {
    CatalogItemCommand command;

    public CatalogItemEvent(CatalogItemCommand command)
    {
        this.command = command;
    }
    public void event()
    {
        command.execute();
    }
}
