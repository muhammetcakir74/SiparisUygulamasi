package org.muhammetcakir.data.customer;

import org.muhammetcakir.model.Bill;
import org.muhammetcakir.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class BillDao {
    private List<Bill> bills = new ArrayList<>();

    public BillDao() {

    }

    public Bill add(Bill bill){
        bills.add(bill);
        return bill;
    }

    public List<Bill> getAll(){
        return bills;
    }

    public int numberOfBills(){
        return bills.size() > 0 ? bills.size() : 0;
    }

}
