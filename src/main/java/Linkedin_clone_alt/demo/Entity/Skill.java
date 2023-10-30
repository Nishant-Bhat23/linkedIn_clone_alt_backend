package Linkedin_clone_alt.demo.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Entity
public class Skill {

    @Id
    @GeneratedValue
    private int skill_id;
    private String skillType;
    private String skillName;
    private String Proficiency;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserProfile userProfile;

}
