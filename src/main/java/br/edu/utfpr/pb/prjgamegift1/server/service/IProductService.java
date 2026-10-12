package br.edu.utfpr.pb.prjgamegift1.server.service;


import br.edu.utfpr.pb.prjgamegift1.server.model.Product;

import java.util.List;

public interface IProductService{
    List<Product> findAll();
    Product findById(Long id);
}
