package pl.akazoo.BikeUp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.BikeUp.domain.model.tour.Tour;
import pl.akazoo.BikeUp.domain.model.user.User;
import pl.akazoo.BikeUp.domain.repository.TourRepository;
import pl.akazoo.BikeUp.exceptions.ResourceNotFoundException;
import java.util.List;

@Service
@Transactional
public class TourService {

    private final TourRepository tourRepository;
    private final UserService userService;

    public TourService(TourRepository tourRepository, UserService userService) {
        this.tourRepository = tourRepository;
        this.userService = userService;
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

    public Tour findById(Long id){
        return tourRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Tour with id="+id+"not exits."));
    }
    public void delete(Long id){
        Tour tour = findById(id);
        tourRepository.delete(tour);
    }

    public List<Tour> findAllToursWithoutUser() {
        User user= userService.getLoggedUser();
        return tourRepository.findAllByUser_IdNotLike(user.getId());
    }
}