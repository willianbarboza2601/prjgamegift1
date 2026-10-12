package br.edu.utfpr.pb.prjgamegift1.server.controller;

import br.edu.utfpr.pb.prjgamegift1.server.dto.AddressDTO;
import br.edu.utfpr.pb.prjgamegift1.server.mapper.AddressMapper;
import br.edu.utfpr.pb.prjgamegift1.server.model.Address;
import br.edu.utfpr.pb.prjgamegift1.server.service.IAddressService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/addresses")
@RestController
public class AddressController {
    private final IAddressService addressService;
    private final AddressMapper addressMapper;

    public AddressController(IAddressService addressService,
                             AddressMapper addressMapper){
        this.addressService = addressService;
        this.addressMapper = addressMapper;
    }

    @PostMapping
    public ResponseEntity<AddressDTO> saveAddress(@RequestBody @Valid AddressDTO addressDTO, Authentication authentication){
        String email = authentication.getName();

        Address address = addressService.save(addressMapper.toEntity(addressDTO), email);

        return ResponseEntity.status(HttpStatus.CREATED).body(addressMapper.toDto(address));
    }

    @GetMapping("{id}")
    public ResponseEntity<AddressDTO> findById(@PathVariable @Valid Long id){
        Address address = addressService.findById(id);

        if(address != null){
            return ResponseEntity.status(HttpStatus.OK).body(
                    addressMapper.toDto(address)
            );
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
