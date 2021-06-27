package pl.akazoo.BikeUp.domain.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PointAdd {
    @NotNull(message = "To pole nie może być puste.")
    @Range(min=1,max = 20, message = "Ilość punktów musi być w przedziale od 1 do 20.")
    private Long amount;
    @NotBlank(message = "To pole nie może być puste.")
    private String description;
    private Long TourId;
    private Long userIdToAdd;
}
