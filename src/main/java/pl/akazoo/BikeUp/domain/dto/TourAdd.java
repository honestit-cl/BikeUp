package pl.akazoo.BikeUp.domain.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class TourAdd {

    @Range(min=1,max = 10, message = "Ilość uczestników musi być w przedziale od 1 do 10")
    private int participants; // participants amount
    @NotNull
    @Range(min = 5, max = 150)
    private Long distance; // in km
    @NotBlank
    private String hours; //duration
    @NotBlank
    private String date; // event time
    @NotBlank
    private String start; // place, road,
    @NotBlank
    @Size(max = 1000)
    private String description; // extra description
    @NotBlank
    private String howFar; // from selected city
    @Range(min = 1)
    private Long cityId;
    @URL
    private String link;
}