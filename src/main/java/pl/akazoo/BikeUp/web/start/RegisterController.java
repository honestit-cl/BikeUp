package pl.akazoo.BikeUp.web.start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akazoo.BikeUp.domain.dto.UserRegistry;
import pl.akazoo.BikeUp.domain.model.converter.Converter;
import pl.akazoo.BikeUp.domain.model.province.Province;
import pl.akazoo.BikeUp.service.impl.ProvinceService;
import pl.akazoo.BikeUp.service.impl.UserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private List<String> users;
    private final ProvinceService provinceService;
    private final Converter converter;
    private final UserService userService;

    public RegisterController(ProvinceService provinceService, Converter converter, UserService userService) {
        this.userService = userService;
        this.users = new ArrayList<>();
        this.provinceService = provinceService;
        this.converter = converter;
    }

    @ModelAttribute("allProvinces")
    public List<Province> provinces() {
        return provinceService.findAll();
    }

    @GetMapping
    public String register(Model model) {
        model.addAttribute("userRegistry", new UserRegistry());
        return "start/register";
    }

    @PostMapping
    public String registerConfirm(@Valid UserRegistry userRegistry, BindingResult bindingResult) {
        Optional<String> login = users.stream()
                .filter(x -> x.equals(userRegistry.getLogin()))
                .findAny();

        if (bindingResult.hasErrors() || login.isPresent()) {
            return "start/register";
        }
        userService.save(converter.userRegistryToUser(userRegistry));
        users.add(userRegistry.getLogin());
        return "start/registerDone";
    }
}