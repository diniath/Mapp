package mapp;

import mapp.dao.EnrolledUserDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = EnrolledUserDao.class)
public class SherlockApplication {

    
    public static void main(String[] args) {
        SpringApplication.run(SherlockApplication.class, args);
    }

}
