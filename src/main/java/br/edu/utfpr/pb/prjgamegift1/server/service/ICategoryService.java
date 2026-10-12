package br.edu.utfpr.pb.prjgamegift1.server.service;

import br.edu.utfpr.pb.prjgamegift1.server.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(Long id);
}
