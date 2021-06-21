package pl.akazoo.BikeUp.domain.dto;

import lombok.Data;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserRegistry {

    @NotBlank
    private String login;
    @NotBlank
    private String password;
    @NotNull
    private Long province;
    @AssertTrue
    private boolean loyalty;
}