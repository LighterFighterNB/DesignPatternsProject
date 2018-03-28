package CatalogItems.CatalogItem.Command;

import CatalogItems.CatalogItem.CatalogItem;

public class SwitchState implements CatalogItemCommand {
    private CatalogItem item;

    public SwitchState(CatalogItem item)
    {
        this.item = item;
    }

    @Override
    public void execute() {
        item.nextState();
    }
}
