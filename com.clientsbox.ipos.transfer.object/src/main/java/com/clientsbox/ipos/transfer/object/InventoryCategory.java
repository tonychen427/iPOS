package com.clientsbox.ipos.transfer.object;

import java.util.List;

/**
 * Created by ttran on 10/14/15.
 */
public class InventoryCategory {
    int id;
    String title;
    String subTitle;
    List<InventoryItem> itemList;

    public InventoryCategory(int id, String title, String subTitle, List<InventoryItem> itemList) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.itemList = itemList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public List<InventoryItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<InventoryItem> itemList) {
        this.itemList = itemList;
    }
}
