package pl.akazoo.BikeUp.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app/rules")
public class RulesController {

    @GetMapping
    public String rulesPage(){
        return "/app/rules";
    }
}