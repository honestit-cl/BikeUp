package pl.akazoo.BikeUp.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.akazoo.BikeUp.structure.ApplicationData;
import pl.akazoo.BikeUp.structure.Level;
import pl.akazoo.BikeUp.service.impl.UserService;
import pl.akazoo.BikeUp.web.app.AppHomeController;
import java.util.List;
import java.util.Random;

@ControllerAdvice(basePackageClasses = {AppHomeController.class})
public class GlobalDataController {

    private final UserService userService;
    private final List<String> didUKnow;
    private final Level level;

    public GlobalDataController(UserService userService,Level level, ApplicationData applicationData) {
        this.userService = userService;
        this.level = level;
        didUKnow = applicationData.getAnecdotes();
    }

    @ModelAttribute
    public void globalData(Model model) {
        Long points = userService.loggedUser().getPoints();
        if (points == null) {
            model.addAttribute("userPoints", 0);
            model.addAttribute("level", level.countLevel(0L));
        }else{
            model.addAttribute("userPoints", points);
            model.addAttribute("level", level.countLevel(points));
        }
        Random random = new Random();
        int chosen = random.nextInt(didUKnow.size());
        model.addAttribute("didUKnow", didUKnow.get(chosen));
        model.addAttribute("logged",userService.loggedUser().getUsername());
    }
}