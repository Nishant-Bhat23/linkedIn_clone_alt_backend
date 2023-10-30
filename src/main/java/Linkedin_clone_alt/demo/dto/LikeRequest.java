package Linkedin_clone_alt.demo.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class LikeRequest {
    private int post_id;
    private int user_id;
}