package pl.akazoo.BikeUp.service;

import java.util.List;

public interface Service <T>{

    T getById(Long id);

    T add(T toAdd);

    void update(T toUpdate);

    void delete(Long id);

    List<T> getAll();
}
