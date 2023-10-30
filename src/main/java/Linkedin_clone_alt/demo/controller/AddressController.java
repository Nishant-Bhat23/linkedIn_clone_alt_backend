package Linkedin_clone_alt.demo.controller;


import Linkedin_clone_alt.demo.dto.AddressRequest;
import Linkedin_clone_alt.demo.Entity.Address;
import Linkedin_clone_alt.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService service;

    @PostMapping("/{user_id}/addAddress")
    public Address addAddress(@PathVariable int user_id, @RequestBody AddressRequest addressRequest) {
        return service.saveAddress(user_id,addressRequest);
    }


    @GetMapping("/allAddress")
    public List<Address> findAllAddresses(){
        return service.getAddresses();
    }


    @GetMapping("/{address_id}")
    public Address findAddressById(@PathVariable int address_id) {
        return service.getAddressById(address_id);
    }


    @GetMapping("/getAddress/{user_id}")
    public List<Address> getCourseByUserId(@PathVariable int user_id){
        return service.getAddressByUserId(user_id);
    }
    @PutMapping("/update/{address_id}")
    public Address updateCourse(@PathVariable int address_id, @RequestBody AddressRequest AddressRequest) {
        return service.updateAddress(address_id, AddressRequest);
    }

    @DeleteMapping("/delete/{address_id}")
    public String deleteAddress(@PathVariable int address_id) {
        return service.deleteAddress(address_id);
    }
}