package br.edu.utfpr.pb.prjgamegift1.server.service.impl;

import br.edu.utfpr.pb.prjgamegift1.server.model.Address;
import br.edu.utfpr.pb.prjgamegift1.server.model.User;
import br.edu.utfpr.pb.prjgamegift1.server.repository.AddressRepository;
import br.edu.utfpr.pb.prjgamegift1.server.repository.UserRepository;
import br.edu.utfpr.pb.prjgamegift1.server.service.IAddressService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService {
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    public AddressServiceImpl(AddressRepository addressRepository,
                              UserRepository userRepository){
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Address findById(Long id){
        return this.addressRepository.findById(id).orElse(null);
    }

    @Override
    public Address save(Address address, String email){
        User user = userRepository.findByEmail(email);
        address.setUser(user);
        return this.addressRepository.save(address);
    }

}
