package tien.baseproject.userservice.dto;


import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class RegisterRequest {

    @Email(message = "email is invalid")
    @Size(min = 6, max = 255, message = "email must be between {min} and {max} characters long")
    private String email;

    @Size(min = 8, max = 255, message = "password must be between {min} and {max} characters long")
    @NotBlank(message = "password is not empty")
    private String password;

}
