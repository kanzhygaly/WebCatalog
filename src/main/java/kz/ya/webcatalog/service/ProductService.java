/**
 * <b>Product Service</b>
 * The service which is used for fetching products and add, edit, delete operations
 */
package kz.ya.webcatalog.service;

import java.util.List;
import kz.ya.webcatalog.entity.Product;
import kz.ya.webcatalog.wrapper.ProductWrapper;

/**
 *
 * @author YERLAN
 */
public interface ProductService {
    
    /**
     * This method is used for searching products by id
     * 
     * @param id
     * @return 
     */
    Product findProduct(Long id);
     
    /**
     * This method is used for saving information about product
     * 
     * @param wrapper
     * @param image 
     * @return Product id
     */
    Long saveProduct(ProductWrapper wrapper, byte[] image);
    
    /**
     * This method is used for updating information about product
     * 
     * @param wrapper
     * @param image 
     */
    void updateProduct(ProductWrapper wrapper, byte[] image);
     
    /**
     * This method is used for deleting information about product
     * 
     * @param id 
     */
    void deleteProduct(Long id);
    
    /**
     * This method fetches all categories
     * 
     * @return 
     */
    List<Product> findAllProducts();
    
    /**
     * This method is used for searching products by category
     * 
     * @param categoryId
     * @return 
     */
    List<Product> findAllProductsByCategory(Long categoryId);
}
