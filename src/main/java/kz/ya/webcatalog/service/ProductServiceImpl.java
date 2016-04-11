package kz.ya.webcatalog.service;

import java.util.Date;
import java.util.List;
import kz.ya.webcatalog.dao.ProductDAO;
import kz.ya.webcatalog.entity.Product;
import kz.ya.webcatalog.wrapper.ProductWrapper;
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
    @Autowired
    private CategoryService categoryService;

    @Override
    public Product findProduct(Long id) {
        return productDAO.find(id);
    }

    @Override
    public Long saveProduct(ProductWrapper wrapper, byte[] image) {
        Product product = new Product();
        product.setName(wrapper.getName());
        product.setDescription(wrapper.getDescription());
        product.setProducer(wrapper.getProducer());
        product.setPrice(wrapper.getPrice());
        product.setDateCreate(new Date());
        if (image != null) {
            product.setImage(image);
        }
        product.setCategory(categoryService.findCategory(wrapper.getCategory()));
        productDAO.persist(product);
        
        return product.getId();
    }

    @Override
    public void updateProduct(ProductWrapper wrapper, byte[] image) {
        Product entity = productDAO.find(wrapper.getId());
        if (entity != null) {
            entity.setName(wrapper.getName());
            entity.setDescription(wrapper.getDescription());
            entity.setProducer(wrapper.getProducer());
            entity.setPrice(wrapper.getPrice());
            if (image != null) {
                entity.setImage(image);
            }
            entity.setCategory(categoryService.findCategory(wrapper.getCategory()));
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
