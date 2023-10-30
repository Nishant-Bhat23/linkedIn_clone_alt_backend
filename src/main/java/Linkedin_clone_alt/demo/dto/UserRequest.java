package Linkedin_clone_alt.demo.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@Data
public class UserRequest {
    @NotNull(message= "Username Should not be Null!!")
    private String username;
    @NotNull(message= "Firstname Should not be Null!!")
    @NotBlank(message="Firstname Should contain some charecters!!")
    @Pattern(regexp = "^[A-Za-z]+$")
    private String firstname;
    @NotBlank(message="Lastname Should contain some charecters!!")
    @NotNull(message= "Lastname Should not be Null!!")
    @Pattern(regexp = "^[A-Za-z]+$")
    private String lastname;
    @Email(message="Invalid Email Address!!")
    private String email;
    //@(message="password should contain combination of special chrecters,digits,alphabets");
    @Pattern(regexp ="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$",message="Weak password,change it ASAP!!")
    private String password;
    private long contact;
    @NotNull
    private String date;
}