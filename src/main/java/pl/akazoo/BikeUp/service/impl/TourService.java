package pl.akazoo.BikeUp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.BikeUp.domain.model.tour.Tour;
import pl.akazoo.BikeUp.domain.model.user.User;
import pl.akazoo.BikeUp.domain.repository.TourRepository;

import java.util.List;


@Service
@Transactional
public class TourService {

    private final TourRepository tourRepository;

    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public long allToursCount(){
        return tourRepository.count();
    }

    public void save(Tour tour){
        tourRepository.save(tour);
    }

    public List<Tour> findToursByUser(User user){
        return tourRepository.findAllTourByUser(user);
    }
}