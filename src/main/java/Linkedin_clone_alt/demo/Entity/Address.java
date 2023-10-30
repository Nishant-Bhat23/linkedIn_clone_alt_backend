package Linkedin_clone_alt.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Entity
@Table(name="ADDRESS")
public class Address {

    @Id
    @GeneratedValue
    private int address_id;
    private String address_type;
    private String street_address;
    private String city;
    private String state;
    private String postal_code;
    private String country;

    @ManyToMany(mappedBy = "addresses",fetch = FetchType.LAZY)
    private Set<UserProfile> users=new HashSet<>();



}


