package br.edu.utfpr.pb.prjgamegift1.server.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponseDTO {
    @NotNull
    private Long id;

    @NotNull
    private LocalDateTime date;

    @NotNull
    private Long addressId;

    @NotEmpty
    private List<OrderItemResponseDTO> items;

    @NotNull
    private BigDecimal totalPrice;
}
