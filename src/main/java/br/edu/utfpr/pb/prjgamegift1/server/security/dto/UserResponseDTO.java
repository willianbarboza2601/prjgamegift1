package br.edu.utfpr.pb.prjgamegift1.server.security.dto;

import br.edu.utfpr.pb.prjgamegift1.server.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDTO {
    private String name;
    private String email;
    private Set<AuthorityResponseDTO> authorities;

    public UserResponseDTO(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.authorities = new HashSet<>();
        for (GrantedAuthority authority: user.getAuthorities()) {
            authorities.add( new AuthorityResponseDTO(authority.getAuthority()) );
        }
    }
}
