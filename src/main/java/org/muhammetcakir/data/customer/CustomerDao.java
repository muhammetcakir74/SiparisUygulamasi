package org.muhammetcakir.data.customer;

import org.muhammetcakir.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    private List<Customer> customers = new ArrayList<>();

    public CustomerDao() {

    }

    public Customer add(Customer customer){
        customers.add(customer);
        return customer;
    }

    public List<Customer> getAll(){
        return customers;
    }

    public int numberOfCustomers(){
        return customers.size() > 0 ? customers.size() : 0;
    }

}
