/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.ya.webcatalog.service;

import java.util.List;
import kz.ya.webcatalog.entity.Category;
import kz.ya.webcatalog.entity.Product;

/**
 *
 * @author YERLAN
 */
public interface ProductService {
    
    Product findProduct(Long id);
     
    void saveProduct(Product product);
    
    void updateProduct(Product product);
     
    void deleteProduct(Long id);
    
    List<Product> findAllProducts();
    
    List<Product> findAllProductsByCategory(Category category);
}
