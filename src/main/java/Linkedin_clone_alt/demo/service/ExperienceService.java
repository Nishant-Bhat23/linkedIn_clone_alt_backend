package Linkedin_clone_alt.demo.service;

import Linkedin_clone_alt.demo.Entity.Experience;
import Linkedin_clone_alt.demo.dto.EducationRequest;
import Linkedin_clone_alt.demo.dto.ExperienceRequest;
import Linkedin_clone_alt.demo.dto.SkillRequest;
import Linkedin_clone_alt.demo.Entity.Skill;
import Linkedin_clone_alt.demo.Entity.UserProfile;
import Linkedin_clone_alt.demo.repositary.ExperienceRepository;
import Linkedin_clone_alt.demo.repositary.SkillRepository;
import Linkedin_clone_alt.demo.repositary.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {

    @Autowired
    public ExperienceRepository experienceRepository;
    @Autowired
    public UserRepository userRepository;
    public Experience saveExperience(int user_id, ExperienceRequest experienceRequest) {
        UserProfile user = userRepository.findById(user_id).orElse(null);
        if(user!= null) {
            Experience experience= Experience.build(0, experienceRequest.getCompany_name(), experienceRequest.getPosition(), experienceRequest.getStart_date(), experienceRequest.getEnd_date() ,user);

            return experienceRepository.save(experience);
        }
        return null;
    }

    public Experience getExperienceById(int experience_id) {
        return experienceRepository.findById(experience_id).orElse(null);
    }
    public List<Experience> getExperiences() {
        return experienceRepository.findAll();
    }

    public List<Experience> getExperienceByUser(int user_id){
        UserProfile user = userRepository.findById(user_id).orElse(null);
        return experienceRepository.findAllByUserProfile(user);
    }

    public String deleteExperience(int experience_id) {
        experienceRepository.deleteById(experience_id);
        return "Experience Removed!!" + experience_id;
    }

    public Experience updateExperience(int experience_id, ExperienceRequest experienceRequest) {
        Experience existingExperience = experienceRepository.findById(experience_id).orElse(null);

        if (existingExperience != null) {
            existingExperience.setCompany_name(experienceRequest.getCompany_name());
            existingExperience.setPosition(experienceRequest.getPosition());
            existingExperience.setStart_date(experienceRequest.getStart_date());
            existingExperience.setEnd_date(experienceRequest.getEnd_date());
            return experienceRepository.save(existingExperience);
        } else {

            return null;
        }
    }
}