package com.outz.app.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.outz.app.entity.account.A1User;
import com.outz.app.entity.account.A2User;
import com.outz.app.entity.account.Account;
import com.outz.app.entity.account.U1User;
import com.outz.app.entity.account.U2User;
import com.outz.app.entity.account.User;
import com.outz.app.repo.user.A1UserDao;
import com.outz.app.repo.user.A2UserDao;
import com.outz.app.repo.user.AccountDao;
import com.outz.app.repo.user.U1UserDao;
import com.outz.app.repo.user.U2UserDao;

@RunWith(SpringRunner.class)
public class AccountServiceTest {

	AccountService accountService;
	
	@MockBean
	AccountDao accountDao;
	
	@MockBean
	U1UserDao u1UserDao;
	
	@MockBean
	U2UserDao u2UserDao;
	
	@MockBean
	A1UserDao a1UserDao;
	
	@MockBean
	A2UserDao a2UserDao;
	
	@Before
	public void init() {
		accountService = new AccountService(accountDao,a1UserDao,a2UserDao,u1UserDao,u2UserDao);
	}
	
	@Test
	public void shouldReturnSuccessAfterA1UserRegistration() {
		Account nAccount = new Account();
		A1User nUser = new A1User();
		nUser.setId("111");
		nUser.setUsername("erdem");
		nUser.setPassword("erdem");
		nAccount.setAccountHolder(nUser);
		Mockito.when(a1UserDao.save(nUser)).thenReturn(nUser);
		Mockito.when(accountDao.save(nAccount)).thenReturn(nAccount);
		accountService.registerAccount(nAccount);
		assertThat(nAccount.getId()).isNotNull();
		assertThat(nAccount.getAccountHolder().getState()).isEqualTo(User.State.REGISTERED);
		assertThat(nAccount.getAccountHolder()).isInstanceOf(A1User.class);
	}
	
	@Test
	public void shouldReturnSuccessAfterA2UserRegistration() {
		Account nAccount = new Account();
		A2User nUser = new A2User();
		nUser.setId("111");
		nUser.setUsername("erdem");
		nUser.setPassword("erdem");
		nAccount.setAccountHolder(nUser);
		Mockito.when(a2UserDao.save(nUser)).thenReturn(nUser);
		Mockito.when(accountDao.save(nAccount)).thenReturn(nAccount);
		accountService.registerAccount(nAccount);
		assertThat(nAccount.getId()).isNotNull();
		assertThat(nAccount.getAccountHolder().getState()).isEqualTo(User.State.REGISTERED);
		assertThat(nAccount.getAccountHolder()).isInstanceOf(A2User.class);
	}
	
	@Test
	public void shouldReturnSuccessAfterU1UserRegistration() {
		Account nAccount = new Account();
		U1User nUser = new U1User();
		nUser.setId("111");
		nUser.setUsername("erdem");
		nAccount.setAccountHolder(nUser);
		Mockito.when(u1UserDao.save(nUser)).thenReturn(nUser);
		Mockito.when(accountDao.save(nAccount)).thenReturn(nAccount);
		accountService.registerAccount(nAccount);
		assertThat(nAccount.getId()).isNotNull();
		assertThat(nAccount.getAccountHolder().getState()).isEqualTo(User.State.REGISTERED);
		assertThat(nAccount.getAccountHolder()).isInstanceOf(U1User.class);
	}
	
	@Test
	public void shouldReturnSuccessAfterU2UserRegistration() {
		Account nAccount = new Account();
		U2User nUser = new U2User();
		nUser.setId("111");
		nUser.setUsername("erdem");
		nUser.setPassword("erdem");
		nAccount.setAccountHolder(nUser);
		Mockito.when(u2UserDao.save(nUser)).thenReturn(nUser);
		Mockito.when(accountDao.save(nAccount)).thenReturn(nAccount);
		accountService.registerAccount(nAccount);
		assertThat(nAccount.getId()).isNotNull();
		assertThat(nAccount.getAccountHolder().getState()).isEqualTo(User.State.REGISTERED);
		assertThat(nAccount.getAccountHolder()).isInstanceOf(U2User.class);
	}
	
	
}
