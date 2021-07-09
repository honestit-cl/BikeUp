package pl.akazoo.BikeUp.service;

public interface Service <T>{

    void save(T toAdd);

    void delete(Long id);

    T findById(Long id);

}