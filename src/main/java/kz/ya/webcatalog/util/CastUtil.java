/*
 * Utility class for casting entities into wrappers
 */
package kz.ya.webcatalog.util;

import kz.ya.webcatalog.entity.Product;
import kz.ya.webcatalog.wrapper.ProductWrapper;

/**
 *
 * @author YERLAN
 */
public class CastUtil {
    
    /**
     * This method casts Product entity into wrapper class
     * 
     * @param product
     * @return 
     */
    public static ProductWrapper castProductToWrapper(Product product) {
        ProductWrapper wrapper = new ProductWrapper();
        wrapper.setId(product.getId());
        wrapper.setName(product.getName());
        wrapper.setDescription(product.getDescription());
        wrapper.setProducer(product.getProducer());
        wrapper.setPrice(product.getPrice());
        wrapper.setCategory(product.getCategory().getId());
        return wrapper;
    }
}
