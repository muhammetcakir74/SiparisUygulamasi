package org.muhammetcakir.service.impl.bill;

import org.muhammetcakir.data.customer.BillDao;
import org.muhammetcakir.model.Bill;
import org.muhammetcakir.model.Customer;
import org.muhammetcakir.service.IBaseService;

import java.util.List;
import java.util.stream.Collectors;

public class BillService implements IBillService<Bill> {

    private BillDao billDao;

    public BillService(BillDao billDao) {
        this.billDao = billDao;
    }

    @Override
    public Bill add(Bill item) {
        billDao.add(item);
        return item;
    }

    @Override
    public Bill delete(Bill item) {
        return null;
    }

    @Override
    public Bill update(Bill item) {
        return null;
    }

    @Override
    public List<Bill> getAll() {
        return billDao.getAll();
    }

    @Override
    public Bill findById(String id) {
        return null;
    }

    @Override
    public double totalBillAmountOfCustomerThatRegisterInJune(){
        List<Bill> billList = billDao.getAll();
        return billList.stream().filter(b -> String.valueOf(b.getOrder().getCustomer().getCreatedDate().getMonth()).equals("JUNE")).mapToDouble(b -> b.getPrice()).sum();
    };

    @Override
    public List<Bill> billThatPriceIsOverOneThousandFiveHundred(){
        List<Bill> billList = billDao.getAll();
        return billList.stream().filter(b -> b.getPrice() > 1500).collect(Collectors.toList());
    }

    @Override
    public double averageBillThatPriceIsOverOneThousandFiveHundred(){
        List<Bill> billList = billDao.getAll();
        return billList.stream().filter(b -> b.getPrice() > 1500).mapToDouble(b -> b.getPrice()).sum()/billList.size();
    }

    @Override
    public List<Customer> customerThatHaveUnderFiveHundredAmountBill(){
        return billDao.getAll().stream().filter(b -> b.getPrice() < 500).map(b -> b.getOrder().getCustomer()).collect(Collectors.toList());
    };




}
