package Linkedin_clone_alt.demo.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Entity
public class Experience {
    @Id
    @GeneratedValue
    private int experience_id;
    private String company_name;
    private String position;
    private String start_date;
    private String end_date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserProfile userProfile;

}