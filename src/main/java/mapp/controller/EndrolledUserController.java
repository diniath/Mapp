/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapp.controller;

import java.util.List;
import java.util.Optional;
import mapp.entity.EnrolledUser;
import mapp.service.EnrolledUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @enrolledUser Hello Java !
 */
@RestController//@RestController = @Controller + @ResponseBody
@RequestMapping("/enrolledUser")
public class EndrolledUserController {

    @Autowired
    private EnrolledUserServiceImpl service;

    
    @GetMapping
    public List<EnrolledUser> getEnrolledUsers() {
        return service.findAll();
    }

    @GetMapping("/{myvariable}")
    public EnrolledUser getEnrolledUserById(@PathVariable(value = "myvariable") Integer enrolledUserId) throws Exception {
        Optional<EnrolledUser> optionalEnrolledUser = service.findById(enrolledUserId);
        return optionalEnrolledUser.orElseThrow(() -> new Exception("EnrolledUser not exists with id:" + enrolledUserId));
        //return optionalEnrolledUser.get();
    }

    @PostMapping
    public EnrolledUser createEnrolledUser(@RequestBody EnrolledUser enrolledUser) {
        return service.create(enrolledUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEnrolledUserById(@PathVariable(value = "id") Integer enrolledUserId) {
        service.delete(enrolledUserId);
        return ResponseEntity.ok("EnrolledUser deleted successfully, ID:" + enrolledUserId);
    }

    @PutMapping("/{id}")
    public void updateEnrolledUser(@PathVariable(value = "id") Integer enrolledUserId,
            @RequestBody EnrolledUser newEnrolledUserDetails) throws Exception {
        Optional<EnrolledUser> optionalEnrolledUser = service.findById(enrolledUserId);
        EnrolledUser enrolledUserToUpdate = optionalEnrolledUser.orElseThrow(() -> new Exception("EnrolledUser not exists with id:" + enrolledUserId));
        
//        enrolledUserToUpdate.setDay(newEnrolledUserDetails.getDay());
        service.edit(newEnrolledUserDetails);
    }
    
//    @GetMapping("/search/{address}")
//    public EnrolledUser getEnrolledUserByAddress(@PathVariable(value = "address") String address){
//        return service.findEnrolledUserByAddress(address);
//    }

}
