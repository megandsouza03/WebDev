package com.me.crud.pojo;

import java.io.File;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="APPLICATIONS")
public class Applications {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int appId;
		
		@Column(name="dateSubmitted")
		private Date dateSubmitted;
		
		@ManyToOne
		private Student student;
		
		@ManyToOne
		private Job job;
		
		@Column(name="technicalSkills")
		private String technicalSkills;
		
		@Column(name="workExperience")
		private String workExperience;
		
		@Column(name="currentUniversity")
		private String currentUniversity;

		public int getAppId() {
			return appId;
		}

		public void setAppId(int appId) {
			this.appId = appId;
		}

		public Date getDateSubmitted() {
			return dateSubmitted;
		}

		public void setDateSubmitted(Date dateSubmitted) {
			this.dateSubmitted = dateSubmitted;
		}

	

		public Student getStudent() {
			return student;
		}

		public void setStudent(Student student) {
			this.student = student;
		}

		public Job getJob() {
			return job;
		}

		public void setJob(Job job) {
			this.job = job;
		}

		public String getTechnicalSkills() {
			return technicalSkills;
		}

		public void setTechnicalSkills(String technicalSkills) {
			this.technicalSkills = technicalSkills;
		}

		public String getWorkExperience() {
			return workExperience;
		}

		public void setWorkExperience(String workExperience) {
			this.workExperience = workExperience;
		}

		public String getCurrentUniversity() {
			return currentUniversity;
		}

		public void setCurrentUniversity(String currentUniversity) {
			this.currentUniversity = currentUniversity;
		}
		
		
		
		
		
		
		
		
}
