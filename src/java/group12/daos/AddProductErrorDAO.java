/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group12.daos;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ASUS-PC
 */
public class AddProductErrorDAO implements Serializable {

    public boolean checkInput(String input) {
        String regex = "^[A-Za-z0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        if (pattern.matcher(input).find()) {
            return true;
        } else {
            return false;
        }
    }
}
