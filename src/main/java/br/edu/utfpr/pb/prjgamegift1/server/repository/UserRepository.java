package br.edu.utfpr.pb.prjgamegift1.server.repository;

import br.edu.utfpr.pb.prjgamegift1.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
