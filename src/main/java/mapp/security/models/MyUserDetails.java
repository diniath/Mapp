package mapp.security.models;

import java.util.ArrayList;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import mapp.dao.RoleDao;
import mapp.entity.EnrolledUser;
import mapp.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class MyUserDetails implements UserDetails {

    @Autowired
    RoleDao roleDao;
    
    
    private String userName;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;

       
    public MyUserDetails(EnrolledUser user) {
        this.userName = user.getUsername();
        this.password = user.getPassword();
        this.active = true;
        this.authorities = getAuthorities(user);
    }

    public List<GrantedAuthority> getAuthorities(EnrolledUser enrolledUser) {
        List<Role> roloi = enrolledUser.getRoleList();
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roloi) { 
            authorities.add(new SimpleGrantedAuthority(role.getAdmission()));
        }
        return authorities;
    }
    
    
    @Override
    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
