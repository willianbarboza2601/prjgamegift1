package br.edu.utfpr.pb.prjgamegift1.server.dto;

import br.edu.utfpr.pb.prjgamegift1.server.model.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private Long id;

    @NotNull
    @Size(min = 3, max = 100)
    private String name;

    @NotNull
    @Size(max = 500)
    private String description;

    @NotNull
    private BigDecimal price;

    @NotNull
    @Size(max = 2000)
    private String url_image;

    private CategoryDTO category;
}
