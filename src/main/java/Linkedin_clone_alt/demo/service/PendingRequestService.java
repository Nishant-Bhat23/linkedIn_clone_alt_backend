package Linkedin_clone_alt.demo.service;


import Linkedin_clone_alt.demo.dto.pendingRequestDto;
import Linkedin_clone_alt.demo.Entity.PendingRequest;
import Linkedin_clone_alt.demo.repositary.PendingRequestRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PendingRequestService {

    @Autowired
    private PendingRequestRepository pendingRequestRepository;

    public PendingRequest RequestSent(@RequestBody @NotNull pendingRequestDto pendingRequestdto) {
        PendingRequest pendingRequest=PendingRequest.build(0, pendingRequestdto.getUserId(), pendingRequestdto.getRequestedUser_id());
        return pendingRequestRepository.save(pendingRequest);
    }

    public List<PendingRequest> getPendingRequest(int user_id){
        return pendingRequestRepository.findByUserId(user_id);
    }


}
