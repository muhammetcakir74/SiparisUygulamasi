package org.muhammetcakir.service.impl.product;

import org.muhammetcakir.data.customer.ProductDao;
import org.muhammetcakir.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService implements IProductService<Product> {

    private ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product add(Product item) {
        productDao.add(item);
        return item;
    }

    @Override
    public Product delete(Product item) {
        return null;
    }

    @Override
    public Product update(Product item) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public Product findById(String id) {
        for (Product product:productDao.getAll()){
            if(product.getId().equals(id)){
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> filterProductAccordingToCompany(String id){
        List<Product> filteredProductList = productDao.getAll();
        return filteredProductList.stream().filter(p -> p.getCompany().getId().equals(id)).collect(Collectors.toList());
    }
}
