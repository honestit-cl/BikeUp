package pl.akazoo.BikeUp.web.app;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akazoo.BikeUp.domain.dto.UserEdit;
import pl.akazoo.BikeUp.domain.model.converter.Converter;
import pl.akazoo.BikeUp.domain.model.user.User;
import pl.akazoo.BikeUp.service.impl.UserService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/app/profile")
public class ProfileController {

    private final UserService userService;
    private final Converter converter;

    @GetMapping
    public String profile(Model model) {
        model.addAttribute("user", userService.loggedUser());
        return "/app/profile/profile";
    }

    @GetMapping("/edit")
    public String edit(Model model) {
        model.addAttribute("userEdit", converter.userToUserEdit(userService.loggedUser()));
        return "/app/profile/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid UserEdit userEdit, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/app/profile/edit";
        }
        User user = converter.userEditToUser(userEdit);
        userService.save(user);
        return "redirect:/app/profile";
    }
}