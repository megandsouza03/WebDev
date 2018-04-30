package com.me.crud.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.me.crud.exception.CoopException;
import com.me.crud.exception.StudentException;
import com.me.crud.pojo.Applications;
import com.me.crud.pojo.CoopFaculty;
import com.me.crud.pojo.Job;
import com.me.crud.pojo.Student;


public class CoopDAO extends DAO {
    public CoopFaculty register(CoopFaculty c) throws CoopException {
        try {
            begin();
            System.out.println("inside DAO");
            
            CoopFaculty coop = new CoopFaculty();
           
            coop.setfName(c.getfName());
            coop.setlName(c.getlName());
            coop.setEmail(c.getEmail());
            System.out.println("I came to Coop DAO"+c.getRole());
            coop.setRole(c.getRole());
            coop.setUserName(c.getUserName());
            coop.setPassword(c.getPassword());
            coop.setMobile(c.getMobile());
 
            getSession().save(coop);
            commit();
            close();
            return coop;

        } catch (HibernateException e) {
            rollback();
            throw new CoopException("Exception while creating user: " + e.getMessage());
        }
    }
    
    
	public CoopFaculty get(int userID){
        try {
            begin();
            Query q = getSession().createQuery("from CoopFaculty where id = :userid");
            q.setInteger("userid", userID);
            CoopFaculty cp = (CoopFaculty) q.uniqueResult();
            close();
            return cp;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
            return null;
	}
	
	public ArrayList<Student> getUnAssignedStudents(){
        try {
            begin();
            
            Criteria crit = getSession().createCriteria(Student.class);
            crit.add(Restrictions.isNull("coopFaculty"));
            ArrayList<Student> stu = (ArrayList<Student>) crit.list();
            close();
            
            return stu;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
            return null;
	}
	
	public ArrayList<Student> getmyStudents(int id){
        try {
            begin();
            
            Query q = getSession().createQuery("FROM Student where coopFaculty = :id");
            q.setInteger("id", id);
            ArrayList<Student> list = (ArrayList<Student>) q.list();
            close();
            return list;

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
            return null;
	}
	public ArrayList<CoopFaculty> getAll(){
        try {
            begin();
            
            Query q = getSession().createQuery("FROM CoopFaculty");
           // q.setInteger("id", id);
            ArrayList<CoopFaculty> list = (ArrayList<CoopFaculty>) q.list();
            close();
            return list;

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
            return null;
	}
	
	public void selectStudents(String[] s , int cpID ) {
		for(int i =0;i<s.length;i++) {
		try {
			begin();
			
			Query q1 = getSession().createQuery("from CoopFaculty where id = :userid");
            q1.setInteger("userid", cpID);
            CoopFaculty coop = (CoopFaculty) q1.uniqueResult();
            
            
			int sId = Integer.parseInt(s[i]);
			String hql = "UPDATE Student set coopFaculty = :coop "  + 
		             "WHERE id = :id";
			Query q2 = getSession().createQuery(hql);
			q2.setParameter("coop", coop);
			q2.setParameter("id", sId);
			int result = q2.executeUpdate();
			close();
			}
			
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	}
	
	public ArrayList<Applications> getMyStuApp(ArrayList<Student> s){
		ArrayList<Applications> applist = new ArrayList<Applications>();
		
		for (Student st : s) {
			Query q = getSession().createQuery("FROM Applications where student = :sy");
			q.setParameter("sy", st);
			ArrayList<Applications> a = (ArrayList<Applications>) q.list();
			 for(Applications i : a) {
					applist.add(i);
				}
		}
		
		return applist;
		
	}
    
}
