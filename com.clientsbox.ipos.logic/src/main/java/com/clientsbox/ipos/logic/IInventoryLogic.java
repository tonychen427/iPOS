package com.clientsbox.ipos.logic;

import com.clientsbox.ipos.transfer.object.InventoryCategory;
import com.clientsbox.ipos.transfer.object.InventoryItem;
import com.clientsbox.ipos.transfer.object.InventoryMenu;

import dagger.Component;

public interface IInventoryLogic {

    InventoryMenu getAllMenuByStoreId(int id);
    void deleteMenuByStoreId(int id);
    void updateMenuByStoreId(InventoryMenu menu);
    void insertMenuByStoreId(InventoryMenu menu);

    InventoryCategory getAllCategoryByMenuId(int id);
    void deleteCategoryByMenuId(int id);
    void updateCategoryByMenuId(InventoryCategory category);
    void insertCategoryByMenuId(InventoryCategory category);

    InventoryItem getAllItemByCategoryId(int id);
    void deleteItemByCategoryId(int id);
    void updateItemByCategoryId(InventoryItem item);
    void insertItemByCategoryId(InventoryItem item);
}
