package br.edu.utfpr.pb.prjgamegift1.server.dto;

import br.edu.utfpr.pb.prjgamegift1.server.model.Order;
import br.edu.utfpr.pb.prjgamegift1.server.model.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
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
public class OrderItemRequestDTO {
    @NotNull
    private Long productId;

    @NotNull
    @Min(1)
    private Integer quantity;
}
