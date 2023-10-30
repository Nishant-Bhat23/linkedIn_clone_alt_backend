package Linkedin_clone_alt.demo.dto;




import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class SkillRequest {
    @Id
    @GeneratedValue
    @NotNull
    private int skill_id;
    private String skillType;
    private String skillName;
    private String proficiency;

}