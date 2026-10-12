package br.edu.utfpr.pb.prjgamegift1.server.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDTO {
    @NotNull
    @Size(min = 5, max = 100)
    private String street;

    @NotNull
    @Size(max = 50)
    private String complement;

    @NotNull
    @Size(max = 9)
    private String cep;
}

