package Linkedin_clone_alt.demo.repositary;

import Linkedin_clone_alt.demo.Entity.Semester;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SemesterRepository extends JpaRepository<Semester, Integer> {
    Semester findBySem(int sem);
}
