package pl.akazoo.BikeUp.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.BikeUp.domain.model.province.City;
import pl.akazoo.BikeUp.domain.model.province.Province;
import pl.akazoo.BikeUp.domain.model.user.User;
import pl.akazoo.BikeUp.domain.repository.CityRepository;
import pl.akazoo.BikeUp.service.impl.ProvinceService;
import pl.akazoo.BikeUp.service.impl.TourService;
import pl.akazoo.BikeUp.service.impl.UserService;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;


@Component
@Slf4j
@RequiredArgsConstructor
public class DataInput {
    private static final Logger logger = LoggerFactory.getLogger(DataInput.class);

    private AtomicBoolean alreadyRun = new AtomicBoolean(false);

    private final TourService tourService;
    private final UserService userService;
    private final CityRepository cityRepository;
    private final ProvinceService provinceService;


    @EventListener
    @Transactional
    public void testData(ContextRefreshedEvent event) {
        if (!alreadyRun.getAndSet(true)) {
            Province provincee = new Province(null,"Ślaskie",new ArrayList<>());
            City city = new City(null,"Katowice",provincee);
            provinceService.save(provincee);
            cityRepository.save(city);
            //
            Province provincee2 = new Province(null,"Dolnoślaskie",new ArrayList<>());
            City city2 = new City(null,"Wrocław",provincee2);
            provinceService.save(provincee2);
            cityRepository.save(city2);
            //
            Province provincee3 = new Province(null,"Kujawsko-Pomorskie",new ArrayList<>());
            City city3 = new City(null,"Bydgoszcz",provincee3);
            provinceService.save(provincee3);
            cityRepository.save(city3);
            //
            Province provincee4 = new Province(null,"Lubelskie",new ArrayList<>());
            City city4 = new City(null,"Lublin",provincee4);
            provinceService.save(provincee4);
            cityRepository.save(city4);
            //
            Province provincee5 = new Province(null,"Lubuskie",new ArrayList<>());
            City city5 = new City(null,"Gorzów Wielkopolski",provincee5);
            provinceService.save(provincee5);
            cityRepository.save(city5);
            //
            Province provincee6 = new Province(null,"Łódzkie",new ArrayList<>());
            City city6 = new City(null,"Łódź",provincee6);
            provinceService.save(provincee6);
            cityRepository.save(city6);
            //
            Province provincee7 = new Province(null,"Małopolskie",new ArrayList<>());
            City city7 = new City(null,"Kraków",provincee7);
            provinceService.save(provincee7);
            cityRepository.save(city7);
            //
            Province provincee8 = new Province(null,"Mazowieckie",new ArrayList<>());
            City city8 = new City(null,"Warszawa",provincee8);
            provinceService.save(provincee8);
            cityRepository.save(city8);
            //
            Province provincee9 = new Province(null,"Opolskie",new ArrayList<>());
            City city9 = new City(null,"Opole",provincee9);
            provinceService.save(provincee9);
            cityRepository.save(city9);
            //
            Province provincee10 = new Province(null,"Podkarpackie",new ArrayList<>());
            City city10 = new City(null,"Rzeszów",provincee10);
            provinceService.save(provincee10);
            cityRepository.save(city10);
            //
            Province provincee11 = new Province(null,"Podlaskie",new ArrayList<>());
            City city11 = new City(null,"Białystok",provincee11);
            provinceService.save(provincee11);
            cityRepository.save(city11);
            //
            Province provincee12 = new Province(null,"Pomorskie",new ArrayList<>());
            City city12 = new City(null,"Gdańsk",provincee12);
            provinceService.save(provincee12);
            cityRepository.save(city12);
            //
            Province provincee13 = new Province(null,"Świętokrzyskie",new ArrayList<>());
            City city13 = new City(null,"Kielce",provincee13);
            provinceService.save(provincee13);
            cityRepository.save(city13);
            //
            Province provincee14 = new Province(null,"Warmińsko-Mazurskie",new ArrayList<>());
            City city14 = new City(null,"Olsztyn",provincee14);
            provinceService.save(provincee14);
            cityRepository.save(city14);
            //
            Province provincee15 = new Province(null,"Wielkopolskie",new ArrayList<>());
            City city15 = new City(null,"Poznań",provincee15);
            provinceService.save(provincee15);
            cityRepository.save(city15);
            //
            Province provincee16 = new Province(null,"Zachodniopomorskie",new ArrayList<>());
            City city16 = new City(null,"Szczecin",provincee16);
            provinceService.save(provincee16);
            cityRepository.save(city16);
            //
            User user = new User();
            user.setUsername("aa");
            user.setPassword("aa");
            user.setProvince(provincee);
            user.setRole("ROLE_USER");
            userService.save(user);

            logger.debug("~-~".repeat(20));
            logger.debug(provinceService.findAll().toString());
            logger.debug("~-~".repeat(20));
            logger.debug(provinceService.findById(1L).toString());
            logger.debug("~-~".repeat(20));
            logger.debug(userService.findAll().toString());
        }
    }
}