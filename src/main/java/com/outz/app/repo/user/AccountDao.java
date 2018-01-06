package com.outz.app.repo.user;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.outz.app.entity.account.Account;

public interface AccountDao extends JpaRepository<Account, String>{

	List<Account> findAll();
	
	Account findById(String id);
	
	@Query(value="SELECT c FROM Account c WHERE user_id=?1")
	Account findByUser(String userid);
	
	@Query(value="SELECT c FROM Account c, User d WHERE d.username=?1 AND c.user.id=d.id")
	Account findByUsername(String username);
}