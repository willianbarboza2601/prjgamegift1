package br.edu.utfpr.pb.prjgamegift1.server.service.impl;

import br.edu.utfpr.pb.prjgamegift1.server.model.Category;
import br.edu.utfpr.pb.prjgamegift1.server.repository.CategoryRepository;
import br.edu.utfpr.pb.prjgamegift1.server.service.ICategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //Essa anotação faz o Spring reconhecer a classe como um componente necessário para a aplicação
public class CategoryServiceImpl implements ICategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> findAll(){
        return this.categoryRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Category findById(Long id){
        return this.categoryRepository.findById(id).orElse(null);
    }
}
