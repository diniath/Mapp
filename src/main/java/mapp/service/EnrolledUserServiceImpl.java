package mapp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import mapp.converter.EnrolledUserUpdateDtoConverter;
import mapp.dao.EnrolledUserDao;
import mapp.dto.EnrolledUserDto;
import mapp.dto.EnrolledUserUpdateDto;
import mapp.entity.Appointment;
import mapp.entity.EnrolledUser;
import mapp.entity.ImageUrl;
import mapp.entity.Ordering;
import mapp.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EnrolledUserServiceImpl {

    @Autowired
    private EnrolledUserDao dao;

    @Autowired
    private EnrolledUserUpdateDtoConverter converter;

    @Autowired
    private ImageUrlServiceImpl service;

    public List<EnrolledUserDto> retrieveAll(String username) {
        return dao.retrieveUsernameAsDTO(username);
    }

    public List<EnrolledUser> findAll() {
        return dao.findAll();
    }

    // This method prevents an enrolledUser to be saved as ADMIN (or Company)
    public EnrolledUser create(EnrolledUser enrolledUser) {
        EnrolledUser createdUser = null;
        if (enrolledUser.getRoleList().size() == 1) {
            Role role = enrolledUser.getRoleList().get(0);
//            System.out.println(role);
            if (role.getId() == 1) {
                createdUser = dao.save(enrolledUser);
            }
        }
        return createdUser;
    }

    // supports update operation 
    // to prevent list of entities from being deleted
    public void edit(EnrolledUser enrolledUser) {

        EnrolledUserUpdateDto dto = converter.entityToDto(enrolledUser);

//        String username = enrolledUser.getUsername();
//        String password = enrolledUser.getPassword();
//        String fname = enrolledUser.getFname();
//        String lname = enrolledUser.getLname();
//        String email = enrolledUser.getEmail();
//        LocalDate dateofbirth = enrolledUser.getDateofbirth();
//        Integer postalcode = enrolledUser.getPostalcode();
//        String address = enrolledUser.getAddress();
//        String city = enrolledUser.getCity();
//        String municipality = enrolledUser.getMunicipality();
//        String telephone = enrolledUser.getTelephone();
//        String mobile = enrolledUser.getMobile();
//        Integer id = enrolledUser.getId();
        dao.setEnrolledUserInfoById(
                dto.getUsername(), dto.getPassword(), dto.getFname(), dto.getLname(),
                dto.getEmail(), dto.getDateofbirth(), dto.getPostalcode(), dto.getAddress(),
                dto.getCity(), dto.getMunicipality(), dto.getTelephone(), dto.getMobile(),
                dto.getId()
        );

        // change imageUrl *** ***  
        if (!(enrolledUser.getImageUrl().getUrl() == null)) {
                service.edit(enrolledUser.getImageUrl());
        }

    }

    public void delete(int id) {
        dao.deleteById(id);
    }

    public Optional<EnrolledUser> findById(int id) {
        Optional<EnrolledUser> enrolledUser = dao.findById(id);
        return enrolledUser;
    }

//    public EnrolledUser findEnrolledUserByAddress(@PathVariable(value = "address") String address){
//        return dao.findByAddress(address);
//    }
}
