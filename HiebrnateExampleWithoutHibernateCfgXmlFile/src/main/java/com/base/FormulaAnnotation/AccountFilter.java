package com.base.FormulaAnnotation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
@Entity(name="Account")
@FilterDef(name="activeAccount",parameters=@ParamDef(name="active",type="boolean"))
@Filter(name="activeAccount",condition="active:active")
public class AccountFilter {
	  @Id
	    private Long id;

	    @ManyToOne
	    private Client client;

	    @Column(name = "account_type")
	    @Enumerated(EnumType.STRING)
	    private AccountType type;

	    private Double amount;

	    private Double rate;

	    private boolean active;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Client getClient() {
			return client;
		}

		public void setClient(Client client) {
			this.client = client;
		}

		public AccountType getType() {
			return type;
		}

		public void setType(AccountType type) {
			this.type = type;
		}

		public Double getAmount() {
			return amount;
		}

		public void setAmount(Double amount) {
			this.amount = amount;
		}

		public Double getRate() {
			return rate;
		}

		public void setRate(Double rate) {
			this.rate = rate;
		}

		public boolean isActive() {
			return active;
		}

		public void setActive(boolean active) {
			this.active = active;
		}
	    
}
