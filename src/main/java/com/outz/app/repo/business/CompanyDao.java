package com.outz.app.repo.business;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.outz.app.entity.business.Company;

public interface CompanyDao extends CrudRepository<Company, String> {

	Collection<Company> findAll();
	
	Company findById(String id);	
	
}