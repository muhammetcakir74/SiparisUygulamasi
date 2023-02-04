package org.muhammetcakir.service.impl.order;

import org.muhammetcakir.data.customer.OrderDao;
import org.muhammetcakir.model.Order;

import java.util.List;

public class OrderService implements IOrderService<Order>{

    private OrderDao orderDao;

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public Order add(Order item) {
        orderDao.add(item);
        return item;
    }

    @Override
    public Order delete(Order item) {
        return null;
    }

    @Override
    public Order update(Order item) {
        return null;
    }

    @Override
    public List<Order> getAll() {
        return orderDao.getAll();
    }

    @Override
    public Order findById(String id) {
        return null;
    }
}
