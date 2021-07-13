package pl.akazoo.BikeUp.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.akazoo.BikeUp.domain.model.extraClasses.ExtraClass;
import pl.akazoo.BikeUp.service.impl.UserService;
import pl.akazoo.BikeUp.web.app.AppHomeController;
import java.util.List;
import java.util.Random;

@ControllerAdvice(basePackageClasses = {AppHomeController.class})
public class GlobalDataController {

    private final UserService userService;
    private final List<String> didUKnow;
    private final ExtraClass extraClass;

    public GlobalDataController(UserService userService, ExtraClass extraClass) {
        this.userService = userService;
        this.extraClass = extraClass;
        didUKnow = List.of(
                "Pierwotne nazwy roweru to welocyped i bicykl.",
                "Pierwszy prototyp roweru został zbudowany przez francuskiego hrabiego Mède de Sivrac w 1790 roku. Umożliwiał wyłącznie jazdę w jednym kierunku (nie dało się nim skręcać).",
                "Twórcą współczesnego roweru jest niemiecki wynalazca Karl Drais. Pojazd, który opatentował w 1818 roku, nie posiadał pedałów (jechało się odpychając nogami od ziemi).",
                "Rower górski powstał w latach 70. XX wieku, dzięki współpracy pięciu osób (Joe Breeze, Tom Ritchey, Charles Kelly, John Finnley Scott, Gary Fisher), a do produkcji został wypuszczony w 1978 roku.",
                "Do 1888 roku jeżdżono na pełnych, gumowych oponach. Potem na pneumatycznych oponach rowerowych stanowiących wynalazek szkockiego lekarza John’a Boyd’a Dunlopa.",
                "Skórzane siodełko Brooks B17 jest produkowane w niezmienionej fomie od ponad 120 lat.",
                "Handbike rower dla osób niepełnosprawnych. Jak sama nazwa wskazuje – jest napędzany siłą rąk.",
                "Tandem to dwuosobowa wersja roweru.",
                "Najdłuższym rowerem na świecie (42 m) jechało równocześnie 20 osób. Rekord ustanowiono w 2015 roku w Australii, pokonując dystans 100 metrów.",
                "Najmniejszy rower świata ma koła o średnicy 1,9 cm. W 1988 roku Australijczyk Neville Patten przejechał na nim 4 metry.",
                "Najwyższy dwukołowy rower na świecie liczy 5,5 metra wysokości. Stworzył go Kubańczyk Felix Guirola.",
                "Największy rower na świecie liczy 3,7 m wysokości i 7,8 m długości. Jego twórcą jest Niemiec Didi Senft.",
                "Fairwheel Bikes to firma, która stworzyła najlżejszy rower na świecie. Waży zaledwie 2,7 kg.",
                "Aktualny rekord prędkości w jeździe na rowerze poziomym po płaskiej nawierzchni wynosi 132,5 km/h.",
                "Tymczasem blisko 60% mieszkańców Amsterdamu (1,2 mln) używa roweru jako podstawowego środka lokomocji.",
                "Jedną z najstarszych organizacji sportowych w Polsce jest Warszawskie Towarzystwo Cyklistów. Liczy przeszło 130 lat (zostało założone w 1886 roku).",
                "W latach 1911-1931 trasa Tour de France liczyła nawet 5000 km. Obecnie kolarze pokonują 60-70% tego dystansu.",
                "Energia, którą pochłania produkcja jednego samochodu wystarczy na wyprodukowanie ponad 100 rowerów."
        );
    }

    @ModelAttribute
    public void globalData(Model model) {
        Long points = userService.logged().getPoints();
        if (points == null) {
            model.addAttribute("userPoints", 0);
            model.addAttribute("level", extraClass.countLevel(0L));
        }else{
            model.addAttribute("userPoints", points);
            model.addAttribute("level", extraClass.countLevel(points));
        }
        Random random = new Random();
        int chosen = random.nextInt(didUKnow.size());
        model.addAttribute("didUKnow", didUKnow.get(chosen));
        model.addAttribute("logged",userService.logged().getUsername());
    }
}