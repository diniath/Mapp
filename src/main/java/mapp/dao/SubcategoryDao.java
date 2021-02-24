package mapp.dao;

import mapp.entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcategoryDao extends JpaRepository<Subcategory, Integer> {

}
