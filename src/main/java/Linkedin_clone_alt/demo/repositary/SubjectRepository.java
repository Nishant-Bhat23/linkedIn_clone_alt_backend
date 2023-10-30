package Linkedin_clone_alt.demo.repositary;


import Linkedin_clone_alt.demo.Entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer>{
    Subject findBySubjectName(String name);
}
