/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapp.controller;

import java.util.List;
import java.util.Optional;
import mapp.entity.Role;
import mapp.service.RoleServiceImpl;
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
 * @role Hello Java !
 */
@RestController//@RestController = @Controller + @ResponseBody
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleServiceImpl service;

    
    @GetMapping
    public List<Role> getRoles() {
        return service.findAll();
    }

    @GetMapping("/{myvariable}")
    public Role getRoleById(@PathVariable(value = "myvariable") Integer roleId) throws Exception {
        Optional<Role> optionalRole = service.findById(roleId);
        return optionalRole.orElseThrow(() -> new Exception("Role not exists with id:" + roleId));
        //return optionalRole.get();
    }

    @PostMapping
    public Role createRole(@RequestBody Role role) {
        return service.create(role);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRoleById(@PathVariable(value = "id") Integer roleId) {
        service.delete(roleId);
        return ResponseEntity.ok("Role deleted successfully, ID:" + roleId);
    }

    @PutMapping("/{id}")
    public void updateRole(@PathVariable(value = "id") Integer roleId,
            @RequestBody Role newRoleDetails) throws Exception {
        Optional<Role> optionalRole = service.findById(roleId);
        Role roleToUpdate = optionalRole.orElseThrow(() -> new Exception("Role not exists with id:" + roleId));
        
//        roleToUpdate.setDay(newRoleDetails.getDay());
        service.edit(newRoleDetails);
    }
    
//    @GetMapping("/search/{address}")
//    public Role getRoleByAddress(@PathVariable(value = "address") String address){
//        return service.findRoleByAddress(address);
//    }

}
