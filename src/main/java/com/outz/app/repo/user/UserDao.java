package com.outz.app.repo.user;

import java.util.Collection;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.outz.app.entity.account.User;

@Transactional
public interface UserDao extends CrudRepository<User, String>{
	
	User findByUsername(String username);
	
	User findById(String id);
	
	Collection<User> findAll();
	
	@Query(value="SELECT c FROM User c WHERE id=?1")
	User findByUID(String uid);
}
