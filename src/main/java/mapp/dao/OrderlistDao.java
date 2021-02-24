package mapp.dao;

import mapp.entity.Orderlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderlistDao extends JpaRepository<Orderlist, Integer> {

}
