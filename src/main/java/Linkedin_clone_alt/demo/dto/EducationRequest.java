package Linkedin_clone_alt.demo.dto;



import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class EducationRequest {
    @NotNull
    private int education_id;;
    @NotNull
    private int userId;

    @NotNull
    private String tenth_schoolname;

    @NotNull
    private String tenth_school_city;

    @NotNull
    private int tenth_pass_year;

    @NotNull
    private String college_name;

    @NotNull
    private String college_city;

    @NotNull
    private int twelth_pass_year;

    @NotNull
    private String degree;

    @NotNull
    private String degree_collegename;

    @NotNull
    private String degree_collegeplace;

    @NotNull
    private String university_name;

    @NotNull
    private String branch;

    @NotNull
    private int current_year;

    @NotNull
    private double cgpa;

    @NotNull
    private int graduation_year;



}