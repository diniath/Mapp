//
//package mapp.service;
//
//import java.util.List;
//import mapp.dao.CompanyDao;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.jboss.logging.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import mapp.dao.CrudInterfaceDao;
//
//public abstract class SuperService<E> implements CrudInterfaceService<E> {
//    
//    @Autowired
//    private SessionFactory sessionFactory;
//    Logger logger = Logger.getLogger(SuperService.class);
//
//    Session getSession() {
//        return sessionFactory.getCurrentSession();
//    }
//    
//    @Autowired
//    private CompanyDao adao;
//    
//    @Override
//    public List<E> findAll() {
//        return adao.findAll();
//    }
//    
//    @Override
//    public int create(E e) {
//        int id = (Integer)adao.add(e);
//        return id;
//    }
//    
//    @Override
//    public void edit(E e) {
//        adao.update(e);
//    }
//
//    @Override
//    public String delete(int id) {
//        return adao.remove(id);
//    }
//
//    @Override
//    public E findById(int id) {
//        E e = adao.findById(id);
//        return e;
//    }
//       
//}
