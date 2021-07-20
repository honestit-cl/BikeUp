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
public class PointsService implements pl.akazoo.BikeUp.service.Service<Point> {

    private final PointRepository pointRepository;
    private final UserService userService;

    public List<Point> findAllByUserLogged() {
        return pointRepository.findAllByOwner_id(userService.getLoggedUser().getId());
    }

    @Override
    public void save(Point point) {
        log.debug("Zapisywany obiekt: " + point);
        pointRepository.save(point);
        log.debug("Zapisano: " + point);
    }

    @Override
    public void delete(Long id) {
        Optional<Point> point = pointRepository.findById(id);
        log.debug("Usuwany obiekt: " + point);
        point.ifPresent(pointRepository::delete);
        log.debug("Usunięto: " + point);
    }

    @Override
    public Point findById(Long id) {
        return pointRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Point with id=" + id + " not exits."));
    }

    //TODO Metody w serwisie powinny spełniać konwencje Javy (camelCase), a nie taki zapis. Metody w repozytoriach
    //     mogą stosować pod tym względem wyjątki.
    //TODO Wprowadzić dodatkową klasę, która będzie grupowała te idiki
    public Optional<Point> findByGiver_IdAndOwner_IdAndTour_Id(Long giver, Long owner, Long tour) {
        return pointRepository.findByGiver_IdAndOwner_IdAndTour_Id(giver, owner, tour);
    }
}