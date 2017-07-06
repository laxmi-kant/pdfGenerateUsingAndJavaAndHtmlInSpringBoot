package com.base.sqlQuotedIdentifiers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="JpaQuoting")
public class JPAquoting {
	@Id
    private Long id;

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

	@Column(name = "\"name\"")
    private String name;

    @Column(name = "\"number\"")
    private String number;

    //Getters and setters are omitted for brevity

}
