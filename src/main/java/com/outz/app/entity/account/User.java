package com.outz.app.entity.account;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonView;
import com.outz.app.entity.View;

@Entity
@Table(name="outz_user")
@Inheritance(strategy=InheritanceType.JOINED)
//@JsonDeserialize(using = UserDeserializer.class)
public abstract class User extends AccountHolder implements UserDetails, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonView(View.Base.class)
	protected String username;
	
	@JsonView(View.Base.class)
	protected String displayname;
	
	@JsonView(View.Base.class)
	private String type;
	
	public User() {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDisplayname() {
		return displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
