package com.me.crud.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.annotations.common.reflection.java.generics.TypeEnvironmentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.me.crud.dao.UserDAO;
import com.me.crud.pojo.User;
import com.me.crud.pojo.enumTypes.Role;



@Controller
public class HomeController {

	@RequestMapping(value = "/crud/home.htm", method = RequestMethod.GET)
	protected ModelAndView registerUser() throws Exception {
	    System.out.print("home");

	    return new ModelAndView("home");

	}
	
	  @RequestMapping(value = "/user/login.htm", method = RequestMethod.POST)
	    public String handleLoginForm(HttpServletRequest request, UserDAO userDao, ModelMap map) {

	        String username = request.getParameter("userName");
	        String password = request.getParameter("password");
	        HttpSession httpSession =request.getSession(true);
			
	        try {
	            User u = userDao.get(username, password);
	            httpSession.setAttribute("userid", u.getId());
	            httpSession.setAttribute("username", u.getUserName());
	            if (u != null && u.getRole().equals(Role.Student)) {
	                return "dashboardStudent";
	            } 
	            else if (u != null && u.getRole().equals(Role.CoopFaculty)) {
	                return "dashboardCoop";
	            } 
	                else {
	                map.addAttribute("errorMessage", "Invalid username/password!");
	                return "error";
	            }
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	        return "home";

	    }

	
}
