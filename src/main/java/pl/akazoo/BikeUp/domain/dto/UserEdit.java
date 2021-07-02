package pl.akazoo.BikeUp.domain.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

@Data
public class UserEdit {

    @Range(min=1,max = 16,message = "Wybierz swoje województwo.")
    private Long province;
    private String lastName;
    private String firstName;
    @NotBlank(message = "To pole nie może być puste.")
    private String visibility;
}