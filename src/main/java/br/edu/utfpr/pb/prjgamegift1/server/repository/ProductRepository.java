package br.edu.utfpr.pb.prjgamegift1.server.repository;

import br.edu.utfpr.pb.prjgamegift1.server.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
