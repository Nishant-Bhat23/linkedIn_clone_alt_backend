package Linkedin_clone_alt.demo.controller;

import Linkedin_clone_alt.demo.dto.SkillRequest;
import Linkedin_clone_alt.demo.Entity.Skill;
import Linkedin_clone_alt.demo.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/skill")
public class SkillController {
    @Autowired
    private SkillService service;

    @PostMapping("/{user_id}/addSkill")
    public Skill addSkill(@PathVariable int user_id, @RequestBody SkillRequest skillRequest) {
        return service.saveSkill(user_id, skillRequest);
    }

    @GetMapping("/allSkill")
    public List<Skill> findAllSkilles() {
        return service.getSkills();
    }

    @GetMapping("/getSkill")
    public Skill getSkill1(@PathVariable int skill_id) {
        return service.getSkillById(skill_id);
    }

    @GetMapping("/{user_id}/getSkill")
    public List<Skill> getSkillByUser(@PathVariable int user_id){
        return service.getSkillByUser(user_id);
    }

    @GetMapping("/getSkill/{skill_id}")
    public Skill getSkill(@PathVariable int skill_id) {
        return service.getSkillById(skill_id);
    }

    @PutMapping("/update/{skill_id}")
    public Skill updateSkill(@PathVariable int skill_id, @RequestBody SkillRequest skillRequest) {
        return service.updateSkill(skill_id, skillRequest);
    }

    @DeleteMapping("/delete/{skill_id}")
    public String deleteSkill(@PathVariable int skill_id) {
        return service.deleteSkill(skill_id);
    }

}