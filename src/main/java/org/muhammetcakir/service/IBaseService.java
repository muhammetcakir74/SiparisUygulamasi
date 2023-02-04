package org.muhammetcakir.service;

import java.util.List;

public interface IBaseService<T> {

    public T add(T item);
    public T delete(T item);
    public T update(T item);
    public List<T> getAll();
    public T findById(String id);

}
