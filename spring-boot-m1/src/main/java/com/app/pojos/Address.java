package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//addrLine1, addrLine2,city,state country,zipCode
@Entity
@Table(name="address_tbl")
public class Address extends BaseEntity{
	@Column(name="address_line1",length = 50)
	private String addressLine1;
	@Column(name="address_line2",length = 50)
	private String addressLine2;
	@Column(length = 20)
	private String  city;
	@Column(length = 20)
	private String state;
	@Column(length = 20)
	private String country;
	@Column(name="zip_code",length = 20)
	private String zipCode;
	//additional mapping property for uni dir one-to-one : User  1<----1 Address
	@OneToOne(fetch = FetchType.LAZY) //mandatory : def fetch type : EAGER /LAZY
	@JoinColumn(name="user_id",nullable = false)//optional
	@MapsId //to tell hibernate to use shared PK approach
	private User owner;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String addressLine1, String addressLine2, String city, String state, String country,
			String zipCode) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
	//IMPORTANT project tip : DO NOT add any asso based property in toString

	@Override
	public String toString() {
		return "Address [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", zipCode=" + zipCode + "]";
	}
	
	
	

}
