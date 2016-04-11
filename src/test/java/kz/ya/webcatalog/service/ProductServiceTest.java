/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.ya.webcatalog.service;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import java.math.BigDecimal;
import java.util.List;
import kz.ya.webcatalog.entity.Category;
import kz.ya.webcatalog.entity.Product;
import kz.ya.webcatalog.util.CastUtil;
import kz.ya.webcatalog.wrapper.ProductWrapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

/**
 *
 * @author YERLAN
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"test-spring-config.xml"})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
@DatabaseSetup("sampleData.xml")
public class ProductServiceTest {
    
    @Autowired
    private ProductService instance;
    @Autowired
    private CategoryService categoryService;
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findProduct method, of class ProductService.
     */
    @Test
    public void testFindProduct() {
        System.out.println("findProduct");
        
        Long id = 11L;
        String expResultName = "product1";
        
        Product result = instance.findProduct(id);
        assertNotNull(result);
        assertEquals(expResultName, result.getName());
    }

    /**
     * Test of saveProduct method, of class ProductService.
     */
    @Test
    public void testSaveProduct() {
        System.out.println("saveProduct");
        
        Category category = categoryService.findCategory(1L);
        
        ProductWrapper wrapper = new ProductWrapper();
        wrapper.setName("myProduct");
        wrapper.setDescription("myDesc");
        wrapper.setProducer("myProducer");
        wrapper.setPrice(new BigDecimal("1000"));
        wrapper.setCategory(category.getId());
        
        byte[] image = "image data".getBytes();
        
        Long id = instance.saveProduct(wrapper, image);
        
        Product result = instance.findProduct(id);
        assertNotNull(result);
        assertEquals(wrapper.getName(), result.getName());
    }

    /**
     * Test of updateProduct method, of class ProductService.
     */
    @Test
    public void testUpdateProduct() {
        System.out.println("updateProduct");
        
        Long id = 11L;
        String expResultName = "updateProduct";
        
        Product product = instance.findProduct(id);
        ProductWrapper wrapper = CastUtil.castProductToWrapper(product);
        wrapper.setName(expResultName);
        byte[] image = null;
        instance.updateProduct(wrapper, image);
        
        Product result = instance.findProduct(id);
        assertEquals(expResultName, result.getName());
    }

    /**
     * Test of deleteProduct method, of class ProductService.
     */
    @Test
    public void testDeleteProduct() {
        System.out.println("deleteProduct");
        
        Long id = 13L;
        instance.deleteProduct(id);
        
        Product result = instance.findProduct(id);
        assertNull(result);
    }

    /**
     * Test of findAllProducts method, of class ProductService.
     */
    @Test
    public void testFindAllProducts() {
        System.out.println("findAllProducts");
        
        int expResult = 3;
        List<Product> result = instance.findAllProducts();
        assertEquals(expResult, result.size());
    }

    /**
     * Test of findAllProductsByCategory method, of class ProductService.
     */
    @Test
    public void testFindAllProductsByCategory() {
        System.out.println("findAllProductsByCategory");
        
        Category category = categoryService.findCategory(2L);
        
        int expResult = 1;
        List<Product> result = instance.findAllProductsByCategory(category.getId());
        assertEquals(expResult, result.size());
    }
}
