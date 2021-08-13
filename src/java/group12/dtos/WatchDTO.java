/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group12.dtos;

import java.io.Serializable;

/**
 *
 * @author ASUS-PC
 */
public class WatchDTO implements Serializable {
    
    private String productID, productName, categoryID, brand, image;
    private float price;
    private int quantity;

    public WatchDTO() {
    }

    public WatchDTO(String productID, String productName, float price, int quantity , String categoryID, String brand, String image) {
        this.productID = productID;
        this.productName = productName;
        this.categoryID = categoryID;
        this.brand = brand;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
