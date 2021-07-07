package pl.akazoo.BikeUp.web.start;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akazoo.BikeUp.domain.dto.UserRegistry;
import pl.akazoo.BikeUp.domain.model.converter.Converter;
import pl.akazoo.BikeUp.service.impl.UserService;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegisterController {

    private final Converter converter;
    private final UserService userService;

    @GetMapping
    public String register(Model model) {
        model.addAttribute("userRegistry", new UserRegistry());
        return "start/register";
    }

    @PostMapping
    public String registerConfirm(@Valid UserRegistry userRegistry, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "start/register";
        }
        if (userService.existsByUsername(userRegistry.getLogin())) {
            bindingResult.rejectValue("login", null,"Podany login jest już zajęty.");
            return "start/register";
        }
        if (!userRegistry.getPassword().equals(userRegistry.getPassword2())) {
            bindingResult.rejectValue("password", null,"Hasła nie są takie same.");
            return "start/register";
        }

        userService.save(converter.userRegistryToUser(userRegistry));
        return "start/registerDone";
    }
}