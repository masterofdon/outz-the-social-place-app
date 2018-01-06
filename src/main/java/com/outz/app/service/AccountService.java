package com.outz.app.service;

import org.springframework.stereotype.Service;

import com.outz.app.entity.account.A1User;
import com.outz.app.entity.account.A2User;
import com.outz.app.entity.account.Account;
import com.outz.app.entity.account.AccountHolder;
import com.outz.app.entity.account.U1User;
import com.outz.app.entity.account.U2User;
import com.outz.app.entity.account.User;
import com.outz.app.repo.user.A1UserDao;
import com.outz.app.repo.user.A2UserDao;
import com.outz.app.repo.user.AccountDao;
import com.outz.app.repo.user.U1UserDao;
import com.outz.app.repo.user.U2UserDao;
import com.outz.app.util.OutzRandom;
import com.outz.app.util.OutzTime;

@Service
public class AccountService {

	AccountDao accountDao;
	A1UserDao a1UserDao;
	A2UserDao a2UserDao;
	U1UserDao u1UserDao;
	U2UserDao u2UserDao;
	
	public AccountService(AccountDao accountDao, A1UserDao a1UserDao, A2UserDao a2UserDao, U1UserDao u1UserDao,
			U2UserDao u2UserDao) {
		super();
		this.accountDao = accountDao;
		this.a1UserDao = a1UserDao;
		this.a2UserDao = a2UserDao;
		this.u1UserDao = u1UserDao;
		this.u2UserDao = u2UserDao;
	}

	/*
	 * Takes incoming account object as parameter and sets required fields.
	 * Account object is received from client side.
	 * TODO: Check if AuthorizedUser is granted for the operation. 
	 */
	public void registerAccount(Account account) throws ClassCastException {
		account.setId(OutzRandom.getRandomAlphaNumeric());
		AccountHolder holder = account.getAccountHolder();
		User user = (User) holder;
		user.setCreationDate(OutzTime.stampTimeNow());
		user.setState(User.State.REGISTERED);
		if(user instanceof U1User){			
			registerU1User(user);			
		}else if(user instanceof U2User){
			registerU2User(user);
		}else if(user instanceof A1User){
			registerA1User(user);
		}else if(user instanceof A2User){
			registerA2User(user);
		}
		accountDao.save(account);
		
	}
	
	/*
	 *  Takes incoming account object to modify existing.
	 *  This is admin-only operation
	 *  TODO: Check if AuthorizedUser is granted for the operation.
	 */
	public void modifyAccount(Account account) {
		Account prevAccount = accountDao.findById(account.getId());
		if(account.getAccountHolder() != null) {
			prevAccount.setAccountHolder(account.getAccountHolder());
		}
		if(account.getDeviceid() != null) {
			prevAccount.setDeviceid(account.getDeviceid());
		}
		accountDao.save(prevAccount);
	}
	/*
	 *  Updating account will be less used. Only option for enduser to change in account
	 *  will be device id.
	 *  TODO: Check if AuthorizedUser is granted for the operation.
	 */
	public void updateAccount(Account account) {
		Account prevAccount = accountDao.findById(account.getId());
		if(account.getDeviceid() != null) {
			prevAccount.setDeviceid(account.getDeviceid());
		}
		accountDao.save(prevAccount);
	}
	
	private void registerA1User(User user) {
		a1UserDao.save(user);
	}
	
	private void registerA2User(User user) {
		a2UserDao.save(user);
	}
	
	private void registerU1User(User user) {
		u1UserDao.save(user);
	}
	
	private void registerU2User(User user) {
		u2UserDao.save(user);
	}
	
	
	
}
