package com.me.crud.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.annotations.common.reflection.java.generics.TypeEnvironmentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.me.crud.dao.ApplicationDAO;
import com.me.crud.dao.JobDAO;
import com.me.crud.dao.StudentDAO;
import com.me.crud.exception.ApplicationException;
import com.me.crud.exception.JobException;
import com.me.crud.exception.StudentException;
import com.me.crud.pojo.Applications;
import com.me.crud.pojo.CoopFaculty;
import com.me.crud.pojo.Job;
import com.me.crud.pojo.Student;
import com.me.crud.pojo.User;
import com.me.crud.pojo.enumTypes.Role;
import com.me.crud.validator.ApplicationValidator;
import com.me.crud.validator.UserValidator;





@Controller
public class StudentController {
	@Autowired
	@Qualifier("userDao")
	StudentDAO userDao;
	
	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;
	
	@Autowired
	@Qualifier("appValidator")
	ApplicationValidator appvalidator;
	
	@Autowired
	@Qualifier("studentDao")
	StudentDAO studentDao;
	
	@Autowired
	@Qualifier("jobDao")
	JobDAO jobDao;
	
	@Autowired
	@Qualifier("appDao")
	ApplicationDAO appDao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/user/createStudent.htm", method = RequestMethod.GET)
	protected ModelAndView registerUser() throws Exception {
        System.out.print("registerStudent");

        return new ModelAndView("registerPageStudent", "user", new Student());

    }
	
	@RequestMapping(value = "/user/register1",method=RequestMethod.POST)
	protected ModelAndView registerNewUser(HttpServletRequest request,  @ModelAttribute("user") Student user, BindingResult result) throws Exception {
        validator.validate(user, result);

        if (result.hasErrors()) {
        	System.out.println(result.getAllErrors());
        	System.out.println("ERRORS");
            return new ModelAndView("registerPageStudent", "user", user);
        }

        try {

            System.out.print("registerNewUser");
 
            	System.out.println("I came to Student");
            user.setRole(Role.Student);
            System.out.println(user.getRole());
            User u = userDao.register(user);
            request.getSession().setAttribute("user", u);
            return new ModelAndView("home", "user", u);
            
         

        } catch (StudentException e) {
            System.out.println("Exception: " + e.getMessage());
            return new ModelAndView("error", "errorMessage", "error while login");
        }
	}
	

	
	@RequestMapping(value = "/user/student/delete.htm",method=RequestMethod.GET)
	protected ModelAndView deleteJob(HttpServletRequest request, HttpServletResponse response) throws ApplicationException {
		  String[] i = request.getParameterValues("appID");
		  for(int ii=0;ii < i.length ;ii++) {
		  System.out.println("Select"+i[ii]);
		  
		  }
		  appDao.delete(i);
		HttpSession session = request.getSession();
		int userid = (Integer) session.getAttribute("userid");
		
		Student student = studentDao.getStudent(userid);
		ArrayList<Applications> appList = appDao.getMyApplications(student);
		
  		return new ModelAndView("MyApplications", "applications", appList);
	}
	
	
	@RequestMapping(value = "/user/student/logout.htm", method = RequestMethod.GET)
	public String logout(HttpServletRequest request,
			HttpServletResponse response) {
		request.getSession().invalidate();
//		request.getSession().setAttribute("userid", null);
		return "redirect:/";
	}
	
	@RequestMapping(value ="/user/student/profile.htm" ,method = RequestMethod.GET)
	protected ModelAndView profileStudent(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession(false);
		int userid = (Integer) session.getAttribute("userid");
		System.out.println(userid);
		Student student = studentDao.getStudent(userid);
		return new ModelAndView("profileStudent","student",student);
	}
	
	@RequestMapping(value ="/user/student/jobs.htm", method = RequestMethod.GET)
	protected ModelAndView jobView(HttpServletRequest request) throws ApplicationException {
		Map<String, Object> map = new HashMap<String, Object>();
        ArrayList<Job> jl = jobDao.get();
        ArrayList<Job> j1 = new ArrayList<Job>();
		HttpSession session = request.getSession(false);
		int userid = (Integer) session.getAttribute("userid");
		Student s =  studentDao.getStudent(userid);
		

	
		map.put("jobList",jl);
		map.put("student",s);
		return new ModelAndView("jobViewStudent", "map", map);
		
	}
	
	@RequestMapping(value = "/user/student/Apply.htm" , method = RequestMethod.POST)
	protected ModelAndView fileuploading(HttpServletRequest request) {
		HttpSession session=request.getSession();
		System.out.println("yeyreyrere");
		System.out.println(request.getParameter("jobSelected"));
		session.setAttribute("JobID", request.getParameter("jobSelected"));
		return new ModelAndView("ApplicationPage","application",new Applications());
	}
	
	@RequestMapping(value="/user/student/submit/application.htm", method = RequestMethod.POST)
	protected ModelAndView createApplication(HttpServletRequest request,  @ModelAttribute("application") Applications application, BindingResult result) throws Exception {
        appvalidator.validate(application, result);

        if (result.hasErrors()) {
        	System.out.println(result.getAllErrors());
        	System.out.println("ERRORS");
            return new ModelAndView("ApplicationPage", "application", application);
        }

        try {

      
           System.out.println("I came to save application");
           HttpSession session = request.getSession();
           int jID = Integer.parseInt((String) session.getAttribute("JobID"));
           Job job = jobDao.getUniqueJob(jID);
           System.out.println(session.getAttribute("userid"));
           int userid = (Integer) session.getAttribute("userid");
           Student student = studentDao.getStudent(userid);
           application.setStudent(student);
           application.setJob(job);
           application.setDateSubmitted(new Date());
           Applications a = appDao.createJob(application);
           return new ModelAndView("dashboardStudent");
        } 
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return new ModelAndView("error", "errorMessage", "error while login");
        }
	}
	
	@RequestMapping(value="/user/student/applications.htm", method = RequestMethod.GET)
	protected ModelAndView goToApplications(HttpServletRequest request) throws ApplicationException {
		HttpSession session = request.getSession();
		int userid = (Integer) session.getAttribute("userid");
        Student student = studentDao.getStudent(userid);
		ArrayList<Applications> appList = appDao.getMyApplications(student);
		return new ModelAndView("MyApplications","applications",appList);
	}
}
