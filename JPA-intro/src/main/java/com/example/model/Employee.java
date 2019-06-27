package com.example.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;

@Entity
@Table(name ="Empployees_temp")
public class Employee {
	
	@Id
	@Column(name="emp_id")
	private int id;
	@Column(name="emp_name")
	private String name;
	private double salary;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private LocalDate dob;
	private LocalDateTime joinDate;
	@Lob
	private String profile;
	
//	@Embedded
//	private Address address;
	
	@ElementCollection
	@CollectionTable(name="EMP_ADDRESS", joinColumns= {@JoinColumn(name="emp_id")})
	private List<Address> addresses = new ArrayList<>();
	
//	@Embedded
//	@AttributeOverrides({
//		@AttributeOverride(name="street",column=@Column(name="o_street")),
//		@AttributeOverride(name="city",column=@Column(name="o_city")),
//		@AttributeOverride(name="country",column=@Column(name="o_country"))
//	})
//	private Address officeAddress;
	
//	public Address getOfficeAddress() {
//	return officeAddress;
//}
//
//public void setOfficeAddress(Address officeAddress) {
//	this.officeAddress = officeAddress;
//}
	
//	public Address getAddress() {
//		return address;
//	}
//	public void setAddress(Address address) {
//		this.address = address;
//	}
	public double getSalary() {
		return salary;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public LocalDateTime getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(LocalDateTime joinDate) {
		this.joinDate = joinDate;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
