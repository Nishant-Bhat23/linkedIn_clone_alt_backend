package Linkedin_clone_alt.demo.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@Data
public class AddressRequest {
    @Id
    @GeneratedValue
    @NotNull
    private int address_id;
    private String address_type;
    private String street_address;
    private String city;
    private String state;
    private String postal_code;
    private String country;
}
