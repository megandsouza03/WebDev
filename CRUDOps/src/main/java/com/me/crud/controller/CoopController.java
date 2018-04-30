package com.me.crud.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.annotations.common.reflection.java.generics.TypeEnvironmentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.me.crud.dao.ApplicationDAO;
import com.me.crud.dao.CoopDAO;
import com.me.crud.dao.JobDAO;
import com.me.crud.exception.ApplicationException;
import com.me.crud.exception.CoopException;
import com.me.crud.exception.JobException;
import com.me.crud.exception.StudentException;
import com.me.crud.pojo.Applications;
import com.me.crud.pojo.CoopFaculty;
import com.me.crud.pojo.Job;
import com.me.crud.pojo.Student;
import com.me.crud.pojo.User;
import com.me.crud.pojo.enumTypes.Role;
import com.me.crud.validator.CoopValidator;
import com.me.crud.validator.JobValidator;



@Controller
public class CoopController {

	@Autowired
	@Qualifier("coopDao")
	CoopDAO coopDao;
	
	@Autowired
	@Qualifier("jobDao")
	JobDAO jobDao;
	
	@Autowired
	@Qualifier("coopValidator")
	CoopValidator validator;
	
	@Autowired
	@Qualifier("jobValidator")
	JobValidator jobvalidator;
	
	@Autowired
	@Qualifier("appDao")
	ApplicationDAO appDao;
	
	@RequestMapping(value = "/user/createCoop.htm", method = RequestMethod.GET)
	protected ModelAndView registerUser() throws Exception {
        System.out.print("registerUser");
        return new ModelAndView("registerPageCoop", "coop", new CoopFaculty());

    }
	
	@RequestMapping(value = "/user/coop/stats.htm", method = RequestMethod.GET)
	protected ModelAndView stats() throws Exception {
        System.out.print("registerUser");
        return new ModelAndView("stats");

    }
	

	
//	@RequestMapping(value ="/user/coop/logout.htm" ,method = RequestMethod.GET)
//	protected ModelAndView logout(HttpServletRequest request,HttpServletResponse response) throws IOException {
//		HttpSession session = request.getSession();
//		session.invalidate();
//		return new ModelAndView("home");
//
//		
//	}
	@RequestMapping(value = "/user/coop/logout.htm", method = RequestMethod.GET)
	public String logout(HttpServletRequest request,
			HttpServletResponse response) {
		request.getSession().invalidate();
//		request.getSession().setAttribute("userid", null);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/user/registerCoop.htm",method=RequestMethod.POST)
	protected ModelAndView registerNewUser(HttpServletRequest request, HttpServletResponse response,  @ModelAttribute("coop") CoopFaculty coop, BindingResult result) throws Exception {
        validator.validate(coop, result);
      
        
        if (result.hasErrors()) {
        	System.out.println(result.getAllErrors());
        	System.out.println("ERRORS");
            return new ModelAndView("registerPageCoop", "user", coop);
        }

        try {
        	System.out.print("registerNewUser");
            coop.setRole(Role.CoopFaculty);
            System.out.println(coop.getRole());
            User u = coopDao.register(coop);
            request.getSession().setAttribute("coop", u);
            return new ModelAndView("home", "coop", u);
          } catch (CoopException e) {
            System.out.println("Exception: " + e.getMessage());
            return new ModelAndView("error", "errorMessage", "error while login");
        }
	}
	
	@RequestMapping(value = "/user/coop/profile.htm",method=RequestMethod.GET)
	protected ModelAndView profileCOOP(HttpServletRequest request,HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
	//System.out.println("----------"+session.getAttribute("username"));
		 
		int userid ;
			  try {
				 userid  = (Integer) session.getAttribute("userid");
				  }
			  catch(Exception e) {
				  return new ModelAndView("home");
			  }
		
		
		
		System.out.println(userid);
		CoopFaculty cp = coopDao.get(userid);
		return new ModelAndView("profileCoop","coop",cp);
	        
	}
	
	
	@RequestMapping(value = "/user/coop/jobs.htm",method=RequestMethod.GET)
	protected ModelAndView jobCOOP(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		int userid = (Integer) session.getAttribute("userid");
		System.out.println("jobsView"+userid);
		Map<String, Object> map = new HashMap<String, Object>();
        map.put("msgtype", "create");
        ArrayList<Job> jl = jobDao.get();
		map.put("jobList",jl);
        return new ModelAndView("jobsView", "map", map);
	}
	
	@RequestMapping(value = "/user/coop/jobs/create.htm",method=RequestMethod.GET)
	protected ModelAndView jobCreate(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		int userid = (Integer) session.getAttribute("userid");
		System.out.println("jobsView"+userid);
		Map<String, Object> map = new HashMap<String, Object>();
		return new ModelAndView("createJob", "job", new Job());
	}
	
	
	@RequestMapping(value = "/user/coop/job/submit.htm",method=RequestMethod.POST)
	protected ModelAndView createJob(HttpServletRequest request,  @ModelAttribute("job") Job job, BindingResult result) throws Exception {
        jobvalidator.validate(job, result);

        if (result.hasErrors()) {
        	System.out.println(result.getAllErrors());
        	System.out.println("ERRORS");
        	Map<String, Object> map = new HashMap<String, Object>();
            ArrayList<Job> jl = jobDao.get();
    		map.put("jobList",jl);
            return new ModelAndView("jobsView", "map", map);
        }

        try {
        	System.out.print("jobs New");
            Job j = jobDao.createJob(job);
            Map<String, Object> map = new HashMap<String, Object>();
            ArrayList<Job> jl = jobDao.get();
    		map.put("jobList",jl);
    		return new ModelAndView("jobsView", "map", map);
          } catch (JobException e) {
            System.out.println("Exception: " + e.getMessage());
            return new ModelAndView("error", "errorMessage", "error while login");
        }
	}
	
	@RequestMapping(value = "/user/coop/delete.htm",method=RequestMethod.POST)
	protected ModelAndView deleteJob(HttpServletRequest request, HttpServletResponse response) {
		  String[] i = request.getParameterValues("jobID");
		  for(int ii=0;ii < i.length ;ii++) {
		  System.out.println("Select"+i[ii]);
		  
		  }
		  jobDao.delete(i);
		Map<String, Object> map = new HashMap<String, Object>();
         ArrayList<Job> jl = jobDao.get();
  		map.put("jobList",jl);
  		return new ModelAndView("jobsView", "map", map);
	}
	
	@RequestMapping(value = "/user/coop/students.htm", method = RequestMethod.GET)
	protected ModelAndView studentUnderCoop() throws Exception {
        return new ModelAndView("studentUnderCoop");

    }
	
	@RequestMapping(value = "/user/coop/myStudents.htm", method = RequestMethod.GET)
	protected ModelAndView myStudents(HttpServletRequest request) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msgtype","myStudents");
		HttpSession session = request.getSession();
		int userid = (Integer) session.getAttribute("userid");
		ArrayList<Student> myList = coopDao.getmyStudents(userid);
		map.put("studentList", myList);
        return new ModelAndView("studentUnderCoop","map",map);

    }
	
