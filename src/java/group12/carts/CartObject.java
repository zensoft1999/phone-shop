/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group12.carts;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ASUS-PC
 */
public class CartObject implements Serializable {

    private String userID;
    Map<String, Integer> items;

    public String getUserID() {
        return userID;
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void addItemToCart(String productID) {
        if (this.items == null) {
            this.items = new HashMap<String, Integer>();
        }
        int quantity = 1;
        if (this.items.containsKey(productID)) {
            quantity = this.items.get(productID) + 1;
        }
        this.items.put(productID, quantity);
    }

    public void removeItemToCart(String title) {
        if (this.items == null) {
            return;
        }
        if (this.items.containsKey(title)) {
            this.items.remove(title);
            if (this.items.isEmpty()) {
                this.items = null;
            }
        }
    }
}
