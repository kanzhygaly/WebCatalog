/**
 * https://github.com/pkainulainen/spring-data-jpa-examples/tree/master/integration-testing
 */
package kz.ya.webcatalog.service;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import java.util.List;
import kz.ya.webcatalog.entity.Category;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author YERLAN
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//@ContextConfiguration(locations = {"classpath:beans.xml"})
@ContextConfiguration(locations = {"/WEB-INF/spring-servlet.xml"})
//@ContextConfiguration(classes = {PersistenceContext.class})
//@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
//        TransactionalTestExecutionListener.class,
//        DbUnitTestExecutionListener.class})
@DatabaseSetup("fakeDB.xml")
public class CategoryServiceTest {
    
    @Autowired
    CategoryService instance;
    
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
        
        Long id = 101L;
        
        Category category = new Category("myCategory", "some desc");
        category.setId(id);
        instance.saveCategory(category);
        
        Category result = instance.findCategory(id);
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
        
//        List<Category> expResult = null;
        List<Category> result = instance.findAllCategories();
        System.out.println(result.size());
//        assertEquals(expResult, result);
    }
}
