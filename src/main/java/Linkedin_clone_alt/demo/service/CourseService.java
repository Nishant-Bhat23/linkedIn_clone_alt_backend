package Linkedin_clone_alt.demo.service;

import Linkedin_clone_alt.demo.dto.CourseRequest;
import Linkedin_clone_alt.demo.Entity.Course;
import Linkedin_clone_alt.demo.Entity.UserProfile;
import Linkedin_clone_alt.demo.repositary.CourseRepository;
import Linkedin_clone_alt.demo.repositary.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private UserRepository userProfileRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Course addCourse(int user_id, CourseRequest courseRequest) {
        // Check if the course with the specified name exists
        Course course = courseRepository.findByCourseName(courseRequest.getCourseName());

        if (course == null) {
            course = Course.build(0, courseRequest.getCourseName(), courseRequest.getNo_of_semesters(), null, null,null);
            return courseRepository.save(course);
        }
        UserProfile user = userProfileRepository.findById(user_id).orElse(null);
        // Add the user to the course by updating the mapping table
        user.getCourses().add(course);
        userProfileRepository.save(user);
        return course;
    }

    public Course getCourseById(int courseId) {
        return courseRepository.findById(courseId).orElse(null);
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public List<Course> getCourseByUserId(int user_id){
        UserProfile user = userProfileRepository.findById(user_id).orElse(null);
        return courseRepository.findAllByUsers(user);
    }

    public Course updateCourse(int courseId, CourseRequest updatedCourse) {
        // Check if the course with the given courseId exists
        Course existingCourse = courseRepository.findById(courseId).orElse(null);
        if (existingCourse !=null) {

            // Update the course properties with the new values
            existingCourse.setCourseName(updatedCourse.getCourseName());
            existingCourse.setNo_of_semesters(updatedCourse.getNo_of_semesters());

            // Save the updated course to the database
            return courseRepository.save(existingCourse);
        } else {
            // If the course with the given courseId does not exist
            throw new RuntimeException("Course not found with ID: " + courseId);
        }
    }

    public void deleteCourse(int courseId) {
        // Check if the course with the given courseId exists
        boolean course = courseRepository.existsById(courseId);
        if (course) {
            // If the course exists, delete it from the database
            courseRepository.deleteById(courseId);
        } else {
            // If the course with the given courseId does not exist
            throw new RuntimeException("Course not found with ID: " + courseId);
        }
    }
}
