/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.ya.webcatalog.dao;

import java.util.List;
import kz.ya.webcatalog.entity.Category;
import kz.ya.webcatalog.entity.Product;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author YERLAN
 */
@Repository
public class ProductDAOImpl extends AbstractDAO<Long, Product> implements ProductDAO {

    @Override
    public Product find(Long id) {
        return getByKey(id);
    }

    @Override
    public List<Product> findAll() {
        return createEntityCriteria().addOrder(Order.asc("name")).list();
    }

    @Override
    public List<Product> findAllByCategory(Category category) {
        return createEntityCriteria().add(Restrictions.eq("category", category)).addOrder(Order.asc("name")).list();
    }
}
