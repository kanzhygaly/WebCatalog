package kz.ya.webcatalog.service;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import java.util.List;
import kz.ya.webcatalog.entity.Category;
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
public class CategoryServiceTest {
    
    @Autowired
    private CategoryService instance;
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findCategory method, of class CategoryService.
     */
    @Test
    public void testFindCategory() {
        System.out.println("findCategory");
        
        Long id = 1L;
        String expResultName = "category1";
        
        Category result = instance.findCategory(id);
        assertNotNull(result);
        assertEquals(expResultName, result.getName());
    }

    /**
     * Test of saveCategory method, of class CategoryService.
     */
    @Test
    public void testSaveCategory() {
        System.out.println("saveCategory");
        
        Category category = new Category("myCategory", "some desc");
        instance.saveCategory(category);

        Category result = instance.findCategory(category.getId());
        assertNotNull(result);
        assertEquals(category, result);
    }

    /**
     * Test of updateCategory method, of class CategoryService.
     */
    @Test
    public void testUpdateCategory() {
        System.out.println("updateCategory");
        
        Long id = 1L;
        String expResultName = "updateCategory";
        
        Category category = instance.findCategory(id);
        category.setName(expResultName);
        category.setProducts(null);
        instance.updateCategory(category);
        
        Category result = instance.findCategory(id);
        assertEquals(expResultName, result.getName());
    }

    /**
     * Test of deleteCategory method, of class CategoryService.
     */
    @Test
    public void testDeleteCategory() {
        System.out.println("deleteCategory");
        
        Long id = 3L;
        instance.deleteCategory(id);
        
        Category result = instance.findCategory(id);
        assertNull(result);
    }

    /**
     * Test of findAllCategories method, of class CategoryService.
     */
    @Test
    public void testFindAllCategories() {
        System.out.println("findAllCategories");
        
        int expResult = 3;
        List<Category> result = instance.findAllCategories();
        assertEquals(expResult, result.size());
    }
}
