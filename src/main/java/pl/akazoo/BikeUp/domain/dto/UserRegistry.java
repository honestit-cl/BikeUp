package pl.akazoo.BikeUp.domain.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;

@Data
public class UserRegistry {

    @NotBlank(message = "To pole nie może być puste.")
    private String login;
    @NotBlank(message = "To pole nie może być puste.")
    private String password;
    @NotBlank(message = "To pole nie może być puste.")
    private String password2;
    @AssertTrue(message = "Potwierdź zapoznanie się z regulaminem.")
    private boolean loyalty;
}