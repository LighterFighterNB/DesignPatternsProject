package CatalogItems.CatalogItem.Command;

import CatalogItems.CatalogItem.CatalogItem;

public class GetState implements CatalogItemCommand {
    private CatalogItem item;

    public GetState(CatalogItem item)
    {
        this.item = item;
    }

    @Override
    public void execute() {
        System.out.print(item.getState());
    }
}
