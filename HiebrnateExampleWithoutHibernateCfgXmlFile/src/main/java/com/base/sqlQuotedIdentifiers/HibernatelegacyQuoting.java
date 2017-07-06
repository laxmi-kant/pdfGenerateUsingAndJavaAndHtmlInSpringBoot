package com.base.sqlQuotedIdentifiers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "HibernatelegacyQuoting")
public class HibernatelegacyQuoting {

	    @Id
	    private Long id;

	    @Column(name = "`name`")
	    private String name;

	    @Column(name = "`number`")
	    private String number;

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

		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}


	
}
