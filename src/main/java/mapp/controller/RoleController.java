package mapp.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import mapp.entity.Role;
import mapp.exceptions.ResourceNotFoundException;
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

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleServiceImpl service;

    @GetMapping
    public List<Role> getRoles() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable(value = "id") Integer roleId) throws Exception {
        Optional<Role> optionalRole = service.findById(roleId);
        return optionalRole.orElseThrow(() -> new ResourceNotFoundException("Role not exists with id:" + roleId));
    }

    @PostMapping
    public Role createRole(@Valid @RequestBody Role role) {
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
        optionalRole.orElseThrow(() -> new Exception("Role not exists with id:" + roleId));
        newRoleDetails.setId(roleId);
        service.edit(newRoleDetails);
    }

}
