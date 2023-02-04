package org.muhammetcakir.data.customer;

import org.muhammetcakir.model.Company;
import org.muhammetcakir.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CompanyDao {
    private List<Company> companies = new ArrayList<>();

    public CompanyDao() {

    }

    public Company add(Company company){
        companies.add(company);
        return company;
    }

    public List<Company> getAll(){
        return companies;
    }

    public int getNumberOfCompanies(){
        return companies.size() > 0 ? companies.size() : 0;
    }


}
