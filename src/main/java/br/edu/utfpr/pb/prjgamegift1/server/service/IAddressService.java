package br.edu.utfpr.pb.prjgamegift1.server.service;

import br.edu.utfpr.pb.prjgamegift1.server.model.Address;

import java.util.List;

public interface IAddressService {
    Address findById(Long id);
    Address save(Address address, String email);
}
