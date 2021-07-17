package pl.akazoo.BikeUp.domain.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class UserEdit {

    private String lastName;
    private String firstName;
    @NotBlank(message = "To pole nie może być puste.")
    private String personalDataVisibility;
}