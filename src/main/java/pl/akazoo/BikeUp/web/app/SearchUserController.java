package pl.akazoo.BikeUp.web.app;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.akazoo.BikeUp.domain.model.user.User;
import pl.akazoo.BikeUp.service.impl.UserService;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/app/searchUser")
public class SearchUserController {

    private final UserService userService;

    @GetMapping
    public String searching() {
        return "/app/userSearching/userSearching";
    }

    @GetMapping("/data")
    @ResponseBody
    public List<User> data() {
        return userService.findAll();
    }

    @GetMapping("/profile/{id:\\d+}")
    public String profile(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "/app/userSearching/profile";
    }
}
