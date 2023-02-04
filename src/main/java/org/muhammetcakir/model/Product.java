package org.muhammetcakir.model;

import java.time.LocalDateTime;

public class Product extends BaseModel{
    public Product(String id, LocalDateTime createdDate, String productName, double price, int stock) {
        super(id, createdDate);
        this.productName = productName;
        this.price = price;
        this.stock = stock;
    }

    private String productName;
    private double price;
    private int stock;
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", company=" + company +
                '}';
    }
}
