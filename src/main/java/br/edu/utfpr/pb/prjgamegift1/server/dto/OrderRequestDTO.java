package br.edu.utfpr.pb.prjgamegift1.server.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequestDTO {
    @NotNull
    private Long addressId;

    @NotEmpty
    @Valid
    private List<OrderItemRequestDTO> orderItems;
}
