package pl.akazoo.BikeUp.domain.model.converter;

import org.springframework.stereotype.Component;
import pl.akazoo.BikeUp.domain.dto.UserRegistry;
import pl.akazoo.BikeUp.domain.model.user.User;
import pl.akazoo.BikeUp.service.impl.ProvinceService;

@Component
public class Converter {

    private final ProvinceService provinceService;

    public Converter(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    public User userRegistryToUser(UserRegistry userRegistry){
        User user = new User();
        user.setLogin(userRegistry.getLogin());
        user.setPassword(userRegistry.getPassword());
        user.setProvince(provinceService.findById(userRegistry.getProvince()));
        return user;
    }
}
