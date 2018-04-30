package com.me.crud.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;

import com.me.crud.exception.ApplicationException;
import com.me.crud.exception.JobException;
import com.me.crud.pojo.Applications;
import com.me.crud.pojo.Job;
import com.me.crud.pojo.Student;

public class ApplicationDAO extends DAO {

	public Applications createJob(Applications a) throws JobException {
        try {
            begin();
            System.out.println("inside Job DAO");
            
            Applications app = new Applications();
          //  app.setCoopFaculty(a.getCoopFaculty());
            app.setStudent(a.getStudent());
            app.setCurrentUniversity(a.getCurrentUniversity());
            app.setDateSubmitted(a.getDateSubmitted());
            app.setJob(a.getJob());
            app.setTechnicalSkills(a.getTechnicalSkills());
            app.setWorkExperience(a.getWorkExperience());
            getSession().save(app);
            commit();
            close();
            return app;

        } catch (HibernateException e) {
            rollback();
            throw new JobException("Exception while creating user: " + e.getMessage());
        }
    }
	
	public ArrayList<Applications> getMyApplications(Student s) throws ApplicationException {
		try {
			begin();
			Query q = getSession().createQuery("From Applications where  student = :s ");
			q.setParameter("s", s);
			ArrayList<Applications> apList = (ArrayList<Applications>) q.list();
			close();
			return apList;
		}catch (HibernateException e) {
            rollback();
            throw new ApplicationException("Exception while creating user: " + e.getMessage());
        }
		finally {
			close();
		}
		
	}
	
	
	public Applications getMyApplications(int ID) throws ApplicationException {
		try {
			begin();
			Query q = getSession().createQuery("From Applications where  appID = :id ");
			q.setParameter("id", ID);
			Applications app =  (Applications) q.uniqueResult();
			close();
			return app;
		}catch (HibernateException e) {
            rollback();
            throw new ApplicationException("Exception while creating user: " + e.getMessage());
        }
		finally {
			close();
		}
		
	}
	
	public void delete(String[] n) throws ApplicationException {
		for(int i= 0 ; i<n.length ; i++) {
			int sel = Integer.parseInt(n[i]);
			try{
				begin();
			
			Query q = getSession().createQuery("from Applications where appId = :selID");
			q.setInteger("selID", sel);
			Applications selJob = (Applications) q.uniqueResult();
			//System.out.println(selJob.getCompanyName());
			
			getSession().delete(selJob);
			commit();
			close();
			
			}
			catch (HibernateException e) {
	            rollback();
	            throw new ApplicationException("Exception while creating user: " + e.getMessage());
	        }
			finally {
				close();
			}
		}
	}
	
	public ArrayList<Applications> getByJob() throws ApplicationException{
		try {
			begin();
			Query q = getSession().createQuery("From Applications as a ORDER BY a.job ");
			//q.setParameter("s", s);
			ArrayList<Applications> apList = (ArrayList<Applications>) q.list();
			close();
			return apList;
		}catch (HibernateException e) {
            rollback();
            throw new ApplicationException("Exception while creating user: " + e.getMessage());
        }
		finally {
			close();
		}
		
	}
	
	
	
}
