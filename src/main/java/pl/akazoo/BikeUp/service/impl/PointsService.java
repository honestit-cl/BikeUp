package pl.akazoo.BikeUp.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.BikeUp.domain.model.user.Point;
import pl.akazoo.BikeUp.domain.repository.PointRepository;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PointsService {

    private final PointRepository pointRepository;
    private final UserService userService;

    public List<Point> findAllByUserLogged(){
        return pointRepository.findAllByOwner_id(userService.getLoggedUser().getId());
    }

    public void save(Point point){
        log.debug("Zapisywany obiekt: " + point);
        pointRepository.save(point);
        log.debug("Zapisano: " + point);
    }

    public Optional<Point> findByGiver_IdAndOwner_IdAndTour_Id(Long giver, Long owner, Long tour){
        return pointRepository.findByGiver_IdAndOwner_IdAndTour_Id(giver, owner, tour);
    }
}