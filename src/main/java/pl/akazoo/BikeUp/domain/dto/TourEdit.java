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
    @Range(min = 5, max = 150, message = "Przedział od 5 do 150km.")
    private Long distance; // in km
    @NotBlank(message = "To pole nie może być puste.")
    private String hours; //duration
    @NotBlank(message = "To pole nie może być puste.")
    private String date; // event time
    @NotBlank(message = "To pole nie może być puste.")
    private String start; // place, road,
    @NotBlank(message = "To pole nie może być puste.")
    @Size(max = 1000,message = "Opis jest za długi. Dozwolona liczba znaków to 1000.")
    private String description; // extra description
    @NotBlank(message = "Wybierz jedną z opcji.")
    private String howFar; // from selected city
    @URL(message = "Podaj poprawny link.")
    private String link;
    private Long tourId;
}