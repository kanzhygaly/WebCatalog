package kz.ya.webcatalog.dao;

import java.util.List;
import kz.ya.webcatalog.entity.Category;

/**
 *
 * @author YERLAN
 */
public interface CategoryDAO {
    
    Category find(Long id);
     
    List<Category> findAll();
    
    void persist(Category category);
     
    void delete(Category category);
}
