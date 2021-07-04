package pl.akazoo.BikeUp.domain.model.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
@RequiredArgsConstructor
public class ExtraClass {

    public Map<Integer, Map<String, String>> levels = new HashMap<>(Map.of(
            0, Map.of("Początek", "Przygodę czas zacząć"),
            1, Map.of("1", "Pierwsze kroki poczynione."),
            2, Map.of("2", "Widzę że dopieo się rozkrecasz :)"),
            3, Map.of("3", "Stajesz się rozpoznawalny/a !"),
            4, Map.of("4", "Na niejednej szosie opony starłeś/aś !"),
            5, Map.of("5", "Liga światowa.Chapeau bas !"),
            6, Map.of("MAX", "Korona króla kolarzy jest Twoja !")
    ));
    List<Integer> pointsList = List.of(
            0, 50, 500, 2000, 6000, 9000, 12000
    );

    public Map<String, String> countLevel(Long userPoints) {

        Map<String, String> level = new HashMap<>();

        if (userPoints == null || userPoints == 0) {
            level = levels.get(0);

        } else {
            for (int i = 0; i < pointsList.size(); i++) {
                if (userPoints < pointsList.get(i)){
                    level = levels.get(i-1);
                    break;
                }
            }
            if(userPoints>12000){
                level= levels.get(6);
            }
        }
        return level;
    }
}