package org.muhammetcakir.utils;

import org.muhammetcakir.data.customer.CompanyDao;
import org.muhammetcakir.data.customer.CustomerDao;
import org.muhammetcakir.data.customer.ProductDao;
import org.muhammetcakir.model.Company;
import org.muhammetcakir.model.Customer;
import org.muhammetcakir.model.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DefaultModelCreator {
    public List<Company> companyInstances = new ArrayList<>();
    private List<Product> productInstances = new ArrayList<>();
    private List<Customer> customerInstances = new ArrayList<>();
    private CompanyDao companyDao;
    private ProductDao productDao;
    private CustomerDao customerDao;

    public DefaultModelCreator(CompanyDao companyDao,ProductDao productDao,CustomerDao customerDao) {
        this.companyDao = companyDao;
        this.productDao = productDao;
        this.customerDao = customerDao;
        createCompanyInstances();
        createProductInstances();
        createCustomerInstances();

    }

    public void createCompanyInstances(){
        Company company1 = new Company("0", LocalDateTime.now(),"Company A", "Automotive");
        Company company2 = new Company("1", LocalDateTime.now(),"Company B","Electronic");
        Company company3 = new Company("2", LocalDateTime.now(),"Company C","Food");
        companyInstances.add(company1);
        companyInstances.add(company2);
        companyInstances.add(company3);

        companyDao.add(company1);
        companyDao.add(company2);
        companyDao.add(company3);



    }

    public void createProductInstances(){
        Product product1 = new Product("0",LocalDateTime.now(),"Product 1",500,15);
        product1.setCompany(companyInstances.get(0));
        Product product2 = new Product("1",LocalDateTime.now(),"Product 2",1600,150);
        product2.setCompany(companyInstances.get(2));
        Product product3 = new Product("2",LocalDateTime.now(),"Product 3",2000,17);
        product3.setCompany(companyInstances.get(1));
        Product product4 = new Product("3",LocalDateTime.now(),"Product 4",400,18);
        product4.setCompany(companyInstances.get(0));
        Product product5 = new Product("4",LocalDateTime.now(),"Product 5",160,75);
        product5.setCompany(companyInstances.get(2));
        Product product6 = new Product("5",LocalDateTime.now(),"Product 6",990,600);
        product6.setCompany(companyInstances.get(2));
        Product product7 = new Product("6",LocalDateTime.now(),"Product 7",1550,120);
        product7.setCompany(companyInstances.get(1));
        Product product8 = new Product("7",LocalDateTime.now(),"Product 8",160,10);
        product8.setCompany(companyInstances.get(1));
        Product product9 = new Product("8",LocalDateTime.now(),"Product 9",1750,37);
        product9.setCompany(companyInstances.get(0));
        Product product10 = new Product("9",LocalDateTime.now(),"Product 10",400,48);
        product10.setCompany(companyInstances.get(1));

        productInstances.add(product1);
        productInstances.add(product2);
        productInstances.add(product3);
        productInstances.add(product4);
        productInstances.add(product5);
        productInstances.add(product6);
        productInstances.add(product7);
        productInstances.add(product8);
        productInstances.add(product9);
        productInstances.add(product10);

        productDao.add(product1);
        productDao.add(product2);
        productDao.add(product3);
        productDao.add(product4);
        productDao.add(product5);
        productDao.add(product6);
        productDao.add(product7);
        productDao.add(product8);
        productDao.add(product9);
        productDao.add(product10);

    }

    public void createCustomerInstances(){
        Customer customer1 = new Customer("0",CustomDateFormatter.formatDate("02/06/2022"),"Muhammet","ÇAKIR","address");
        Customer customer2 = new Customer("1",CustomDateFormatter.formatDate("02/06/2022"),"Ali","Yılmaz","address");
        Customer customer3 = new Customer("2",CustomDateFormatter.formatDate("02/06/2022"),"Patika","Dev","address");
        Customer customer4 = new Customer("3",CustomDateFormatter.formatDate("02/08/2022"),"Mehmet","Cennet","address");
        Customer customer5 = new Customer("4",CustomDateFormatter.formatDate("02/09/2022"),"Cihan","Poyraz","address");

        customerInstances.add(customer1);
        customerInstances.add(customer2);
        customerInstances.add(customer3);
        customerInstances.add(customer4);
        customerInstances.add(customer5);

        customerDao.add(customer1);
        customerDao.add(customer2);
        customerDao.add(customer3);
        customerDao.add(customer4);
        customerDao.add(customer5);


    }

}
