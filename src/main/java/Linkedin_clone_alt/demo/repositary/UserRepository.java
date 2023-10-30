package Linkedin_clone_alt.demo.repositary;

import Linkedin_clone_alt.demo.Entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserProfile, Integer>
{
    public UserProfile findByUsername(String username);
    public boolean existsByUsername(String username);
}

