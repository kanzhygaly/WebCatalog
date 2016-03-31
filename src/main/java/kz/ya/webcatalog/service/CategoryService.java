/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.ya.webcatalog.service;

import java.util.List;
import kz.ya.webcatalog.entity.Category;

/**
 *
 * @author YERLAN
 */
public interface CategoryService {
    
    Category findCategory(Long id);
     
    void saveCategory(Category category);
     
    void updateCategory(Category category);
     
    void deleteCategory(Category category);
 
    List<Category> findAllCategories(); 
}
