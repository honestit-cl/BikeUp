package pl.akazoo.BikeUp.domain.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class TourEdit {

    @NotNull(message = "To pole nie może być puste.")
    @Range(min = 5, max = 120, message = "Przedział od 5 do 120km.")
    private Long distance;
    @NotBlank(message = "To pole nie może być puste.")
    private String hours;
    @NotBlank(message = "To pole nie może być puste.")
    @Size(max = 1000,message = "Opis jest za długi. Dozwolona liczba znaków to 1000.")
    private String description;
    @URL(message = "Podaj poprawny link.")
    private String link;
    @Size(max = 100, message = " Nazwa miejsca zbiórki nie może być dłuższa niż 100 liter.")
    private String gatheringPlace;
    @NotBlank(message = "Proszę zaznaczyć jedną z opcji.")
    private String returning;
    private Long tourId;
}