package org.muhammetcakir.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Order extends BaseModel{
    public Order(String id, LocalDateTime createdDate, Product product, Customer customer) {
        super(id, createdDate);
        this.product = product;
        this.customer = customer;
    }

    private Product product;
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProducts() {
        return product;
    }

    public void setProducts(Product product) {
        this.product = product;
    }
}
