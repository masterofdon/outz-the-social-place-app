package com.outz.app.repo.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.outz.app.entity.account.Account;
import com.outz.app.entity.account.AccountHolder;
import com.outz.app.entity.account.U1User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountDaoTest {

	@Autowired
	TestEntityManager testEntityManager;
	
	@Autowired
	AccountDao accountDao;
	
	@Test
	public void shouldReturnEmptyFindByUserId() {
		Account account = accountDao.findByUser("1");
		assertThat(account).isNull();
	}
	
	@Test
	public void shouldReturnAccountByUserId() {
		Account nAccount = new Account();
		U1User nUser = new U1User();
		nUser.setId("1");
		testEntityManager.persist(nUser);
		nAccount.setId("111");
		nAccount.setAccountHolder(nUser);
		nAccount.setDeviceid("dads");
		testEntityManager.persistAndFlush(nAccount);
		Account account = accountDao.findByUser("1");
		AccountHolder holder = account.getAccountHolder();
		assertThat(holder).isInstanceOf(U1User.class);
		U1User user = (U1User) holder;
		assertThat(user.getId()).isEqualTo("1");
	}
	
	@Test
	public void shouldReturnAccountByUsername() {
		Account nAccount = new Account();
		U1User nUser = new U1User();
		nUser.setId("1");
		nUser.setUsername("erdem");
		testEntityManager.persist(nUser);
		nAccount.setId("111");
		nAccount.setAccountHolder(nUser);
		nAccount.setDeviceid("dads");
		testEntityManager.persistAndFlush(nAccount);
		Account account = accountDao.findByUsername("erdem");
		AccountHolder holder = account.getAccountHolder();
		assertThat(holder).isInstanceOf(U1User.class);
		U1User user = (U1User) holder;
		assertThat(user.getUsername()).isEqualTo("erdem");
	}
	
}
