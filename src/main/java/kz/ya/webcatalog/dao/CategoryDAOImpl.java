package kz.ya.webcatalog.dao;

import java.util.List;
import kz.ya.webcatalog.entity.Category;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

/**
 *
 * @author YERLAN
 */
@Repository
public class CategoryDAOImpl extends AbstractDAO<Long, Category> implements CategoryDAO {

    @Override
    public Category find(Long id) {
        Category category = getByKey(id);
        if (category != null) {
            // initialize proxy collection
            Hibernate.initialize(category.getProducts());
        }
        return category;
    }

    @Override
    public List<Category> findAll() {
        return createEntityCriteria().addOrder(Order.asc("name")).list();
    }
}
