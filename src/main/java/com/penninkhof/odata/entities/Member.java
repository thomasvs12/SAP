package com.penninkhof.odata.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name="members",
		indexes={@Index(name="lastName", columnList="lastName", unique=false)})
public class Member {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int id;
    private String firstName;
    private String lastName;

    protected Member() {}

    public Member(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Member[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
