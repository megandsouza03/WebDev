package com.me.crud.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;

import com.me.crud.exception.StudentException;
import com.me.crud.pojo.CoopFaculty;
import com.me.crud.pojo.Student;
import com.me.crud.pojo.User;



public class StudentDAO extends DAO {    
//    public User get(String username, String password) throws UserException {
//        try {
//            begin();
//            Query q = getSession().createQuery("from User where username = :username and password = :password");
//            q.setString("username", username);
//            q.setString("password", password);            
//             user = (User) q.uniqueResult();
//            commit();
//            return user;
//        } catch (HibernateException e) {
//            rollback();
//            throw new UserException("Could not get user " + username, e);
//        }
//    }
    
    public User get(int userId) throws StudentException {
        try {
            begin();
            Query q = getSession().createQuery("from User where personID= :personID");
            q.setInteger("personID", userId);        
            User user = (User) q.uniqueResult();
            commit();
            close();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new StudentException("Could not get user " + userId, e);
        }
    }
    
    public Student register(Student s) throws StudentException {
        try {
            begin();
            System.out.println("inside DAO");

//            User user = new U(u.getEmail().getEmailAddress());
//            User user = new User(u.getUsername(), u.getPassword());
//            user.setFirstName(u.getFirstName());
//            user.setLastName(u.getLastName());
//            user.setEmail(email);
//            email.setUser(user);
//            getSession().save(user);
//            commit();
//            return user;
            
            Student student = new Student();
            student.setfName(s.getfName());
            student.setlName(s.getlName());
            student.setEmail(s.getEmail());
            System.out.println("I came to USer DAO"+s.getRole());
            student.setRole(s.getRole());
            student.setUserName(s.getUserName());
            student.setPassword(s.getPassword());
            student.setCourseName(s.getCourseName());
            student.setCarAvail(s.getCarAvail());
            student.setMobile(s.getMobile());
            student.setLinkedinUrl(s.getLinkedinUrl());
            student.setSkypeID(s.getSkypeID());
            getSession().save(student);
            commit();
            close();
            return student;

        } catch (HibernateException e) {
            rollback();
            throw new StudentException("Exception while creating user: " + e.getMessage());
        }
    }
    
	public Student getStudent(int userID){
        try {
            begin();
            Query q = getSession().createQuery("from Student where id = :userid");
            q.setInteger("userid", userID);
            Student st = (Student) q.uniqueResult();
            close();
            return st;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally {
			close();
		}
		return null;
            
	}
	public ArrayList<Student> getAll(){
        try {
            begin();
            Query q = getSession().createQuery("from Student ");
          //  q.setInteger("userid", userID);
            ArrayList<Student> st =  (ArrayList<Student>) q.list();
            close();
            return st;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally {
			close();
		}
		return null;
            
	}

//    public void delete(User user) throws UserException {
//        try {
//            begin();
//            getSession().delete(user);
//            commit();
//        } catch (HibernateException e) {
//            rollback();
//            throw new UserException("Could not delete user " + user.getUsername(), e);
//        }
//    }
}
