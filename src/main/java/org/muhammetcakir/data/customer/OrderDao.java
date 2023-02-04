package org.muhammetcakir.data.customer;

import org.muhammetcakir.model.Customer;
import org.muhammetcakir.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderDao {

    private List<Order> orders = new ArrayList<>();


    public Order add(Order order){
        orders.add(order);
        return order;
    }

    public List<Order> getAll(){
        return orders;
    }

    public int numberOfOrders(){
        return orders.size() > 0 ? orders.size() : 0;
    }


}
