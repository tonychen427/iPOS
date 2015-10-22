package com.clientsbox.ipos.repository;


import com.clientsbox.ipos.transfer.object.InventoryCategory;
import com.clientsbox.ipos.transfer.object.InventoryMenu;
import com.clientsbox.ipos.transfer.object.InventoryItem;

import java.util.ArrayList;
import java.util.List;

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

        List<InventoryItem> mInventoryItemHamburger = new ArrayList<>();
        mInventoryItemHamburger.add(new InventoryItem(001, "Hamburger 01", "number 1","Beef","5","img001.png",1.99, true));
        mInventoryItemHamburger.add(new InventoryItem(002, "Hamburger 02", "number 2","Beef","5","img001.png",2.99, true));
        mInventoryItemHamburger.add(new InventoryItem(003, "Hamburger 03", "number 3","Beef","5","img001.png",3.99, true));
        mInventoryItemHamburger.add(new InventoryItem(004, "Hamburger 04", "number 4","Beef","5","img001.png",4.99, true));
        mInventoryItemHamburger.add(new InventoryItem(005, "Hamburger 05", "number 5", "Beef", "5", "img001.png", 5.99, true));

        List<InventoryItem> mInventoryItemDrink = new ArrayList<>();
        mInventoryItemDrink.add(new InventoryItem(001, "Cola", "number 1","Beef","5","img001.png",0.75, true));
        mInventoryItemDrink.add(new InventoryItem(002, "Root Beer", "number 2","Beef","5","img001.png",0.85, true));
        mInventoryItemDrink.add(new InventoryItem(003, "Pipse", "number 3","Beef","5","img001.png",0.99, true));


        List<InventoryCategory> mInventoryCategory = new ArrayList<>();
        mInventoryCategory.add(new InventoryCategory(010,"Hamburger","Main Dishes", mInventoryItemHamburger));
        mInventoryCategory.add(new InventoryCategory(010,"Drink","Soft Drinks", mInventoryItemDrink));

        return new InventoryMenu(id,"test","sub test",mInventoryCategory);
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
