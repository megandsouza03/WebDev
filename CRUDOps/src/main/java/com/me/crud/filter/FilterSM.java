package com.me.crud.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public class FilterSM implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 HttpServletRequest httpRequest = (HttpServletRequest) request;
		 HttpServletResponse httpResponse = (HttpServletResponse) response;
		 System.out.println("SMFIlter1");
			int userid ;
			  try {
				  
				 userid  = (Integer) httpRequest.getSession(false).getAttribute("userid");
				 System.out.println("SMFIlter2");
				  }
			  catch(Exception e) {
				  RequestDispatcher rd = httpRequest.getRequestDispatcher("/");
		            rd.forward(request, response);
				  System.out.println("SMFIlter3");
				  return;
			  }
			  chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
