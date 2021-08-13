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
public class AddProductErrorDTO implements Serializable {
    private String productIDError, priceError, quantityError, productNameError, brandError;

    public AddProductErrorDTO() {
    }

    public AddProductErrorDTO(String productNameError, String brandError, String productIDError, String priceError, String quantityError) {
        this.productIDError = productIDError;
        this.priceError = priceError;
        this.quantityError = quantityError;
        this.productNameError = productNameError;
        this.brandError = brandError;
    }

    public String getProductNameError() {
        return productNameError;
    }

    public void setProductNameError(String productNameError) {
        this.productNameError = productNameError;
    }

    public String getBrandError() {
        return brandError;
    }

    public void setBrandError(String brandError) {
        this.brandError = brandError;
    }

    
    public String getProductIDError() {
        return productIDError;
    }

    public void setProductIDError(String productIDError) {
        this.productIDError = productIDError;
    }

    public String getPriceError() {
        return priceError;
    }

    public void setPriceError(String priceError) {
        this.priceError = priceError;
    }

    public String getQuantityError() {
        return quantityError;
    }

    public void setQuantityError(String quantityError) {
        this.quantityError = quantityError;
    }
    
    
    
}
