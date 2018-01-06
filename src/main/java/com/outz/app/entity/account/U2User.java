package com.outz.app.entity.account;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
/**
* This class represents U2 Type Users in the system. Refer to <a href="http://www.developers.outz.com/docs/U2Users"> 
*
* U2User is a subclass of User.
*
* @author  Ahmet Erdem Ekin
* @see     User
* @since   0.1
*/
@Entity
@Table(name="outz_u2user")
public class U2User extends User{

	private static final long serialVersionUID = -7475540929818933892L;
	
	private String password;
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
