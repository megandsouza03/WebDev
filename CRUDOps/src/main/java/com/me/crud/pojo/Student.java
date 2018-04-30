package com.me.crud.pojo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="STUDENT")
@PrimaryKeyJoinColumn(name="UserID")
public class Student  extends User{
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="StudentID")
//	private int  nuID;
	
	@Column(name="fName")
	private String fName;
	
	@Column(name = "lName")
	private String lName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "courseName")
	private String courseName;
	
	@Column(name = "carAvail")
	private String carAvail;
	
	@Column(name ="mobile")
	private long mobile;
	
	@Column(name = "linkedinUrl")
	private String linkedinUrl;
	
	@Column(name="skypeID")
	private String skypeID;
	
	@ManyToOne
    private CoopFaculty coopFaculty;
	
	@OneToMany(mappedBy = "student")
	private Collection<Applications> applicationList;
	
	public Collection<Applications> getApplicationList() {
		return applicationList;
	}

	public void setApplicationList(Collection<Applications> applicationList) {
		this.applicationList = applicationList;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCarAvail() {
		return carAvail;
	}

	public void setCarAvail(String carAvail) {
		this.carAvail = carAvail;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getLinkedinUrl() {
		return linkedinUrl;
	}

	public void setLinkedinUrl(String linkedinUrl) {
		this.linkedinUrl = linkedinUrl;
	}

	public String getSkypeID() {
		return skypeID;
	}

	public void setSkypeID(String skypeID) {
		this.skypeID = skypeID;
	}

	public CoopFaculty getCoopFaculty() {
		return coopFaculty;
	}

	public void setCoopFaculty(CoopFaculty coopFaculty) {
		this.coopFaculty = coopFaculty;
	}

	
	
	
}
