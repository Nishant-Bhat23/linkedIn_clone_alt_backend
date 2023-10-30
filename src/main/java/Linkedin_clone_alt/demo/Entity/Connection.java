package Linkedin_clone_alt.demo.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Entity
@Table(name="Connections")
public class Connection {

    @Id
    @GeneratedValue
    private int connection_id;
    private int userId;
    private int connectedId;
}
