/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
