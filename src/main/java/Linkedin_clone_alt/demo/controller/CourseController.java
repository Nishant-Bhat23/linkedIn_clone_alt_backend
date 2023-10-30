package Linkedin_clone_alt.demo.controller;

import Linkedin_clone_alt.demo.dto.CourseRequest;
import Linkedin_clone_alt.demo.Entity.Course;
import Linkedin_clone_alt.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/getAllCourses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{courseId}")
    public Course getCourseById(@PathVariable int courseId) {
        return courseService.getCourseById(courseId);
    }

    @GetMapping("/getCourse/{user_id}")
    public List<Course> getCourseByUserId(@PathVariable int user_id){
        return courseService.getCourseByUserId(user_id);
    }

    @PostMapping("/{user_id}/addCourse")
    public Course addCourse(@PathVariable int user_id,@RequestBody CourseRequest courseRequest) {
        return courseService.addCourse(user_id,courseRequest);
    }

    @PutMapping("/{courseId}")
    public Course updateCourse(@PathVariable int courseId, @RequestBody CourseRequest courseRequest) {
        return courseService.updateCourse(courseId, courseRequest);
    }

    @DeleteMapping("/{courseId}")
    public void deleteCourse(@PathVariable int courseId) {
        courseService.deleteCourse(courseId);
    }
}
