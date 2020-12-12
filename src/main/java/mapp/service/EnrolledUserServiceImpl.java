
package mapp.service;

import java.util.List;
import java.util.Optional;
import mapp.dao.EnrolledUserDao;
import mapp.entity.EnrolledUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class EnrolledUserServiceImpl{
    
    @Autowired
    private EnrolledUserDao dao;
    
    public List<EnrolledUser> findAll() {
        return dao.findAll();
    }
    
    public EnrolledUser create(EnrolledUser enrolledUser) {
        EnrolledUser comp = dao.save(enrolledUser);
        return comp;
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
