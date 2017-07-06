package com.base.FormulaAnnotation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Filter;


@Entity(name = "Client")
public  class Client {

    @Id
    private Long id;

    private String name;

//    @Where( clause = "account_type = 'DEBIT'")
//    @OneToMany(mappedBy = "client")
//    private List<Account> debitAccounts = new ArrayList<>( );
//
//    @Where( clause = "account_type = 'CREDIT'")
//    @OneToMany(mappedBy = "client")
//    private List<Account> creditAccounts = new ArrayList<>( );
    @OneToMany(mappedBy = "client")
    @Filter(name="activeAccount", condition="active = :active")
    private List<AccountFilter> accounts = new ArrayList<>( );
    
	public List<AccountFilter> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountFilter> accounts) {
		this.accounts = accounts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
//
//	public List<Account> getDebitAccounts() {
//		return debitAccounts;
//	}
//
//	public void setDebitAccounts(List<Account> debitAccounts) {
//		this.debitAccounts = debitAccounts;
//	}
//
//	public List<Account> getCreditAccounts() {
//		return creditAccounts;
//	}
//
//	public void setCreditAccounts(List<Account> creditAccounts) {
//		this.creditAccounts = creditAccounts;
//	}

    //Getters and setters omitted for brevity

}

