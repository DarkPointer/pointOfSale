package se.kth.iv1350.sem3pos.integration;

import se.kth.iv1350.sem3pos.model.SaleDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides access to the external inventory system.
 */
public class InventorySystem {
    private ItemInfoDTO[] itemStorage;

    /**
     * Creates a new instance of the {@link InventorySystem}.
     */
    InventorySystem()
    {
        List<ItemInfoDTO> storageList = new ArrayList<ItemInfoDTO>();

        ItemInfoDTO milkItemInfo = new ItemInfoDTO("item1","Milk",10.0d, 0.06f);
        ItemInfoDTO breadItemInfo = new ItemInfoDTO("item2","Bread",5.0d, 0.06f);
        ItemInfoDTO wheatFlourItemInfo = new ItemInfoDTO("item3","Wheat flour",15.0d, 0.12f);
        ItemInfoDTO energyDrinkItemInfo = new ItemInfoDTO("item4","Energy drink",12.0d, 0.25f);

        storageList.add(milkItemInfo);
        storageList.add(breadItemInfo);
        storageList.add(wheatFlourItemInfo);
        storageList.add(energyDrinkItemInfo);

        this.itemStorage = storageList.toArray(new ItemInfoDTO[0]);
    }


    /**
     * Provides information about an item existing in the inventory.
     * @param itemId The identifier of the item to be fetched.
     * @return An {@link ItemInfoDTO} that provides information about the item description, prices excluding VAT and the VAT rate of the item.
     */
    public ItemInfoDTO getItemInfo(String itemId)
    {
        for (ItemInfoDTO item: this.itemStorage) {
            if(item.getId().equals(itemId))
            {
                return item;
            }

        }
        return null;
    }

    /**
     * Updates the inventory with a {@link SaleDTO} containing all available information about a sale.
     * @param saleInfo A sale data transfer object {@link SaleDTO} containing all available information about a sale.
     */
    public void updateInventory(SaleDTO saleInfo)
    {

    }
}
