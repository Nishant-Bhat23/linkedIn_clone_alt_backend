package Linkedin_clone_alt.demo.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class pendingRequestDto {
    private int userId;
    private int requestedUser_id;

}

