/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
