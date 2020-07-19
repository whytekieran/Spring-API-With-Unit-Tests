package com.whyte.accela.address;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
	
	@Autowired
	AddressRepository addressRepository;
	
	public List<Address> getAllAddresses(int personId){
		List<Address> addresses = new ArrayList<>();
		addressRepository.findByPersonId(personId).forEach(addresses::add);
		//System.out.println(addresses.get(0).getState());
		return addresses;
	}
	
	public Optional<Address> getAddress(int id) {
		return addressRepository.findById(id);
	}
	
	public void addAddress(Address address) {
		addressRepository.save(address);
	}
	
	public void updateAddress(Address course) {
		//Save works for update too. JPA is clever enough to know if its and update or new record based on primary key
		addressRepository.save(course);
	}
	
	public void deleteAddress(int id) {
		addressRepository.deleteById(id);
	}
}
