package Linkedin_clone_alt.demo.repositary;

import Linkedin_clone_alt.demo.Entity.Experience;
import Linkedin_clone_alt.demo.Entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience,Integer> {
    List<Experience> findAllByUserProfile(UserProfile user);
}