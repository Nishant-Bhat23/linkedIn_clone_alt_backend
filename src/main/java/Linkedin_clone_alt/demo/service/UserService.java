package Linkedin_clone_alt.demo.service;

import Linkedin_clone_alt.demo.Exception.DuplicateUserNameException;
import Linkedin_clone_alt.demo.dto.UserRequest;
import Linkedin_clone_alt.demo.Entity.UserProfile;
import Linkedin_clone_alt.demo.repositary.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //add single user
    public UserProfile saveUser(UserRequest userRequest){
        String username = userRequest.getUsername();
        boolean userExists = userRepository.existsByUsername(username);
        if(userExists)
            throw new DuplicateUserNameException("Username Already Exists!!");
        UserProfile user = UserProfile.build(0, userRequest.getUsername(), userRequest.getFirstname(), userRequest.getLastname(), userRequest.getEmail(), userRequest.getPassword(), userRequest.getContact(),userRequest.getDate(),null, null,null,null);
        return userRepository.save(user);
    }

    //get All users
    public List<UserProfile> getAllUsers(){
        return userRepository.findAll();
    }

    //get user by id
    public UserProfile getUserById(int user_id) {
        return userRepository.findById(user_id).orElse(null);
    }
}
