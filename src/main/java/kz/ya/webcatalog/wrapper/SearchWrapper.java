/**
 * Wrapper class for storing category id
 * This wrapper is used in product list filter
 */
package kz.ya.webcatalog.wrapper;

import java.io.Serializable;

/**
 *
 * @author YERLAN
 */
public class SearchWrapper implements Serializable {
    
    private Long category;

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }
}
