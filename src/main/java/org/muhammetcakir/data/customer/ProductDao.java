package org.muhammetcakir.data.customer;

import org.muhammetcakir.model.Customer;
import org.muhammetcakir.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    private List<Product> products = new ArrayList<>();

    public Product add(Product product){
        products.add(product);
        return product;
    }

    public List<Product> getAll(){
        return products;
    }

    public int numberOfProducts(){
        return products.size();
    }

}
