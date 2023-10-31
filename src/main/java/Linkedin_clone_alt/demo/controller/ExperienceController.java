package Linkedin_clone_alt.demo.controller;
import Linkedin_clone_alt.demo.dto.ExperienceRequest;
import Linkedin_clone_alt.demo.Entity.Experience;
import Linkedin_clone_alt.demo.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/experience")
public class ExperienceController {
    @Autowired
    private  ExperienceService service;

    @PostMapping("/{user_id}/addExperience")
    public Experience addExperience(@PathVariable int user_id, @RequestBody ExperienceRequest experienceRequest) {
        return service.saveExperience(user_id, experienceRequest);
    }

    @GetMapping("/allExperience")
    public List<Experience> findAllExperiences() {
        return service.getExperiences();
    }

    @GetMapping("/getExperience")
    public Experience getExperience1(@PathVariable int experience_id) {
        return service.getExperienceById(experience_id);
    }

    @GetMapping("/{user_id}/getExperience")
    public List<Experience> getExperienceByUser(@PathVariable int user_id){
        return service.getExperienceByUser(user_id);
    }

    @GetMapping("/getExperience/{experience_id}")
    public Experience getExperience(@PathVariable int experience_id) {
        return service.getExperienceById(experience_id);
    }

    @PutMapping("/update/{experience_id}")
    public Experience updateExperience(@PathVariable int experience_id, @RequestBody ExperienceRequest experienceRequest) {
        return service.updateExperience(experience_id,experienceRequest);
    }

    @DeleteMapping("/delete/{experience_id}")
    public String deleteExperience(@PathVariable int experience_id) {
        return service.deleteExperience(experience_id);
    }

}