package kz.ya.webcatalog.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import kz.ya.webcatalog.entity.Category;
import kz.ya.webcatalog.entity.Product;
import kz.ya.webcatalog.service.CategoryService;
import kz.ya.webcatalog.service.ProductService;
import kz.ya.webcatalog.util.ImageUtil;
import kz.ya.webcatalog.wrapper.ProductWrapper;
import kz.ya.webcatalog.wrapper.SearchWrapper;
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
     * This method will list all existing products.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = {"/", "/products"}, method = RequestMethod.GET)
    public String listProducts(ModelMap model) {

        List<Product> products = productService.findAllProducts();
        model.addAttribute("products", products);
        model.addAttribute("searchWrapper", new SearchWrapper());
        return "productList";
    }

    /**
     * This method will list products filtered by category.
     *
     * @param searchWrapper
     * @param model
     * @return
     */
    @RequestMapping(value = {"/products/search"}, method = RequestMethod.GET)
    public String searchProducts(SearchWrapper searchWrapper, ModelMap model) {
        List<Product> products;
        if (searchWrapper.getCategory() == null) {
            products = productService.findAllProducts();
        } else {
            products = productService.findAllProductsByCategory(searchWrapper.getCategory());
        }
        model.addAttribute("products", products);
        return "productList";
    }

    /**
     * This method will provide the medium to add a new product.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = {"/products/add"}, method = RequestMethod.GET)
    public String newProduct(ModelMap model) {
        model.addAttribute("productWrapper", new ProductWrapper());
        model.addAttribute("edit", false);
        return "productForm";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * saving product in database. It also validates the user input
     *
     * @param productWrapper
     * @param result
     * @param model
     * @return
     */
    @RequestMapping(value = {"/products/add"}, method = RequestMethod.POST)
    public String saveProduct(@Valid ProductWrapper productWrapper, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "productForm";
        }
        Product product = new Product();

        if (!productWrapper.getImage().isEmpty()) {
            if (!productWrapper.getImage().getContentType().equals("image/jpeg") && !productWrapper.getImage().getContentType().equals("image/png")) {
                result.rejectValue("image", "NotCompatible.productBean.image");
                return "productForm";
            }
            try {
                String ext = productWrapper.getImage().getContentType().equals("image/png") ? "png" : "jpg";
                byte[] scaledImage = ImageUtil.scale(productWrapper.getImage().getBytes(), 100, 100, ext);
                product.setImage(scaledImage);
            } catch (IOException ex) {
                result.rejectValue("image", "error", ex.getMessage());
                return "productForm";
            }
        }

        product.setCategory(categoryService.findCategory(productWrapper.getCategory()));

        product.setName(productWrapper.getName());
        product.setDescription(productWrapper.getDescription());
        product.setProducer(productWrapper.getProducer());
        product.setPrice(productWrapper.getPrice());
        product.setDateCreate(new Date());

        productService.saveProduct(product);
        model.addAttribute("success", "Product " + product.getName() + " created successfully");
        return "productSuccess";
    }

    /**
     * This method will provide the medium to update an existing product.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = {"/products/edit/{id}"}, method = RequestMethod.GET)
    public String editProduct(@PathVariable Long id, ModelMap model) {
        Product product = productService.findProduct(id);
        model.addAttribute("product", product);
        model.addAttribute("edit", true);
        return "productForm";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * updating product in database. It also validates the user input
     *
     * @param product
     * @param result
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = {"/products/edit/{id}"}, method = RequestMethod.POST)
    public String updateProduct(@Valid Product product, BindingResult result, ModelMap model, @PathVariable Long id) {
        if (result.hasErrors()) {
            return "productForm";
        }
        productService.updateProduct(product);
        model.addAttribute("success", "Product " + product.getName() + " updated successfully");
        return "productSuccess";
    }

    /**
     * This method will delete a product by it's id value.
     *
     * @param id
     * @return
     */
    @RequestMapping(value = {"/products/delete/{id}"}, method = RequestMethod.GET)
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }

    /**
     * This method will provide Category list to product form view
     *
     * @return
     */
    @ModelAttribute("categories")
    public List<Category> initializeCategories() {
        return categoryService.findAllCategories();
    }

    /**
     * This method will list all existing categories.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = {"/categories"}, method = RequestMethod.GET)
    public String listCategories(ModelMap model) {

        List<Category> categories = categoryService.findAllCategories();
        model.addAttribute("categories", categories);
        return "categoryList";
    }

    /**
     * This method will provide the medium to add a new category.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = {"/categories/add"}, method = RequestMethod.GET)
    public String newCategory(ModelMap model) {
        Category category = new Category();
        model.addAttribute("category", category);
        model.addAttribute("edit", false);
        return "categoryForm";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * saving category in database. It also validates the user input
     *
     * @param category
     * @param result
     * @param model
     * @return
     */
    @RequestMapping(value = {"/categories/add"}, method = RequestMethod.POST)
    public String saveCategory(@Valid Category category, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "categoryForm";
        }
        categoryService.saveCategory(category);
        model.addAttribute("success", "Category " + category.getName() + " created successfully");
        return "categorySuccess";
    }

    /**
     * This method will provide the medium to update an existing category.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = {"/categories/edit/{id}"}, method = RequestMethod.GET)
    public String editCategory(@PathVariable Long id, ModelMap model) {
        Category category = categoryService.findCategory(id);
        model.addAttribute("category", category);
        model.addAttribute("edit", true);
        return "categoryForm";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * updating category in database. It also validates the user input
     *
     * @param category
     * @param result
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = {"/categories/edit/{id}"}, method = RequestMethod.POST)
    public String updateCategory(@Valid Category category, BindingResult result, ModelMap model, @PathVariable Long id) {
        if (result.hasErrors()) {
            return "categoryForm";
        }
        categoryService.updateCategory(category);
        model.addAttribute("success", "Category " + category.getName() + " updated successfully");
        return "categorySuccess";
    }

    /**
     * This method will delete a category by it's id value.
     *
     * @param id
     * @return
     */
    @RequestMapping(value = {"/categories/delete/{id}"}, method = RequestMethod.GET)
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }
}
