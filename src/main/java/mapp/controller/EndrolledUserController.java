package mapp.controller;

import java.util.List;
import java.util.Optional;
import mapp.converter.EnrolledUserConverter;
import mapp.entity.EnrolledUser;
import mapp.dto.EnrolledUserDto;
import mapp.entity.Appointment;
import mapp.entity.ImageUrl;
import mapp.entity.Ordering;
import mapp.entity.Product;
import mapp.entity.Role;
import mapp.service.EnrolledUserServiceImpl;
import mapp.service.ImageUrlServiceImpl;
import mapp.service.OrderingServiceImpl;
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

@RestController//@RestController = @Controller + @ResponseBody
@RequestMapping("/enrolledUser")
public class EndrolledUserController {

    @Autowired
    private EnrolledUserServiceImpl service;

    @Autowired
    private EnrolledUserConverter converter;

    @Autowired
    private OrderingServiceImpl ordService;

    @Autowired
    private ImageUrlServiceImpl imgService;

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

        /* This method retrieves all the values stored inside an enrolledUser 
        before editing to prevent any data loss, due to how save method works 
         */
        Optional<EnrolledUser> optionalEnrolledUser = service.findById(enrolledUserId);
        EnrolledUser enrolledUser = optionalEnrolledUser.orElseThrow(() -> new Exception("EnrolledUser not exists with id:" + enrolledUserId));

        if (!enrolledUser.getAppointmentList().isEmpty() && !(enrolledUser.getAppointmentList() == null)) {
            List<Appointment> appointmentList = enrolledUser.getAppointmentList();
            int appointmentListLength = appointmentList.size();
            for (byte i = 0; i < appointmentListLength; i++) {
                newEnrolledUserDetails.getAppointmentList().add(appointmentList.get(i));
            }
        }

        if (!enrolledUser.getRoleList().isEmpty() && !(enrolledUser.getRoleList() == null)) {
            List<Role> roleList = enrolledUser.getRoleList();
            int roleListLength = roleList.size();
            for (byte i = 0; i < roleListLength; i++) {
                newEnrolledUserDetails.getRoleList().add(roleList.get(i));
            }
        }

        if (!enrolledUser.getProductList().isEmpty() && !(enrolledUser.getProductList() == null)) {
            List<Product> productList = enrolledUser.getProductList();
            int productListLength = productList.size();
            for (byte i = 0; i < productListLength; i++) {
                newEnrolledUserDetails.getProductList().add(productList.get(i));
            }
        }

        List<Ordering> ordering = ordService.findAllOrderingByEnrolledUserId(enrolledUserId);
        if (!ordering.isEmpty()) {
            newEnrolledUserDetails.setOrderingList(ordering);
        }

        ImageUrl imageUrl = imgService.findById(enrolledUserId).get();
        if (!(imageUrl == null) || newEnrolledUserDetails.getImageUrl() == null) {
            newEnrolledUserDetails.setImageUrl(imageUrl);
        }
        service.edit(newEnrolledUserDetails);
    }

//    @GetMapping("/search/{address}")
//    public EnrolledUser getEnrolledUserByAddress(@PathVariable(value = "address") String address){
//        return service.findEnrolledUserByAddress(address);
//    }
}
