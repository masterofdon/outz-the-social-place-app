package com.outz.app.repo.user;

import java.util.Collection;
import org.springframework.data.jpa.repository.Query;

import com.outz.app.entity.account.User;

public interface U2UserDao extends UserDao{
	
	@Query(value="SELECT c FROM U2User c")
	Collection<User> findAll();

	@Query(value="SELECT c FROM U2User c WHERE state!='REMOVED'")
	Collection<User> findAllButStateREMOVED();
}
