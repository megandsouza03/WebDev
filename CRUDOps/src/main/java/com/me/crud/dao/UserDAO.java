package com.me.crud.dao;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;

import com.me.crud.pojo.User;


public class UserDAO extends DAO {

	public User get(String userName, String password) throws Exception {
        try {
            begin();
            System.out.println(userName+password);
            Query q = getSession().createQuery("from User where userName = :userName and password = :password");
            q.setString("userName", userName);
            q.setString("password", password);            
            User user = (User) q.uniqueResult();
            close();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not get user " + userName, e);
        }
    }
	
}
