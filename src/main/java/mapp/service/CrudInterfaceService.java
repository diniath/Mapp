
package mapp.service;

import java.util.List;

public interface CrudInterfaceService<E> {
    
    List<E> findAll();
    
    E create(E e);
    
    void edit(E e);
    
    String delete(int id);
    
    E findById(int id);
    
}
