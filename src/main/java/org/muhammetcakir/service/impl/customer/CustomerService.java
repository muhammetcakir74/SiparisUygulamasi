package org.muhammetcakir.service.impl.customer;

import org.muhammetcakir.data.customer.CustomerDao;
import org.muhammetcakir.model.Customer;
import org.muhammetcakir.model.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CustomerService implements ICustomerService<Customer> {

    private CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    @Override
    public Customer add(Customer item) {
        customerDao.add(item);
        return item;
    }

    @Override
    public Customer delete(Customer item) {
        return null;
    }

    @Override
    public Customer update(Customer item) {
        return null;
    }

    @Override
    public List<Customer> getAll() {
        return customerDao.getAll();
    }

    @Override
    public Customer findById(String id) {
        for (Customer customer:customerDao.getAll()){
            if(customer.getId().equals(id)){
                return customer;
            }
        }
        return null;
    }


    public Customer addCustomer(String customerName, String customerLastName, String customerAddress) {
        Customer newCustomer = new Customer(String.valueOf(customerDao.numberOfCustomers()), LocalDateTime.now(),customerName,customerLastName,customerAddress);
        customerDao.add(newCustomer);
        return newCustomer;
    }

    public List<Customer> getCustomersFilterAccordingToName(String character){
        List<Customer> filteredCustomers = new ArrayList<>();
        for (Customer customer:customerDao.getAll()){
            if (customer.getFirstName().contains(character) || customer.getLastName().contains(character)){
                filteredCustomers.add(customer);
            }
        }
        return filteredCustomers;
    }








}
