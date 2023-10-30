package Linkedin_clone_alt.demo.repositary;


import Linkedin_clone_alt.demo.Entity.Skill;
import Linkedin_clone_alt.demo.Entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
    public List<Skill> findAllByUserProfile(UserProfile user);
}
