package Linkedin_clone_alt.demo.service;

import Linkedin_clone_alt.demo.dto.EducationRequest;
import Linkedin_clone_alt.demo.Entity.Education;
import Linkedin_clone_alt.demo.repositary.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    public Education save(EducationRequest educationRequest) {
        Education education = new Education();
        education.setUserId(educationRequest.getUserId());
        education.setTenth_schoolname(educationRequest.getTenth_schoolname());
        education.setTenth_school_city(educationRequest.getTenth_school_city());
        education.setTenth_pass_year(educationRequest.getTenth_pass_year());
        education.setCollege_name(educationRequest.getCollege_name());
        education.setCollege_city(educationRequest.getCollege_city());
        education.setTwelth_pass_year(educationRequest.getTwelth_pass_year());
        education.setDegree(educationRequest.getDegree());
        education.setDegree_collegename(educationRequest.getDegree_collegename());
        education.setDegree_collegeplace(educationRequest.getDegree_collegeplace());
        education.setUniversity_name(educationRequest.getUniversity_name());
        education.setBranch(educationRequest.getBranch());
        education.setCurrent_year(educationRequest.getCurrent_year());
        education.setCgpa(educationRequest.getCgpa());
        education.setGraduation_year(educationRequest.getGraduation_year());

        return educationRepository.save(education);
    }

    public Education getEducationByUserId(int userId) {
        return educationRepository.findByUserId(userId);
    }

    public String deleteEducation(int educationId) {
        Education education = educationRepository.findById(educationId).orElse(null);
        educationRepository.delete(education);
        return "Education details Removed!!" + educationId;
    }

    public Education updateEducation(int education_id,EducationRequest educationRequest) {
        Education existingEducation = educationRepository.findById(education_id).orElse(null);
        if (existingEducation != null) {
            existingEducation.setUserId(educationRequest.getUserId());
            existingEducation.setTenth_schoolname(educationRequest.getTenth_schoolname());
            existingEducation.setTenth_school_city(educationRequest.getTenth_school_city());
            existingEducation.setTenth_pass_year(educationRequest.getTenth_pass_year());
            existingEducation.setCollege_name(educationRequest.getCollege_name());
            existingEducation.setCollege_city(educationRequest.getCollege_city());
            existingEducation.setTwelth_pass_year(educationRequest.getTwelth_pass_year());
            existingEducation.setDegree(educationRequest.getDegree());
            existingEducation.setDegree_collegename(educationRequest.getDegree_collegename());
            existingEducation.setDegree_collegeplace(educationRequest.getDegree_collegeplace());
            existingEducation.setUniversity_name(educationRequest.getUniversity_name());
            existingEducation.setBranch(educationRequest.getBranch());
            existingEducation.setCurrent_year(educationRequest.getCurrent_year());
            existingEducation.setCgpa(educationRequest.getCgpa());
            existingEducation.setGraduation_year(educationRequest.getGraduation_year());

            return educationRepository.save(existingEducation);
        }
        return null; // Handle the case where the education record doesn't exist
    }
}