package mapp.dao;

import java.util.List;
import mapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

    public List<Product> findBySubcategoryId(Integer Id);

    public List<Product> findByProfileContainingIgnoreCase(String profile);

}
