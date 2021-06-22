package pl.akazoo.BikeUp.domain.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;

@Data
public class UserRegistry {

    @NotBlank
    private String login;
    @NotBlank
    private String password;
    @Range(min=1,max = 16)
    private Long province;
    @AssertTrue
    private boolean loyalty;
}