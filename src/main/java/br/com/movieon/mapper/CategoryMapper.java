package br.com.movieon.mapper;

import br.com.movieon.controller.request.CategoryRequest;
import br.com.movieon.controller.response.CategoryResponse;
import br.com.movieon.entity.Category;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {
    public static Category toCategory(CategoryRequest categoryRequest) {
        return Category
                .builder()
                .name(categoryRequest.name())
                .build();
    }

    public static CategoryResponse toCategoryResponse(Category category) {
        return CategoryResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
