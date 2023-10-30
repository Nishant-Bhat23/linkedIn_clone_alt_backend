package Linkedin_clone_alt.demo.controller;

import Linkedin_clone_alt.demo.dto.pendingRequestDto;
import Linkedin_clone_alt.demo.Entity.PendingRequest;
import Linkedin_clone_alt.demo.service.PendingRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/connection")
public class PendingRequestController {
    @Autowired
    private PendingRequestService pendingRequestService;

    @PostMapping("/send")
    public PendingRequest addPendingRequest(@RequestBody pendingRequestDto pendingRequestdto) {
        return pendingRequestService.RequestSent(pendingRequestdto);
    }

    @GetMapping("/getRequest/{user_id}")
    public List<PendingRequest> getRequestByUserId(@PathVariable int user_id){
        return pendingRequestService.getPendingRequest(user_id);
    }

}
