package br.edu.utfpr.pb.prjgamegift1.server.controller;

import br.edu.utfpr.pb.prjgamegift1.server.dto.ProductDTO;
import br.edu.utfpr.pb.prjgamegift1.server.mapper.ProductMapper;
import br.edu.utfpr.pb.prjgamegift1.server.model.Product;
import br.edu.utfpr.pb.prjgamegift1.server.service.IProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("products")
public class ProductController {
    private final IProductService productService;
    private final ProductMapper productMapper;

    public ProductController(IProductService productService, ProductMapper productMapper){
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll(){
        return ResponseEntity.ok(
                productService.findAll()
                        .stream()
                        .map(productMapper::toDto)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id){
        Product product = productService.findById(id);

        if(product != null){
            return ResponseEntity.status(HttpStatus.OK).body(
                    productMapper.toDto(product)
            );
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
