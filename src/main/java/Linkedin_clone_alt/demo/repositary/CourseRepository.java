package Linkedin_clone_alt.demo.repositary;

import Linkedin_clone_alt.demo.Entity.Course;
import Linkedin_clone_alt.demo.Entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findByCourseName(String name);
    Course existsByCourseName(String name);

    List<Course> findAllByUsers(UserProfile user);
}
