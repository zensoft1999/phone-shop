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
public class ShowInfoDTO implements Serializable {
    private String productName, image, productID;
    private float price;

    public ShowInfoDTO() {
    }

    public ShowInfoDTO(String productID, String productName, String image, float price) {
        this.productID = productID;
        this.productName = productName;
        this.image = image;
        this.price = price;
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
    
    
}
