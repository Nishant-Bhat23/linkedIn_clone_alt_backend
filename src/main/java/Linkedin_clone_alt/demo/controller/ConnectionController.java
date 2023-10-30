
package Linkedin_clone_alt.demo.controller;


import Linkedin_clone_alt.demo.dto.ConnectionRequest;
import Linkedin_clone_alt.demo.Entity.Connection;
import Linkedin_clone_alt.demo.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/connection")
public class ConnectionController {

    @Autowired
    private ConnectionService connectionService;

    @PostMapping("/accept")
    public Connection accept(@RequestBody ConnectionRequest connectionRequest) {
        return connectionService.acceptConnection(connectionRequest);
    }

    @PostMapping("/decline")
    public String decline(@RequestBody ConnectionRequest connectionRequest)
    {
        return connectionService.declineConnection(connectionRequest);
    }

    @GetMapping("/myconnections/{userId}")
    public List<Connection> getConnection(@PathVariable int userId) {
        return connectionService.getConnection(userId);
    }

    @GetMapping("/myConnection/{connectedId}")
    public List<Connection> getConnections(@PathVariable int connectedId)
    {
        return connectionService.getConnections(connectedId);
    }

}

