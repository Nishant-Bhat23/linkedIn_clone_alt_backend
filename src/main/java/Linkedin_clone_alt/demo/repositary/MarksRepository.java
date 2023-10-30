package Linkedin_clone_alt.demo.repositary;

import Linkedin_clone_alt.demo.Entity.Marks;
import Linkedin_clone_alt.demo.Entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarksRepository extends JpaRepository<Marks, Integer>{
    public List<Marks> findByUser(UserProfile user);
}
