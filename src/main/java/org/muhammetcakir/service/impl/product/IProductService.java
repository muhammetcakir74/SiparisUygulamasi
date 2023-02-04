package org.muhammetcakir.service.impl.product;

import org.muhammetcakir.model.Product;
import org.muhammetcakir.service.IBaseService;

import java.util.List;

public interface IProductService<T> extends IBaseService<T> {

    public List<Product> filterProductAccordingToCompany(String id);

}
