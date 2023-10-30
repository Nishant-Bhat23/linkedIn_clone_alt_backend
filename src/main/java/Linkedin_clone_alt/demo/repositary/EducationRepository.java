package Linkedin_clone_alt.demo.repositary;

import Linkedin_clone_alt.demo.Entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education,Integer> {
    public Education findByUserId(int userId);
}