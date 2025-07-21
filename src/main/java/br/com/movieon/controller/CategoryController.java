package br.com.movieon.controller;

import br.com.movieon.controller.request.CategoryRequest;
import br.com.movieon.controller.response.CategoryResponse;
import br.com.movieon.entity.Category;
import br.com.movieon.mapper.CategoryMapper;
import br.com.movieon.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/movieon/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        return ResponseEntity.ok( categoryService.findAll()
                .stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList());
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> saveCategory(@RequestBody CategoryRequest request) {
        Category newCategory = CategoryMapper.toCategory(request);
        Category savedCategory = categoryService.saveCategory(newCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.toCategoryResponse(savedCategory));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getByCategoryId(@PathVariable Long id) {
        return categoryService.findById(id)
                .map(category -> ResponseEntity.ok(CategoryMapper.toCategoryResponse(category)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
