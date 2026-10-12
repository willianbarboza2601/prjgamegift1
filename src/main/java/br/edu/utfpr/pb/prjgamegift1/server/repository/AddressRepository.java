package br.edu.utfpr.pb.prjgamegift1.server.repository;

import br.edu.utfpr.pb.prjgamegift1.server.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAllByUserEmail(String email);
}
