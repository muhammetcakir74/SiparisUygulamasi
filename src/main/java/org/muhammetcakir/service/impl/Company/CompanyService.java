package org.muhammetcakir.service.impl.Company;

import org.muhammetcakir.data.customer.CompanyDao;
import org.muhammetcakir.model.Company;
import org.muhammetcakir.model.Customer;

import java.util.List;

public class CompanyService implements ICompanyService<Company>{

    private CompanyDao companyDao;

    public CompanyService(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @Override
    public Company add(Company item) {
        companyDao.add(item);
        return item;
    }

    @Override
    public Company delete(Company item) {
        return null;
    }

    @Override
    public Company update(Company item) {
        return null;
    }

    @Override
    public List<Company> getAll() {
        return companyDao.getAll();
    }

    @Override
    public Company findById(String id) {
        for (Company company:companyDao.getAll()){
            if(company.getId().equals(id)){
                return company;
            }
        }
        return null;
    }
}
