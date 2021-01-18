
package mapp.jwtsecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import mapp.dao.CompanyDao;
import mapp.dao.EnrolledUserDao;
import mapp.entity.Company;
import mapp.entity.EnrolledUser;
import mapp.jwtsecurity.models.MyCompanyDetails;
import mapp.jwtsecurity.models.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyCompanyDetailsService implements UserDetailsService {
    
    @Autowired
    CompanyDao repo;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Company> company = repo.findByUsername(username);

        company.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
        return company.map(MyCompanyDetails::new).get();
    }
    
}
