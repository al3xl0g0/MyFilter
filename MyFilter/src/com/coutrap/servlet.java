package com.coutrap;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import enumerators.ClientType;
import facade.CouponClientFacade;
import system.CouponSystem;

/**
 * Servlet implementation class servlet
 */
@WebServlet("/LoginServlet")
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * 
     */
	private CouponSystem sys;
	
	public void init() {
		this.sys = CouponSystem.getInstance();
	}
	
    public servlet() {
        super();
        
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	HttpSession session = request.getSession(false);
    	if (session != null) {
    		session.invalidate(); //Kill the session
    		session = request.getSession(true);
    		
    	} else {
    		session = request.getSession(true); //Create new session
    	}
    	
    	String user = request.getParameter("user");
    	String type = request.getParameter("type");
    	String password = request.getParameter("password");
    	
    	ClientType Ctype = ClientType.valueOf(type);
    	
    	try {
			CouponClientFacade facade  = sys.login(user, password, Ctype);
			if (facade != null) {
				session.setAttribute("clientFacade", facade);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	switch (type) {
		case "Customer":
			request.getRequestDispatcher("customer.html").forward(request, response);
			break;
		case "Company":
			request.getRequestDispatcher("company.html").forward(request, response);
			break;
		case "Admin":
			request.getRequestDispatcher("admin.html").forward(request, response);
			break;
		default:
			
			break;
			
	
		}
    } 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
