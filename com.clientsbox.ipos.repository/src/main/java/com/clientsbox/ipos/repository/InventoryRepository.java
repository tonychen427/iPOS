package com.clientsbox.ipos.repository;




import com.clientsbox.ipos.transfer.object.InventoryCategory;
import com.clientsbox.ipos.transfer.object.InventoryMenu;
import com.clientsbox.ipos.transfer.object.InventoryItem;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ttran on 10/14/15.
 */

@Module
public class InventoryRepository implements IInventoryRepository {

    @Inject
    public InventoryRepository(){

    }

    @Override
    public InventoryMenu getAllMenuByStoreId(int id) {

        return new InventoryMenu(id,"test","sub test",null);
    }

    @Override
    public void deleteMenuByStoreId(int id) {

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
