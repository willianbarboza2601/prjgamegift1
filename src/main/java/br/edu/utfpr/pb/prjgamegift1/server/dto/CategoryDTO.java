package br.edu.utfpr.pb.prjgamegift1.server.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO {
    private Long id;

    @NotNull
    @Size(min = 2, max = 40)
    private String name;
}
