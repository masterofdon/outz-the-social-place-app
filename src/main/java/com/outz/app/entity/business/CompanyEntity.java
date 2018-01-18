package com.outz.app.entity.business;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.tomcat.jni.Address;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.outz.app.entity.account.Account;
import com.outz.app.entity.place.PlaceTable;
import com.outz.app.entity.place.PlaceTableCategory;

@Entity
@Table(name="outz_companyentity")
public class CompanyEntity {

	@Id
	@GenericGenerator(
			name = "outz-random-15",
	        strategy = "com.outz.webm.utils.StringSequenceIdentifier"
    )
	@GeneratedValue(generator = "outz-random-15")
	private String id;
	
	private String companyentityname;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "company")
	private Company ownercompany;
	
	@ManyToMany
	@JoinTable(
			name = "outz_company_accounts",
			joinColumns = @JoinColumn(
					name = "companyentity_id",
					referencedColumnName = "id")
			,
			inverseJoinColumns = @JoinColumn(
					name = "account_id",
					referencedColumnName = "id"
					)
			)

	@JsonBackReference
	private Set<Account> contact;
	
	@ManyToMany
	@JoinTable(
			name = "outz_companyentity_colleagues",
			joinColumns = @JoinColumn(name = "companyentity_id" , referencedColumnName = "id")
			,
			inverseJoinColumns = @JoinColumn(name = "colleague_id" , referencedColumnName = "id")
			)
	private Set<Account> colleagues;
	
	@Cascade(value = { org.hibernate.annotations.CascadeType.ALL })
	@OneToOne
	private Address address;
	
	@OneToMany(mappedBy = "ownercompanyentity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<PlaceTable> tables;
	
	@OneToMany(mappedBy = "ownercompanyentity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<PlaceTableCategory> categories;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompanyentityname() {
		return companyentityname;
	}

	public void setCompanyentityname(String companyentityname) {
		this.companyentityname = companyentityname;
	}

	public Company getOwnercompany() {
		return ownercompany;
	}

	public void setOwnercompany(Company ownercompany) {
		this.ownercompany = ownercompany;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<PlaceTable> getTables() {
		return tables;
	}

	public void setTables(Set<PlaceTable> tables) {
		this.tables = tables;
	}

	public Set<PlaceTableCategory> getCategories() {
		return categories;
	}

	public void setCategories(Set<PlaceTableCategory> categories) {
		this.categories = categories;
	}

	public Set<Account> getContact() {
		return contact;
	}

	public void setContact(Set<Account> contact) {
		this.contact = contact;
	}

	public Set<Account> getColleagues() {
		return colleagues;
	}

	public void setColleagues(Set<Account> colleagues) {
		this.colleagues = colleagues;
	}
}
