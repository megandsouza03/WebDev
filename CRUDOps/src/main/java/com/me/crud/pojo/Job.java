package com.me.crud.pojo;

import java.util.Collection;

import javax.persistence.*;


@Entity
@Table(name="JOB")
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="JobID")
	private int ID;
	
	@Column(name="companyName")	
	private String companyName;
	
	@Column(name="title")
	private String title;
	
	@Column(name="openings")
	private int openings;
	
	@Column(name="length")
	private String length;
	
	@Column(name="city")
	private String city;
	
	@Column(name="country")
	private String country;
	
	@Column(name="description")
	private String description;
	
	@Column(name="wageType")
	private String wageType;
	
	@Column(name="minWage")
	private int minWage;
	
	@Column(name="maxWage")
	private int maxWage;
	


	
//	@ManyToOne
//	private Employer employer;
	
	@OneToMany(mappedBy="job")
	private Collection<Applications> applicationList;




	public int getID() {
		return ID;
	}




	public void setID(int iD) {
		ID = iD;
	}




	public String getCompanyName() {
		return companyName;
	}




	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public int getOpenings() {
		return openings;
	}




	public void setOpenings(int openings) {
		this.openings = openings;
	}




	public String getLength() {
		return length;
	}




	public void setLength(String length) {
		this.length = length;
	}




	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
	}




	public String getCountry() {
		return country;
	}




	public void setCountry(String country) {
		this.country = country;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public String getWageType() {
		return wageType;
	}




	public void setWageType(String wageType) {
		this.wageType = wageType;
	}




	public int getMinWage() {
		return minWage;
	}




	public void setMinWage(int minWage) {
		this.minWage = minWage;
	}




	public int getMaxWage() {
		return maxWage;
	}




	public void setMaxWage(int maxWage) {
		this.maxWage = maxWage;
	}




	public Collection<Applications> getApplicationList() {
		return applicationList;
	}




	public void setApplicationList(Collection<Applications> applicationList) {
		this.applicationList = applicationList;
	}
	
	
	
}
