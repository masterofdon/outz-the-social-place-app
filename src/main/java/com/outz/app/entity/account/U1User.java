package com.outz.app.entity.account;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="outz_u1user")
public class U1User extends User {
	
	private static final long serialVersionUID = 2920665543467748278L;
	
	@Transient
	@JsonProperty
	private final String AUTHORITY_PREFIX = "AUTHORITY_";
	
	@Transient
	@JsonProperty
	private final String[] DEFAULT_AUTHORITIES = {
			"ORDER",
			"HELP",
			"CHECK",
			"SOCIAL1"
	};
	
	@Transient
	@JsonProperty
	private final String[] DEFAULT_ROLES = {
		"U1USER"	
	};
	
	@Transient
	@JsonProperty
	private ArrayList<String> authorities = new ArrayList<String>();
	
	@Transient
	@JsonProperty
	private ArrayList<String> roles = new ArrayList<String>();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        for(String authority : authorities){
        	list.add(new SimpleGrantedAuthority(AUTHORITY_PREFIX + authority));
        }
        return list;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return super.getUsername();
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
	
	public void addRole(String role){
		if(role != null && !role.equals("")){
			this.roles.add(role);
		}
	}
	
	public void removeRole(String role){
		if(role != null && !role.equals("") && this.roles.contains(role))
			this.roles.remove(role);
	}
	
	public List<String> getRoles(){
		return this.roles;
	}
	
	public void addAuthority(String authority){
		if(authority != null && !authority.equals("")){
			this.authorities.add(authority);
		}
	}
	
}