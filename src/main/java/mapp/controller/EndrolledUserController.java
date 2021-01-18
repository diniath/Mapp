package mapp.controller;

import java.util.List;
import java.util.Optional;
import mapp.converter.EnrolledUserConverter;
import mapp.entity.EnrolledUser;
import mapp.dto.EnrolledUserDto;
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

@RestController
@RequestMapping("/enrolledUser")
public class EndrolledUserController {

    @Autowired
    private EnrolledUserServiceImpl service;

    @Autowired
    private EnrolledUserConverter converter;

    @GetMapping("/dto")
    public List<EnrolledUserDto> getEnrolledUsersDto() {
        List<EnrolledUser> findAll = service.findAll();
        return converter.entityToDto(findAll);
    }

    @GetMapping("/dto/{id}")
    public EnrolledUserDto getEnrolledUserDto(@PathVariable(value = "id") Integer enrolledUserId) {
        EnrolledUser findById = service.findById(enrolledUserId).get();
        return converter.entityToDto(findById);
    }

    @GetMapping("searchBy/{username}")
    public List<EnrolledUserDto> getEnrolledUsers(@PathVariable(value = "username") String username) {
        return service.retrieveAll(username);
    }

    @GetMapping("/{id}")
    public EnrolledUser getEnrolledUserById(@PathVariable(value = "id") Integer enrolledUserId) throws Exception {
        Optional<EnrolledUser> optionalEnrolledUser = service.findById(enrolledUserId);
        return optionalEnrolledUser.orElseThrow(() -> new Exception("EnrolledUser not exists with id:" + enrolledUserId));
    }

    @PostMapping
    public EnrolledUser createEnrolledUser(@RequestBody EnrolledUser enrolledUser) {
        return service.create(enrolledUser);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteEnrolledUserById(@PathVariable(value = "id") Integer enrolledUserId) {
        service.delete(enrolledUserId);
        return ResponseEntity.ok("EnrolledUser deleted successfully, ID:" + enrolledUserId);
    }

    @PutMapping("/dto/{id}")
    public void updateEnrolledUser(@PathVariable(value = "id") Integer enrolledUserId,
            @RequestBody EnrolledUser newEnrolledUserDetails) throws Exception {
        /* This method retrieves all the values stored inside an enrolledUser 
        before editing to prevent any data loss, due to how save method works 
         */
        Optional<EnrolledUser> optionalEnrolledUser = service.findById(enrolledUserId);
        optionalEnrolledUser.orElseThrow(() -> new Exception("EnrolledUser not exists with id:" + enrolledUserId));
        newEnrolledUserDetails.setId(enrolledUserId);
        service.edit(newEnrolledUserDetails);
    }

    @GetMapping("/search/{username}")
    public EnrolledUserDto findEnrolledUserByUsername(@PathVariable(value = "username") String username) {
        return converter.entityToDto(service.findEnrolledUserByUsername(username).get());
    }

}
