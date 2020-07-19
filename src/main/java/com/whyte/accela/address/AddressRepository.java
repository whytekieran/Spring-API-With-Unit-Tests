package com.whyte.accela.address;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository <Address, Integer> {

	public List<Address> findByPersonId(int personId);
}
