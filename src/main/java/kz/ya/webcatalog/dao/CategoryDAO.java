/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
