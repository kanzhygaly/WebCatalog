package kz.ya.webcatalog.service;

import java.util.List;
import kz.ya.webcatalog.dao.CategoryDAO;
import kz.ya.webcatalog.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author YERLAN
 */
@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public Category findCategory(Long id) {
        return categoryDAO.find(id);
    }

    @Override
    public void saveCategory(Category category) {
        categoryDAO.persist(category);
    }

    @Override
    public void updateCategory(Category category) {
        /**
         * Since the method is running with Transaction, No need to call
         * hibernate update explicitly. Just fetch the entity from db and update
         * it with proper values within transaction. It will be updated in db
         * once transaction ends.
         */
        Category entity = categoryDAO.find(category.getId());
        if (entity != null) {
            entity.setName(category.getName());
            entity.setDescription(category.getDescription());
            entity.setProducts(category.getProducts());
        }
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryDAO.find(id);
        if (category != null) {
            categoryDAO.delete(category);
        }
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryDAO.findAll();
    }
}
