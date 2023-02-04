package org.muhammetcakir.service.impl.customer;

import org.muhammetcakir.model.Customer;
import org.muhammetcakir.service.IBaseService;

import java.util.List;

public interface ICustomerService<T> extends IBaseService<T> {

    public Customer addCustomer(String customerName, String customerLastName, String customerAddress);
    public List<Customer> getCustomersFilterAccordingToName(String character);

}
