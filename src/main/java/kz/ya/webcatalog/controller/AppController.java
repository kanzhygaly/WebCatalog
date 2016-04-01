/*
 * https://habrahabr.ru/post/248541/
 */
package kz.ya.webcatalog.controller;

import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import kz.ya.webcatalog.entity.Category;
import kz.ya.webcatalog.entity.Product;
import kz.ya.webcatalog.service.CategoryService;
import kz.ya.webcatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author YERLAN
 */
@Controller
@RequestMapping("/")
@SessionAttributes("categories")
public class AppController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    MessageSource messageSource;
    
    /**
     * This method will list all existing categories.
     * 
     * @param model
     * @return 
     */
    @RequestMapping(value = {"/", "/products"}, method = RequestMethod.GET)
    public String listProducts(ModelMap model) {

        List<Product> products = productService.findAllProducts();
        model.addAttribute("products", products);
        return "productlist";
    }

    /**
     * This method will provide the medium to add a new user.
     * 
     * @param model
     * @return 
     */
    @RequestMapping(value = {"/products/add"}, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("edit", false);
        return "productForm";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * saving user in database. It also validates the user input
     * 
     * @param product
     * @param result
     * @param model
     * @return 
     */
    @RequestMapping(value = {"/products/add"}, method = RequestMethod.POST)
    public String saveUser(@Valid Product product, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "productForm";
        }
        product.setDateCreate(new Date());
        productService.saveProduct(product);
        model.addAttribute("success", "Product " + product.getName() + " created successfully");
        return "productSuccess";
    }

    /**
     * This method will provide the medium to update an existing user.
     * 
     * @param id
     * @param model
     * @return 
     */
    @RequestMapping(value = {"/products/edit/{id}"}, method = RequestMethod.GET)
    public String editUser(@PathVariable Long id, ModelMap model) {
        Product product = productService.findProduct(id);
        model.addAttribute("product", product);
        model.addAttribute("edit", true);
        return "productForm";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * updating user in database. It also validates the user input
     * 
     * @param product
     * @param result
     * @param id
     * @param model
     * @return 
     */
    @RequestMapping(value = {"/products/edit/{id}"}, method = RequestMethod.POST)
    public String updateUser(@Valid Product product, BindingResult result, ModelMap model, @PathVariable Long id) {
        if (result.hasErrors()) {
            return "productForm";
        }
        productService.updateProduct(product);
        model.addAttribute("success", "Product " + product.getName() + " updated successfully");
        return "productSuccess";
    }

    /**
     * This method will delete an user by it's SSOID value.
     * 
     * @param id
     * @return 
     */
    @RequestMapping(value = {"/products/delete/{id}"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
    
    /**
     * This method will provide UserProfile list to views
     * 
     * @return 
     */
    @ModelAttribute("categories")
    public List<Category> initializeCategories() {
        return categoryService.findAllCategories();
    }
}
