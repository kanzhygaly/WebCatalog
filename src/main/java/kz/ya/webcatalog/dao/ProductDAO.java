package kz.ya.webcatalog.dao;

import java.util.List;
import kz.ya.webcatalog.entity.Product;

/**
 *
 * @author YERLAN
 */
public interface ProductDAO {
    
    Product find(Long id);
     
    List<Product> findAll();
    
    List<Product> findAllByCategoryId(Long categoryId);
    
    void persist(Product product);
     
    void delete(Product product);
}
