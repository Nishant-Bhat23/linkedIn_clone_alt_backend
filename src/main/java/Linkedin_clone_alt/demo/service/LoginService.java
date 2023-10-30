package Linkedin_clone_alt.demo.service;

import Linkedin_clone_alt.demo.Exception.PasswordDoesNotMatchException;
import Linkedin_clone_alt.demo.Exception.UserDoesNotExistException;
import Linkedin_clone_alt.demo.dto.LoginRequest;
import Linkedin_clone_alt.demo.Entity.UserProfile;
import Linkedin_clone_alt.demo.repositary.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository;

    public UserProfile loginUser(LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        if(userRepository.existsByUsername(username)) {
            UserProfile user = userRepository.findByUsername(username);
            if(password.equals(user.getPassword())){
                return userRepository.findByUsername(username);
            }
            else
                throw new PasswordDoesNotMatchException("Password does not Match!!");
        }
        else
            throw new UserDoesNotExistException("User Does not exist!!!");
    }
}