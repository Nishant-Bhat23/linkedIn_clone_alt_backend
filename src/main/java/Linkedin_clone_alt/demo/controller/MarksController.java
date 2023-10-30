package Linkedin_clone_alt.demo.controller;

import Linkedin_clone_alt.demo.dto.MarksRequest;
import Linkedin_clone_alt.demo.Entity.Marks;
import Linkedin_clone_alt.demo.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marks")
@CrossOrigin(origins="http://localhost:3000")
public class MarksController {

    @Autowired
    private MarksService marksService;

    @PostMapping("/addMarks")
    public Marks addMarks(@RequestBody MarksRequest marksRequest) {
        return marksService.addMarks(marksRequest);
    }

    @GetMapping("/{userId}")
    public List<Marks> getUserMarks(@PathVariable int userId) {
        return marksService.getUserMarks(userId);
    }
}


