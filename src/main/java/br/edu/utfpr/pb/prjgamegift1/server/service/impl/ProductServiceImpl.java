package br.edu.utfpr.pb.prjgamegift1.server.service.impl;

import br.edu.utfpr.pb.prjgamegift1.server.model.Product;
import br.edu.utfpr.pb.prjgamegift1.server.repository.ProductRepository;
import br.edu.utfpr.pb.prjgamegift1.server.service.IProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll(){
        return this.productRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(Long id){
        return this.productRepository.findById(id).orElse(null);
    }
}
