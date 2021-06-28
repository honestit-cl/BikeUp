package pl.akazoo.BikeUp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.BikeUp.domain.model.user.Point;
import pl.akazoo.BikeUp.domain.repository.PointRepository;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PointsService {

    private final PointRepository pointRepository;
    private final UserService userService;

    public PointsService(PointRepository pointRepository, UserService userService) {
        this.pointRepository = pointRepository;
        this.userService = userService;
    }

    public List<Point> findAllByUserLogged(){
        return pointRepository.findAllByOwner_id(userService.findUserByLoggedUsername().getId());
    }

    public void save(Point point){
        pointRepository.save(point);
    }

    public Optional<Point> findByGiver_IdAndOwner_IdAndTour_Id(Long giver, Long owner, Long tour){
        return pointRepository.findByGiver_IdAndOwner_IdAndTour_Id(giver, owner, tour);
    }
}