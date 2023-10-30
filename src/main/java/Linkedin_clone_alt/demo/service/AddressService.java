package Linkedin_clone_alt.demo.service;

import Linkedin_clone_alt.demo.dto.AddressRequest;
import Linkedin_clone_alt.demo.Entity.Address;
import Linkedin_clone_alt.demo.Entity.UserProfile;
import Linkedin_clone_alt.demo.repositary.AddressRepository;
import Linkedin_clone_alt.demo.repositary.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;

    public Address saveAddress(int user_id,AddressRequest addressRequest) {
        UserProfile user = userRepository.findById(user_id).orElse(null);
        if(user!= null) {
            Address address = Address.build(0,addressRequest.getAddress_type(),addressRequest.getStreet_address(), addressRequest.getCity(), addressRequest.getState(), addressRequest.getPostal_code(), addressRequest.getCountry(), null );
            user.getAddresses().add(address);
            return addressRepository.save(address);
        }
        return null;
    }
    public List<Address> getAddresses() {
        return addressRepository.findAll();

    }
    public List<Address> getAddressByUserId(int user_id){
        UserProfile user = userRepository.findById(user_id).orElse(null);
        return addressRepository.findAllByUsers(user);
    }
    public Address getAddressById(int address_id) {
        return addressRepository.findById(address_id).orElse(null);

    }



    public String deleteAddress(int id) {
        addressRepository.deleteById(id);
        return "Address Removed!!"+id;
    }

    public Address updateAddress(AddressRequest addressRequest) {
        Address existingAddress=addressRepository.findById(addressRequest.getAddress_id()).orElse(null);
        existingAddress.setAddress_type(addressRequest.getAddress_type());
        existingAddress.setStreet_address(addressRequest.getStreet_address());
        existingAddress.setCity(addressRequest.getCity());
        existingAddress.setState(addressRequest.getState());
        existingAddress.setPostal_code(addressRequest.getPostal_code());
        existingAddress.setCountry(addressRequest.getCountry());
        return addressRepository.save(existingAddress);

    }

    public Address updateAddress(int address_id, AddressRequest updatedAddress) {
        // Check if the address with the given address_id exists
        Address existingAddress = addressRepository.findById(address_id).orElse(null);
        if (existingAddress !=null) {

            existingAddress.setAddress_type(updatedAddress.getAddress_type());
            existingAddress.setStreet_address(updatedAddress.getStreet_address());
            existingAddress.setCity(updatedAddress.getCity());
            existingAddress.setState(updatedAddress.getState());
            existingAddress.setPostal_code(updatedAddress.getPostal_code());
            existingAddress.setCountry(updatedAddress.getCountry());
            return addressRepository.save(existingAddress);
        } else {
            // If the address with the given address_id does not exist
            throw new RuntimeException("Address not found with ID: " + address_id);
        }
    }
}