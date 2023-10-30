package Linkedin_clone_alt.demo.controller;

import Linkedin_clone_alt.demo.dto.EducationRequest;
import Linkedin_clone_alt.demo.Entity.Education;
import Linkedin_clone_alt.demo.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/education")
public class EducationController {


    @Autowired
    private EducationService service;

    @PostMapping("/addEducation")
    public Education addEducation(@RequestBody EducationRequest educationRequest) {
        return service.save(educationRequest);
    }


    @GetMapping("/educationByUserId/{userId}")
    public Education findEducationByUserId(@PathVariable int userId) {
        return service.getEducationByUserId(userId);
    }


    @PutMapping("/update/{education_id}")
    public Education updateEducation(@PathVariable int education_id,@RequestBody EducationRequest educationRequest) {
        return service.updateEducation(education_id,educationRequest);
    }

    @DeleteMapping("/delete/{education_id}")
    public String deleteEducation(@PathVariable int education_id) {
        return service.deleteEducation(education_id);
    }
}
