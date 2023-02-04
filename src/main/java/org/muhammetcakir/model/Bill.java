package org.muhammetcakir.model;

import org.muhammetcakir.model.BaseModel;
import org.muhammetcakir.model.Company;
import org.muhammetcakir.model.Customer;
import org.muhammetcakir.model.Order;

import java.time.LocalDateTime;
import java.util.Date;

public class Bill extends BaseModel {
    public Bill(String id, LocalDateTime createdDate,Company company, Order order,double price) {
        super(id, createdDate);
        this.company = company;
        this.order = order;
        this.price = price;
    }

    private Company company;
    private Order order;
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }


    @Override
    public String toString() {
        return "Bill{" +
                "company=" + company +
                ", order=" + order +
                ", price=" + price +
                '}';
    }
}
