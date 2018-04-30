package com.me.crud.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.me.crud.pojo.Applications;
import com.me.crud.pojo.CoopFaculty;
import com.me.crud.pojo.Job;
import com.me.crud.pojo.Student;
import com.me.crud.dao.ApplicationDAO;
import com.me.crud.dao.CoopDAO;
import com.me.crud.dao.JobDAO;
import com.me.crud.dao.StudentDAO;
import com.me.crud.exception.ApplicationException;

@Controller
public class AjaxController {

	@Autowired
	@Qualifier("appDao")
	ApplicationDAO appDao;
	
	@Autowired
	@Qualifier("jobDao")
	JobDAO jobDao;
	
	@Autowired
	@Qualifier("coopDao")
	CoopDAO coopDao;
	
	@Autowired
	@Qualifier("studentDao")
	StudentDAO studentDao;
	
	@RequestMapping(value = "*/ajaxservice.htm", method = RequestMethod.POST)
    @ResponseBody
    public String ajaxService(HttpServletRequest request) throws ApplicationException
    {	System.out.println("hElo Ajax");
    String ao = null;
        String queryString = request.getParameter("search");
        if(queryString.equals("Applications")) {
        	ArrayList<Applications> a = appDao.getByJob();
        	ao = Integer.toString(a.size());
        }
        if(queryString.equals("Students")) {
        	ArrayList<Student> a = studentDao.getAll();
        	ao = Integer.toString(a.size());
        }
        if(queryString.equals("Jobs")) {
        	ArrayList<Job> a = jobDao.get();
        	ao = Integer.toString(a.size());
        }
        if(queryString.equals("Faculty")) {
        	ArrayList<CoopFaculty> a = coopDao.getAll();
        	ao = Integer.toString(a.size());
        }
        
        
        
        return ao;
    }
	
	
}
