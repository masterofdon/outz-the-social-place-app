package com.outz.app.repo.base;

import java.util.Collection;

import org.apache.tomcat.jni.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressDao extends CrudRepository<Address, String>{

	Collection<Address> findAll();
	
	Address findAddressById(String addressid);
	
}

