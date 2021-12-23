package com.cybertek.controller;

import com.cybertek.model.*;
import com.cybertek.repository.AddressRepository;
import com.cybertek.repository.ParentRepository;
import com.cybertek.repository.StudentRepository;
import com.cybertek.repository.TeacherRepository;
import com.cybertek.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ApiController {

    //address for all of them
    //others only get
    //create repository
    //build method rest, get, object and consume it in address


    private TeacherRepository teacherRepository;
    private StudentRepository studentRepository;
    private ParentRepository parentRepository;
    private AddressRepository addressRepository;

    public ApiController(TeacherRepository teacherRepository, StudentRepository studentRepository, ParentRepository parentRepository, AddressRepository addressRepository) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.parentRepository = parentRepository;
        this.addressRepository = addressRepository;
    }

    @GetMapping("/teachers")
    public List<Teacher> readAllTeachers(){
        return teacherRepository.findAll();
    }

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> readAllStudents(){
        return ResponseEntity
                .ok(new ResponseWrapper("students are successfully retrieved", studentRepository.findAll()));
    }

    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> readAllParents(){
        ResponseWrapper responseWrapper = new ResponseWrapper(true, "parents are successfully retrieved",
                HttpStatus.ACCEPTED.value(),
                parentRepository.findAll());

        //return ResponseEntity.ok(responseWrapper);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseWrapper);
    }

    @PutMapping("/address/{id}")
    public Address updateTemperature(@PathVariable("id") long id, @RequestBody Address address) throws Exception {
        Optional<Address> foundAddress = addressRepository.findById(id);

        if(!foundAddress.isPresent()){
            throw new Exception("This address could not find");
        }

        address.setCurrentTemperature(new Address().consumeTemp(address.getCity()));

        address.setId(foundAddress.get().getId());

        return addressRepository.save(address);
    }








    /*private AddressService addressService;

    public ApiController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Address> getAddress(@PathVariable("id") long id){
        addressService.getAddress(id);
        return ResponseEntity.ok(addressService.getAddress(id));
    }



    @GetMapping
    public ResponseEntity<List<Address>> getAddresses(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Version","Cybertek.v1");

        return ResponseEntity
                .ok()
                .headers(httpHeaders)
                .body(addressService.getAddresses());
    }*/
}
