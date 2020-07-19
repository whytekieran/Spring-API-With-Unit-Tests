package com.whyte.accela.address;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.whyte.accela.person.Person;
import com.whyte.accela.person.PersonService;

@RestController
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	PersonService personService;
	
	@RequestMapping("/people/{personId}/address")
	public List<Address> getAllAddresses(@PathVariable int personId) {
		return addressService.getAllAddresses(personId);
	}
	
	@RequestMapping("/people/{personId}/address/{addressId}")
	public Optional<Address> getAddress(@PathVariable int addressId) {
		return addressService.getAddress(addressId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/people/{personId}/address")
	public void addAddress(@RequestBody Address address, @PathVariable int personId) {
		Optional<Person> p = personService.getPerson(personId);
		Person pp = p.get();
		address.setPerson(pp);
		addressService.addAddress(address);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/people/{personId}/address")
	public void updateAddress(@RequestBody Address address, @PathVariable int personId) {
		address.setPerson(new Person(personId, "", ""));
		addressService.updateAddress(address);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/people/{personIdId}/address/{addressId}")
	public void deleteAddress(@PathVariable int addressId) {
		addressService.deleteAddress(addressId);
	}
}
