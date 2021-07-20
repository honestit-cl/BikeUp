package pl.akazoo.BikeUp.structure;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationData {

    public List<String> getHours(){
        return List.of(
                "30min",
                "1h",
                "1:30h",
                "2h",
                "2:30h",
                "3h",
                "3:30h",
                "4h",
                "4:30h",
                "5h",
                "5:30h",
                "6h",
                "6:30h",
                "7h",
                "7:30h",
                "8h",
                "8:30h",
                "9h",
                "9:30h",
                "10h",
                "10:30h",
                "11h",
                "11:30h",
                "12h"
        );
    }

    public List<String> getAnecdotes(){
        return List.of(
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
}
