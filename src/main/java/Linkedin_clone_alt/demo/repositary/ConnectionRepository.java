package Linkedin_clone_alt.demo.repositary;


import Linkedin_clone_alt.demo.Entity.Connection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConnectionRepository extends JpaRepository<Connection, Integer> {
    Connection deleteByUserId(int connected_id);
    List<Connection> findByUserId(int userId);
    List<Connection> findByConnectedId(int connectedId);
}
