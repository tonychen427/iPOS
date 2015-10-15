package com.clientsbox.ipos.transfer.object;

/**
 * Created by ttran on 10/14/15.
 */
public class InventoryItem {
    int id;
    String title;
    String subTitle;
    String description;
    String rating;
    String images;
    double price;
    boolean enable;

    public InventoryItem(int id, String title, String subTitle, String description, String rating, String images, double price, boolean enable) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.description = description;
        this.rating = rating;
        this.images = images;
        this.price = price;
        this.enable = enable;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
