package com.me.crud.pojo;



import java.util.Collection;
import java.util.Collections;

import javax.persistence.*;

@Entity
@Table(name="EMPLOYER")
public class Employer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="companyName")
	private String companyName;
	
	@Column(name="fName")
	private String fName;
	
	@Column(name="lName")
	private String lName;
	
	 @OneToMany(mappedBy = "employer")
	private Collection<Job> jobList;
	
	//private ArrayList<Applications> applicationList;
	
}
