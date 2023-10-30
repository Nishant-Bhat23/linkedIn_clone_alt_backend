package Linkedin_clone_alt.demo.dto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@Data
public class LoginRequest {
    @NotNull(message="Enter valid username")
    private String username;
    @NotNull(message="Enter correct password")
    private String password;
}