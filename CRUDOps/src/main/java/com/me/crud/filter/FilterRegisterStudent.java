package com.me.crud.filter;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public class FilterRegisterStudent implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	System.out.println("Hello Student Filter");
	 HttpServletRequest httpRequest = (HttpServletRequest) request;
	 if (httpRequest.getMethod().equalsIgnoreCase("POST")) {
		 System.out.println(httpRequest.getParameter("password"));
		 String email = httpRequest.getParameter("email");
		 String phone = httpRequest.getParameter("mobile");
		 String url = httpRequest.getParameter("linkedinUrl");
		 Pattern r1 = Pattern.compile("(\\W|^)[\\w.+\\-]*@husky.neu\\.edu(\\W|$)");
		 Pattern r2 = Pattern.compile("\\d{10}");
		 Pattern r3 = Pattern.compile("((http(s?)://)*([a-zA-Z0-9\\-])*\\.|[linkedin])[linkedin/~\\-]+\\.[a-zA-Z0-9/~\\-_,&=\\?\\.;]+[^\\.,\\s<]");
		 if(!r1.matcher(email).find() ) {
			 HttpServletResponse hresponse = (HttpServletResponse) response;
			 System.out.println(r1.matcher(email).find());
             hresponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Email");
             return;
		 }
		 if(!r2.matcher(phone).find() ) {
			 HttpServletResponse hresponse = (HttpServletResponse) response;
			 System.out.println(r1.matcher(email).find());
             hresponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Phone");
             return;
		 }
		 if(!r3.matcher(url).find() ) {
			 HttpServletResponse hresponse = (HttpServletResponse) response;
			 System.out.println(r1.matcher(email).find());
             hresponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid LinkedinUrl");
             return;
		 }
	 }
	 
	chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
