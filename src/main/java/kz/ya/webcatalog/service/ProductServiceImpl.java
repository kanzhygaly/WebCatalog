/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.ya.webcatalog.service;

import java.util.List;
import kz.ya.webcatalog.dao.ProductDAO;
import kz.ya.webcatalog.entity.Category;
import kz.ya.webcatalog.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author YERLAN
 */
@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    public Product findProduct(Long id) {
        return productDAO.find(id);
    }

    @Override
    public void saveProduct(Product product) {
        productDAO.persist(product);
    }

    @Override
    public void updateProduct(Product product) {
        Product entity = productDAO.find(product.getId());
        if (entity != null) {
            entity.setName(product.getName());
            entity.setDescription(product.getDescription());
            entity.setProducer(product.getProducer());
            entity.setPrice(product.getPrice());
            entity.setDateCreate(product.getDateCreate());
            entity.setImage(product.getImage());
            entity.setCategory(product.getCategory());
        }
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productDAO.find(id);
        if (product != null) {
            productDAO.delete(product);
        }
    }

    @Override
    public List<Product> findAllProducts() {
        return productDAO.findAll();
    }
    
    @Override
    public List<Product> findAllProductsByCategory(Long categoryId) {
        return productDAO.findAllByCategoryId(categoryId);
    }
}
