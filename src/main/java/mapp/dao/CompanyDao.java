
package mapp.dao;

import mapp.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompanyDao extends JpaRepository<Company, Integer>{

}
