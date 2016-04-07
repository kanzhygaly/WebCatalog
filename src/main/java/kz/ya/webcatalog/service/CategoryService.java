/**
 * <b>Category Service</b>
 * The service which is used for fetching categories and add, edit, delete operations
 */
package kz.ya.webcatalog.service;

import java.util.List;
import kz.ya.webcatalog.entity.Category;

/**
 *
 * @author YERLAN
 */
public interface CategoryService {
    
    /**
     * This method is used for searching categories by id
     * 
     * @param id
     * @return 
     */
    Category findCategory(Long id);
     
    /**
     * This method is used for saving information about category
     * 
     * @param category 
     */
    void saveCategory(Category category);
     
    /**
     * This method is used for updating information about category
     * 
     * @param category 
     */
    void updateCategory(Category category);
     
    /**
     * This method is used for deleting information about category
     * 
     * @param id 
     */
    void deleteCategory(Long id);
 
    /**
     * This method fetches all categories
     * 
     * @return 
     */
    List<Category> findAllCategories(); 
}
