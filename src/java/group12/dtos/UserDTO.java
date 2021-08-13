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
public class UserDTO implements Serializable {
    private String userID, fullName, address, roleID;
    private int password, phone;

    public UserDTO() {
    }

    public UserDTO(String userID, String fullName, String address, int phone, String roleID, int password) {
        this.userID = userID;
        this.fullName = fullName;
        this.address = address;
        this.roleID = roleID;
        this.password = password;
        this.phone = phone;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    
}
