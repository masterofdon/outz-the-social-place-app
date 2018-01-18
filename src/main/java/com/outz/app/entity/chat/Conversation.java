package com.outz.app.entity.chat;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.outz.app.entity.account.Account;

@Entity
@Table(name = "outz_messaging_conversations")
public class Conversation {

	@Id
	@GenericGenerator(
			name = "outz-random-15",
	        strategy = "com.outz.webm.utils.StringSequenceIdentifier"
    )
	@GeneratedValue(generator = "outz-random-15")
	private String id;
	
	@ManyToMany
	@JoinTable(name = "outz_messaging_conversation_parties" , 
				joinColumns = @JoinColumn(
						name = "conversation_id",
						referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(
						name = "account_id",
						referencedColumnName = "id"))
	private Set<Account> parties;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<Account> getParties() {
		return parties;
	}

	public void setParties(Set<Account> parties) {
		this.parties = parties;
	}
	
}
