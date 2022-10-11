/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.math.BigDecimal;

/**
 *
 * @author Nguyen Duy Hung
 */
public class ManageProductDetail {
    private String id;
    private ManageProduct manageProduct;
    private ManageCategory manageCategory;
    private ManageColor manageColor;
    private ManageManufacturer manageManufacturer;
    private int warrantyYear;
    private String decription;
    private int quantity;
    private BigDecimal importPrice;
    private BigDecimal price;

    public ManageProductDetail() {
    }

    public ManageProductDetail(String id,ManageProduct manageProduct, ManageCategory manageCategory, ManageColor manageColor, ManageManufacturer manageManufacturer, int warrantyYear, String decription, int quantity, BigDecimal importPrice, BigDecimal price) {
        this.id = id;
        this.manageProduct = manageProduct;
        this.manageCategory = manageCategory;
        this.manageColor = manageColor;
        this.manageManufacturer = manageManufacturer;
        this.warrantyYear = warrantyYear;
        this.decription = decription;
        this.quantity = quantity;
        this.importPrice = importPrice;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ManageProduct getManageProduct() {
        return manageProduct;
    }

    public void setManageProduct(ManageProduct manageProduct) {
        this.manageProduct = manageProduct;
    }

    public ManageCategory getManageCategory() {
        return manageCategory;
    }

    public void setManageCategory(ManageCategory manageCategory) {
        this.manageCategory = manageCategory;
    }

    public ManageColor getManageColor() {
        return manageColor;
    }

    public void setManageColor(ManageColor manageColor) {
        this.manageColor = manageColor;
    }

    public ManageManufacturer getManageManufacturer() {
        return manageManufacturer;
    }

    public void setManageManufacturer(ManageManufacturer manageManufacturer) {
        this.manageManufacturer = manageManufacturer;
    }

    public int getWarrantyYear() {
        return warrantyYear;
    }

    public void setWarrantyYear(int warrantyYear) {
        this.warrantyYear = warrantyYear;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(BigDecimal importPrice) {
        this.importPrice = importPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.manageProduct.getName();
    }
    
}
