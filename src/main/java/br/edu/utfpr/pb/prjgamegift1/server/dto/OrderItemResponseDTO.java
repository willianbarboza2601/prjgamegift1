package br.edu.utfpr.pb.prjgamegift1.server.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemResponseDTO {
    @NotNull
    private Long productId;

    @NotNull
    private String productName;

    private Integer quantity;

    @NotNull
    private BigDecimal price;
}
