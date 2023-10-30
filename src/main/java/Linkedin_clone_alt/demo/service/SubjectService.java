package Linkedin_clone_alt.demo.service;

import Linkedin_clone_alt.demo.dto.SubjectRequest;
import Linkedin_clone_alt.demo.Entity.Semester;
import Linkedin_clone_alt.demo.Entity.Subject;
import Linkedin_clone_alt.demo.repositary.SemesterRepository;
import Linkedin_clone_alt.demo.repositary.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private SemesterRepository semesterRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject getSubjectById(int subjectId) {
        Subject subject = subjectRepository.findById(subjectId).orElse(null);

        if (subject != null) {
            return subjectRepository.findById(subjectId).orElse(null);
        } else {
            throw new RuntimeException("Subject not found with ID: " + subjectId);
        }
    }

    public Subject addSubject(int semester_id, SubjectRequest subjectRequest) {
        Semester semester = semesterRepository.findById(semester_id).orElse(null);
        if (semester == null) {
            throw new RuntimeException("Semester not found with ID: " + semester_id);
        }
        Subject existingSubject = subjectRepository.findBySubjectName(subjectRequest.getName());

        if (existingSubject == null) {
            Subject subject = Subject.build(0, subjectRequest.getName(), null,null);
            subject = subjectRepository.save(subject);
            // Add the subject to the semester by updating the mapping
            semester.getSubjects().add(subject);
            semesterRepository.save(semester);

            return subject;
        } else {
            semesterRepository.deleteById(semester_id);
            return null;
        }
    }

    public Subject updateSubject(int subjectId, SubjectRequest updatedSubject) {
        Subject existingSubject = subjectRepository.findById(subjectId).orElse(null);

        if (existingSubject != null) {
            existingSubject.setSubjectName(updatedSubject.getName());


            return subjectRepository.save(existingSubject);
        } else {
            throw new RuntimeException("Subject not found with ID: " + subjectId);
        }
    }

    public void deleteSubject(int subjectId) {
        boolean subject = subjectRepository.existsById(subjectId);

        if (subject) {
            subjectRepository.deleteById(subjectId);
        } else {
            throw new RuntimeException("Subject not found with ID: " + subjectId);
        }
    }
}

