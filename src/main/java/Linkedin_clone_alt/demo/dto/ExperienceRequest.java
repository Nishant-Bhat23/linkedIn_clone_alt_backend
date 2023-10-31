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
public class ExperienceRequest {
    @Id
    @GeneratedValue
    @NotNull
    private int experience_id;
    private String company_name;
    private String position;
    private String start_date;
    private String end_date;

}