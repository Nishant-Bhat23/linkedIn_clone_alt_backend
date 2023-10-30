package Linkedin_clone_alt.demo.controller;


import Linkedin_clone_alt.demo.dto.SubjectRequest;
import Linkedin_clone_alt.demo.Entity.Subject;
import Linkedin_clone_alt.demo.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/getAllSubjects")
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @GetMapping("/{subjectId}")
    public Subject getSubjectById(@PathVariable int subjectId) {
        return subjectService.getSubjectById(subjectId);
    }

    @PostMapping("/{semester_id}/addSubject")
    public Subject addSubject(@PathVariable int semester_id,@RequestBody SubjectRequest subjectRequest) {
        return subjectService.addSubject(semester_id,subjectRequest);
    }

    @PutMapping("/{subjectId}")
    public Subject updateSubject(@PathVariable int subjectId, @RequestBody SubjectRequest subjectRequest) {
        return subjectService.updateSubject(subjectId, subjectRequest);
    }

    @DeleteMapping("/{subjectId}")
    public void deleteSubject(@PathVariable int subjectId) {
        subjectService.deleteSubject(subjectId);
    }
}

