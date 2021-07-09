package pl.akazoo.BikeUp.domain.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class TourAdd {

    @NotNull(message = "To pole nie może być puste.")
    @Range(min = 1, max = 10, message = "Ilość uczestników musi być w przedziale od 1 do 10.")
    private int participants;
    @NotNull(message = "To pole nie może być puste.")
    @Range(min = 5, max = 120, message = "Przedział od 5 do 120km.")
    private Long distance;
    @NotBlank(message = "To pole nie może być puste.")
    private String hours;
    private @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date;
    @NotBlank(message = "To pole nie może być puste.")
    @Size(max = 1000, message = "Opis jest za długi. Dozwolona liczba znaków to 1000.")
    private String description;
    @URL(message = "Podaj poprawny link.")
    private String link;
    @NotBlank(message = "To pole nie może być puste.")
    private String startPlace;
    @NotBlank(message = "To pole nie może być puste.")
    @Pattern(regexp = "[0-9]{2}-[0-9]{3}", message = "Poprawny format kodu to xx-xxx")
    private String startPost;
    @NotBlank(message = "To pole nie może być puste.")
    private String endPlace;
    @NotBlank(message = "To pole nie może być puste.")
    @Pattern(regexp = "[0-9]{2}-[0-9]{3}", message = "Poprawny format kodu to xx-xxx")
    private String endPost;
    @NotBlank(message = "To pole nie może być puste.")
    @Size(max = 100, message = " Nazwa miejsca zbiórki nie może być dłuższa niż 100 liter.")
    private String gatheringPlace;
    @NotBlank(message = "Proszę zaznaczyć jedną z opcji.")
    private String returning;
}