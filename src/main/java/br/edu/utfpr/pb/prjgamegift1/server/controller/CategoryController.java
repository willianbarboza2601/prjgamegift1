package br.edu.utfpr.pb.prjgamegift1.server.controller;

import br.edu.utfpr.pb.prjgamegift1.server.dto.CategoryDTO;
import br.edu.utfpr.pb.prjgamegift1.server.mapper.CategoryMapper;
import br.edu.utfpr.pb.prjgamegift1.server.model.Category;
import br.edu.utfpr.pb.prjgamegift1.server.service.ICategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("categories")
public class CategoryController {
    private final ICategoryService categoryService;
    private final CategoryMapper categoryMapper;

    public CategoryController(ICategoryService categoryService, CategoryMapper categoryMapper){
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll(){
        return ResponseEntity.ok(
                categoryService.findAll()
                        .stream()
                        .map(categoryMapper::toDTO)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id){
        Category category = categoryService.findById(id);
        if(category != null){
            return ResponseEntity.status(HttpStatus.OK).body(
                    categoryMapper.toDTO(category)
            );
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
