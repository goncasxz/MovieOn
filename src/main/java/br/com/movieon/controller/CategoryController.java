package br.com.movieon.controller;

import br.com.movieon.entity.Category;
import br.com.movieon.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/movieon/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }
}
