package Linkedin_clone_alt.demo.service;

import Linkedin_clone_alt.demo.dto.MarksRequest;
import Linkedin_clone_alt.demo.Entity.*;
import Linkedin_clone_alt.demo.repositary.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarksService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private MarksRepository marksRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private SemesterRepository semesterRepository;

    public Marks addMarks(MarksRequest marksRequest) {
        // Fetch user, subject, semester, and course based on the request
        UserProfile user = userRepository.findById(marksRequest.getUserId()).orElse(null);
        Subject subject = subjectRepository.findBySubjectName(marksRequest.getSubjectName());
        Semester semester = semesterRepository.findById(marksRequest.getSemesterId()).orElse(null);
        Course course = courseRepository.findById(marksRequest.getCourseId()).orElse(null);

        // Create a new Marks entity and set its properties
        Marks marks = Marks.build(0, user, subject, semester, course, marksRequest.getMarks());

        // Save the marks entity
        return marksRepository.save(marks);
    }

    public List<Marks> getUserMarks(int userId) {
        // Fetch marks for a specific user based on the user's ID
        UserProfile user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            throw new RuntimeException("User not found with ID: " + userId);
        }

        return marksRepository.findByUser(user);
    }
}
