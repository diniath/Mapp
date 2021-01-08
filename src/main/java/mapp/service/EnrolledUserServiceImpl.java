package mapp.service;

import java.util.List;
import java.util.Optional;
import mapp.dao.EnrolledUserDao;
import mapp.dto.EnrolledUserDto;
import mapp.entity.EnrolledUser;
import mapp.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EnrolledUserServiceImpl {

    @Autowired
    private EnrolledUserDao dao;

    public List<EnrolledUserDto> retrieveAll(String username) {
//    public List<EnrolledUser> findAll() {
//        return dao.findAll();
        return dao.retrieveUsernameAsDTO(username);
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

    public void edit(EnrolledUser enrolledUser) {
        dao.saveAndFlush(enrolledUser);
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
