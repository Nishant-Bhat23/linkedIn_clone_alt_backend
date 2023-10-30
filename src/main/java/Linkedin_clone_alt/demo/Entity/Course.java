package Linkedin_clone_alt.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue
    private int course_id;
    private String courseName;
    private int no_of_semesters;

    @ManyToMany(mappedBy = "courses")
    private Set<UserProfile> users = new HashSet<>();

    @OneToMany(mappedBy = "course")
    private Set<Semester> semesters = new HashSet<>();

    @OneToMany(mappedBy = "course")
    private Set<Marks> marks = new HashSet<>();

}
