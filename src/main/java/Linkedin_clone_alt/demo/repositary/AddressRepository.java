package Linkedin_clone_alt.demo.repositary;


import Linkedin_clone_alt.demo.Entity.Address;
import Linkedin_clone_alt.demo.Entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer>{
    List<Address> findAllByUsers(UserProfile user);
}