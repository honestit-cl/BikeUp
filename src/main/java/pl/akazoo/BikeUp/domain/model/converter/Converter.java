package pl.akazoo.BikeUp.domain.model.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.akazoo.BikeUp.domain.dto.UserRegistry;
import pl.akazoo.BikeUp.domain.model.user.User;
import pl.akazoo.BikeUp.service.impl.ProvinceService;

@Component
@RequiredArgsConstructor
public class Converter {

    private final ProvinceService provinceService;


    public User userRegistryToUser(UserRegistry userRegistry){
        User user = new User();
        user.setUsername(userRegistry.getLogin());
        user.setPassword(userRegistry.getPassword());
        user.setProvince(provinceService.findById(userRegistry.getProvince()));
        return user;
    }
}