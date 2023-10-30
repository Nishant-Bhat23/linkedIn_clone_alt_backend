package Linkedin_clone_alt.demo.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Entity
@Table(name = "EDUCATION")
public class Education {

    @Id
    @GeneratedValue
    private int education_id;
    private int userId;
    private String tenth_schoolname;
    private String tenth_school_city;
    private int tenth_pass_year;
    private String college_name;
    private String college_city;
    private int twelth_pass_year;
    private String degree;
    private String degree_collegename;
    private String degree_collegeplace;
    private String university_name;
    private String branch;
    private int current_year;
    private double cgpa;
    private int graduation_year;


}
