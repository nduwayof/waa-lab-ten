package edu.mum.lab.ten.service;

import edu.mum.lab.ten.domain.Address;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * The interface Address service.
 */
public interface IAddressService {

    /**
     * Save address.
     *
     * @param address the address
     *
     * @return the address
     */
    Address save(@NotNull final Address address);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(@NotNull final Long id);

    /**
     * Find by id address.
     *
     * @param id the id
     *
     * @return the address
     */
    Address findById(@NotNull final Long id);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Address> findAll();

}
