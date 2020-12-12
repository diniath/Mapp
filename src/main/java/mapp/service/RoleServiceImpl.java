
package mapp.service;

import java.util.List;
import java.util.Optional;
import mapp.dao.RoleDao;
import mapp.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@Transactional
public class RoleServiceImpl{
    
    @Autowired
    private RoleDao dao;
    
    public List<Role> findAll() {
        return dao.findAll();
    }
    
    public Role create(Role role) {
        Role comp = dao.save(role);
        return comp;
    }
    
    public void edit(Role role) {
        dao.saveAndFlush(role);
    }

    public void delete(int id) {
        dao.deleteById(id);
    }

    public Optional<Role> findById(int id) {
        Optional<Role> role = dao.findById(id);
        return role;
    }
    
//    public Role findRoleByAddress(@PathVariable(value = "address") String address){
//        return dao.findByAddress(address);
//    }
}
