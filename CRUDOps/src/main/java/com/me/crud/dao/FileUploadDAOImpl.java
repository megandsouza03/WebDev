package com.me.crud.dao;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.me.crud.pojo.UploadFile;


@Repository
public class FileUploadDAOImpl extends DAO implements FileUploadDAO  {
	
    private static final Logger log = Logger.getAnonymousLogger();
    
	
    public FileUploadDAOImpl() {
    }
 
//    public FileUploadDAOImpl(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
 
    @Override
    @Transactional
    public void save(UploadFile uploadFile) {
        getSession().save(uploadFile);
    }
}