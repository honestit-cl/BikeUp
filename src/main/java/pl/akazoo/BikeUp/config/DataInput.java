package pl.akazoo.BikeUp.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;


@Component
@Slf4j
public class DataInput {

    private AtomicBoolean alreadyRun = new AtomicBoolean(false);


//    public DataSetup() {
//    }

    @EventListener
    public void testData(ContextRefreshedEvent event) {
        if (!alreadyRun.getAndSet(true)) {
        }
    }
}