package pl.akazoo.BikeUp.service;

//TODO Dość niefortunna nazwa tego interfejsu
//TODO Drugie pytanie - po co on jest?
public interface Service <T>{

    void save(T toAdd);

    void delete(Long id);

    T findById(Long id);

}