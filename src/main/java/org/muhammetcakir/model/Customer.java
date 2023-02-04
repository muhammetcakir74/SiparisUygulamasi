package org.muhammetcakir.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Customer extends BaseModel{
    public Customer(String id, LocalDateTime createdDate,String firstName, String lastName, String address) {
        super(id, createdDate);
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    private String firstName;
    private String lastName;
    private String address;
    private List<Bill> bills;

    public List<Bill> getOrders() {
        return bills;
    }

    public void setOrder(Bill bill) {
        this.bills.add(bill);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + getId() + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", creadetDate='" + getCreatedDate() + '\'' +
                ", bills=" + bills +
                '}';
    }
}
