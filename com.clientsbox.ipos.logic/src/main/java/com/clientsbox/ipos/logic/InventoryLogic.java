package com.clientsbox.ipos.logic;

import com.clientsbox.comclientsboxiposrepository.IInventoryRepository;
import com.clientsbox.ipos.transfer.object.InventoryCategory;
import com.clientsbox.ipos.transfer.object.InventoryItem;
import com.clientsbox.ipos.transfer.object.InventoryMenu;

import javax.inject.Inject;

public class InventoryLogic implements IInventoryLogic {

    private IInventoryRepository _inventoryRepository;

    @Inject
    public InventoryLogic(IInventoryRepository inventoryRepository){
        _inventoryRepository = inventoryRepository;
    }

    @Override
    public InventoryMenu getAllMenuByStoreId(int id) {
        return _inventoryRepository.getAllMenuByStoreId(id);
    }

    @Override
    public void deleteMenuByStoreId(int id) {
         _inventoryRepository.deleteMenuByStoreId(id);
    }

    @Override
    public void updateMenuByStoreId(InventoryMenu menu) {

    }

    @Override
    public void insertMenuByStoreId(InventoryMenu menu) {

    }

    @Override
    public InventoryCategory getAllCategoryByMenuId(int id) {
        return null;
    }

    @Override
    public void deleteCategoryByMenuId(int id) {

    }

    @Override
    public void updateCategoryByMenuId(InventoryCategory category) {

    }

    @Override
    public void insertCategoryByMenuId(InventoryCategory category) {

    }

    @Override
    public InventoryItem getAllItemByCategoryId(int id) {
        return null;
    }

    @Override
    public void deleteItemByCategoryId(int id) {

    }

    @Override
    public void updateItemByCategoryId(InventoryItem item) {

    }

    @Override
    public void insertItemByCategoryId(InventoryItem item) {

    }
}
