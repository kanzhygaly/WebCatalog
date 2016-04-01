/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
            Hibernate.initialize(category.getProducts());
        }
        return category;
    }

    @Override
    public List<Category> findAll() {
        return createEntityCriteria().addOrder(Order.asc("name")).list();
    }
}
