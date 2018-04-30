package com.me.crud.pojo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="FACULTY")
@PrimaryKeyJoinColumn(name="UserID")
public class CoopFaculty extends User {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="FID")
//	private int nuID;
	
	@Column(name = "fName")
	private String fName;
	
	@Column(name="lName")
	private String lName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mobile")
	private long mobile;
	
	@OneToMany(mappedBy = "coopFaculty")
	private Collection<Student> student;
	
//	@OneToMany(mappedBy = "coopFaculty")
//	private Collection<Applications> applicationList;

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

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public Collection<Student> getStudent() {
		return student;
	}

	public void setStudent(Collection<Student> student) {
		this.student = student;
	}

//	public Collection<Applications> getApplicationList() {
//		return applicationList;
//	}
//
//	public void setApplicationList(Collection<Applications> applicationList) {
//		this.applicationList = applicationList;
//	}
	
	
	
	
}
