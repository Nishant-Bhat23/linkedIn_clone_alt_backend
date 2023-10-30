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
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subjectId;

    private String subjectName; // Example: Operating System, Database Management, etc.

    @ManyToMany(mappedBy = "subjects")
    private Set<Semester> semesters = new HashSet<>();

    @OneToMany(mappedBy = "subject")
    private Set<Marks> marks = new HashSet<>();
}

