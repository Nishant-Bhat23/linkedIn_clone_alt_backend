package Linkedin_clone_alt.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class MarksRequest {
    private int userId;
    private String subjectName;
    private int semesterId;
    private int courseId;
    private int marks;
}
