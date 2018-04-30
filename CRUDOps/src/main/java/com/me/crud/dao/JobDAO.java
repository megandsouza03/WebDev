package com.me.crud.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;

import com.me.crud.exception.CoopException;
import com.me.crud.exception.JobException;
import com.me.crud.pojo.CoopFaculty;
import com.me.crud.pojo.Job;


public class JobDAO extends DAO {

    public Job createJob(Job j) throws JobException {
        try {
            begin();
            System.out.println("inside Job DAO");
            
            Job job = new Job();
           
           job.setCity(j.getCity());
           job.setCompanyName(j.getCompanyName());
           job.setCountry(j.getCountry());
           job.setDescription(j.getDescription());
           job.setLength(j.getLength());
           job.setMaxWage(j.getMaxWage());
           job.setMinWage(j.getMinWage());
           job.setOpenings(j.getOpenings());
           job.setTitle(j.getTitle());
           job.setWageType(j.getWageType());
            getSession().save(job);
            commit();
            close();
            return job;

        } catch (HibernateException e) {
            rollback();
            throw new JobException("Exception while creating user: " + e.getMessage());
        }
    }
    
    
	public ArrayList<Job> get(){
        try {
            begin();
            Query q = getSession().createQuery("from Job");
            System.out.println("HEEEEEEEEEEEEEE");
            ArrayList<Job> jobs = (ArrayList<Job>) q.list();
            close();
            return jobs;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
            return null;
	}
	
	public void delete(String[] n) {
		for(int i= 0 ; i<n.length ; i++) {
			int sel = Integer.parseInt(n[i]);
			try{
				begin();
			
			Query q = getSession().createQuery("from Job where ID = :selID");
			q.setInteger("selID", sel);
			Job selJob = (Job) q.uniqueResult();
			System.out.println(selJob.getCompanyName());
			
			getSession().delete(selJob);
			commit();
			close();
			}
			catch(Exception e){
	            System.out.println(e.getMessage());
	        }
		}
	}
	
	public Job getUniqueJob(int i) {
		Query q = getSession().createQuery("FROM Job where ID = :id");
		q.setInteger("id", i);
		Job job = (Job) q.uniqueResult(); 
		return job;
	}
	
	
}
