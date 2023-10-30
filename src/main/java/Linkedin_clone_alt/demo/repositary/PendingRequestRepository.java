package Linkedin_clone_alt.demo.repositary;


import Linkedin_clone_alt.demo.Entity.PendingRequest;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PendingRequestRepository extends JpaRepository<PendingRequest, Integer>{
    @Transactional
    List<PendingRequest> findByUserId(int user_id);
    @Transactional
    void deleteByUserId(int user_id);
}

