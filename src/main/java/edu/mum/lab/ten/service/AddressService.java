package edu.mum.lab.ten.service;

import edu.mum.lab.ten.domain.Address;
import edu.mum.lab.ten.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * The type Address service.
 *
 * @author nduwayofabrice
 * @version 1.0
 */
@Service
public class AddressService implements IAddressService{

    private IAddressRepository addressRepository;

    /**
     * Instantiates a new Address service.
     *
     * @param addressRepository the address repository
     */
    @Autowired
    public AddressService(IAddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    @Override
    public Address save(@NotNull final Address address) {
        return this.addressRepository.save(address);
    }

    @Override
    public void delete(@NotNull final Long id) {
        this.addressRepository.deleteById(id);
    }

    @Override
    public Address findById(@NotNull Long id) {
        return this.addressRepository.getOne(id);
    }

    @Override
    public List<Address> findAll() {
        return this.addressRepository.findAll();
    }
}
