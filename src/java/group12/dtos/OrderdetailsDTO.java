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
public class OrderdetailsDTO implements Serializable {
    private int orderDetailID, orderID, quantity;
    private String productID;
    private float price;

    public OrderdetailsDTO() {
    }

    public OrderdetailsDTO(int orderDetailID, int orderID, String productID, float price, int quantity) {
        this.orderDetailID = orderDetailID;
        this.orderID = orderID;
        this.quantity = quantity;
        this.productID = productID;
        this.price = price;
    }

    public int getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(int orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
}
