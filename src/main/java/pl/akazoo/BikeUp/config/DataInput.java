package pl.akazoo.BikeUp.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.BikeUp.domain.model.user.Point;
import pl.akazoo.BikeUp.domain.model.user.User;
import pl.akazoo.BikeUp.service.impl.*;

import java.util.concurrent.atomic.AtomicBoolean;

@Component
@Slf4j
@RequiredArgsConstructor
public class DataInput {

    private AtomicBoolean alreadyRun = new AtomicBoolean(false);

    private final UserService userService;
    private final PointsService pointsService;

    @EventListener
    @Transactional
    public void testData(ContextRefreshedEvent event) {
        if (!alreadyRun.getAndSet(true)) {

            //
            User user = new User();
            user.setUsername("aa");
            user.setPassword("aa");
            user.setRole("ROLE_USER");
            user.setVisibility("hidden");
            userService.save(user);
            //
            Point point = new Point();
            point.setAmount(12005L);
            point.setOwner(user);
            pointsService.save(point);
        }
    }
}