package pl.akazoo.BikeUp.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.BikeUp.domain.model.user.Point;
import pl.akazoo.BikeUp.domain.repository.PointRepository;
import pl.akazoo.BikeUp.exceptions.ResourceNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PointsService {

    private final PointRepository pointRepository;
    private final UserService userService;

    public List<Point> getAllByLogged() {
        return pointRepository.findAllByOwner_id(userService.logged().getId());
    }

    public void save(Point point) {
        log.debug("Zapisywany obiekt: " + point);
        pointRepository.save(point);
        log.debug("Zapisano: " + point);
    }

    public void delete(Long id) {
        Optional<Point> point = pointRepository.findById(id);
        log.debug("Usuwany obiekt: " + point);
        point.ifPresent(pointRepository::delete);
        log.debug("Usunięto: " + point);
    }

    public Point getById(Long id) {
        return pointRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Point with id=" + id + " not exits."));
    }

    public Optional<Point> getAllByGiverIdAndOwnerIdAndTourId(Long giver, Long owner, Long tour) {
        return pointRepository.findByGiver_IdAndOwner_IdAndTour_Id(giver, owner, tour);
    }
}