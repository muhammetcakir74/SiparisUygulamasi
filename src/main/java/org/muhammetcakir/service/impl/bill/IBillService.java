package org.muhammetcakir.service.impl.bill;

import org.muhammetcakir.model.Bill;
import org.muhammetcakir.model.Customer;
import org.muhammetcakir.service.IBaseService;

import java.util.List;

public interface IBillService<T> extends IBaseService<T> {

    public double totalBillAmountOfCustomerThatRegisterInJune();

    public List<Bill> billThatPriceIsOverOneThousandFiveHundred();
    public double averageBillThatPriceIsOverOneThousandFiveHundred();

    public List<Customer> customerThatHaveUnderFiveHundredAmountBill();


}
