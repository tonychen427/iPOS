package com.clientsbox.ipos.transfer.object;

import java.util.List;

/**
 * Created by ttran on 10/14/15.
 */
public class InventoryMenu {
    int id;
    String title;
    String subTitle;
    List<InventoryCategory> categoryList;

    public InventoryMenu(int id, String title, String subTitle, List<InventoryCategory> categoryList) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.categoryList = categoryList;
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

    public List<InventoryCategory> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<InventoryCategory> categoryList) {
        this.categoryList = categoryList;
    }
}
