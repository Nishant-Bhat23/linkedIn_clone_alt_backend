package Linkedin_clone_alt.demo.controller;

import Linkedin_clone_alt.demo.dto.LoginRequest;
import  Linkedin_clone_alt.demo.dto.ProfilePicDTO;
import  Linkedin_clone_alt.demo.dto.UserRequest;
import  Linkedin_clone_alt.demo.Entity.UserProfile;
import  Linkedin_clone_alt.demo.service.LoginService;
import  Linkedin_clone_alt.demo.service.ProfilePictureService;
import  Linkedin_clone_alt.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private ProfilePictureService profileService;
    @PostMapping("/signup")
    public ResponseEntity<UserProfile> saveUser(@RequestBody @Valid UserRequest userRequest)
    {
        return new ResponseEntity<>(userService.saveUser(userRequest),HttpStatus.CREATED);
    }

    @GetMapping("/fetchAllUsers")
    public ResponseEntity<List<UserProfile>> getAllUser()
    {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/login")
    public ResponseEntity<UserProfile> validateUser(@RequestBody @Valid LoginRequest loginRequest)
    {
        return new ResponseEntity<>(loginService.loginUser(loginRequest),HttpStatus.ACCEPTED);
    }
    @PostMapping("/uploadPic/{user_id}")
    public ResponseEntity<UserProfile> savePic(@PathVariable int user_id, @RequestBody ProfilePicDTO profilePicDTO)
    {
        profileService.savePicture(user_id, profilePicDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{user_id}/getUser")
    public ResponseEntity<UserProfile> getUserById(@PathVariable int user_id)
    {
        return new ResponseEntity<>(userService.getUserById(user_id),HttpStatus.ACCEPTED);
    }
}