	@RequestMapping(value = "/user/coop/unassignedStudents.htm", method = RequestMethod.GET)
	protected ModelAndView unAssignedStudents() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msgtype","uStudents");
		ArrayList<Student> uList = coopDao.getUnAssignedStudents();
		map.put("studentList", uList);
        return new ModelAndView("studentUnderCoop","map",map);

    }
	

	
	
	@RequestMapping(value = "/user/coop/selectStudent.htm", method = RequestMethod.POST)
	protected ModelAndView SelectStudents(HttpServletRequest request) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msgtype","uStudents");
		
		HttpSession session = request.getSession();
		int userid = (Integer) session.getAttribute("userid");
		
		coopDao.selectStudents(request.getParameterValues("studentID"),userid);
		
		ArrayList<Student> uList = coopDao.getUnAssignedStudents();
		map.put("studentList", uList);
        return new ModelAndView("studentUnderCoop","map",map);

    }
	
	@RequestMapping(value = "/user/coop/applications.htm",method = RequestMethod.GET )
	protected ModelAndView CoopApplications(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int userid = (Integer) session.getAttribute("userid");
		ArrayList<Student> sList = coopDao.getmyStudents(userid);
		ArrayList<Applications> aList = coopDao.getMyStuApp(sList);
		map.put("aList", aList);
		return new ModelAndView("coopApplications","map",map);
	}
	
	@RequestMapping(value = "/user/student/viewPDF.htm" , method = RequestMethod.POST)
	protected  ModelAndView ViewPDFApplciations(HttpServletRequest request) throws Exception {
		try{int appID = Integer.parseInt(request.getParameter("viewPDF"));
		Applications app = appDao.getMyApplications(appID);
		Map<String, Applications> model = new HashMap<String, Applications>();
		model.put("application", app);
		return new ModelAndView(new PDFResumeView(), model);
		}
		catch (Exception e) {
			throw new Exception("Exception while creating PDF: " + e.getMessage());	
			
		}
		
	}
	
	
	   	
}
