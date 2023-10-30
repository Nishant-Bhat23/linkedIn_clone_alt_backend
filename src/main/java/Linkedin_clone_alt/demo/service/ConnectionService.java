package Linkedin_clone_alt.demo.service;

import Linkedin_clone_alt.demo.dto.ConnectionRequest;
import Linkedin_clone_alt.demo.Entity.Connection;
import Linkedin_clone_alt.demo.repositary.ConnectionRepository;
import Linkedin_clone_alt.demo.repositary.PendingRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConnectionService {
    @Autowired
    private ConnectionRepository connectionRepository;
    @Autowired
    private PendingRequestRepository pendingRequestRepository;

    public Connection acceptConnection(ConnectionRequest connectionRequest){
        pendingRequestRepository.deleteByUserId(connectionRequest.getUserId());
        Connection connection = Connection.build(0, connectionRequest.getUserId(), connectionRequest.getConnected_id());
        return connectionRepository.save(connection);
    }

    public String declineConnection(ConnectionRequest connectionRequest) {
        pendingRequestRepository.deleteByUserId(connectionRequest.getUserId());
        return "Declined";
    }

    public List<Connection> getConnection() {
        return connectionRepository.findAll();
    }

    public String deleteConnection(int connected_id) {
        connectionRepository.deleteByUserId(connected_id);
        return "Removed";
    }

    public List<Connection> getConnection(int userId) {
        return connectionRepository.findByUserId(userId);
    }

    public List<Connection> getConnections(int connectedId){
        return connectionRepository.findByConnectedId(connectedId);
    }
}
