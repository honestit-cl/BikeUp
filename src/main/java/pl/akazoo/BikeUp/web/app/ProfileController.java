package pl.akazoo.BikeUp.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akazoo.BikeUp.domain.dto.UserEdit;
import pl.akazoo.BikeUp.domain.model.converter.Converter;
import pl.akazoo.BikeUp.domain.model.province.Province;
import pl.akazoo.BikeUp.domain.model.user.User;
import pl.akazoo.BikeUp.service.impl.ProvinceService;
import pl.akazoo.BikeUp.service.impl.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/app/profile")
public class ProfileController {

    private final UserService userService;
    private final Converter converter;
    private final ProvinceService provinceService;

    public ProfileController(UserService userService, Converter converter, ProvinceService provinceService) {
        this.userService = userService;
        this.converter = converter;
        this.provinceService = provinceService;
    }

    @GetMapping
    public String profile(Model model){
        model.addAttribute("user", userService.findUserByLoggedUsername());
        return "/app/Profile/profile";
    }

    @GetMapping("/edit")
    public String edit(Model model){
        model.addAttribute("userEdit", new UserEdit());
        return "/app/Profile/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid UserEdit userEdit, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/app/Profile/edit";
        }
        User user = converter.userEditToUser(userEdit);
        userService.save(user);
        return "redirect:/app/profile";
    }

    @ModelAttribute("allProvinces")
    public List<Province> provinces() {
        return provinceService.findAll();
    }
}