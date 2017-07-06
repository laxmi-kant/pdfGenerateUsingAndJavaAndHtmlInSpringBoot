package com.base.sqlQuotedIdentifiers;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="GlobalQuoting")
public class GlobalQuoting {
@Id
private Long id;
private String name;
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
