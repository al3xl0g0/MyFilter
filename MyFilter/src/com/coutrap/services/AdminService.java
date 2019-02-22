package com.coutrap.services;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import facade.AdminFacade;
import facade.CouponClientFacade;
import javaBeans.Company;

@Path("/admin")
public class AdminService {
	
	@Context
	private HttpServletRequest request;
	@Context
	private HttpServletRequest response;
	
	public CouponClientFacade getFacade() {
		
		CouponClientFacade facade = (CouponClientFacade)this.request.getSession(false).getAttribute("CouponClientFacade");
		return facade;
		
	}
	@Path("create_comp")
	@Produces(MediaType.TEXT_PLAIN)
	public String CreateCompany( @QueryParam("name") String compName, @QueryParam("password") String password, @QueryParam("Email") String email) {
		String Msg = "";
		AdminFacade facade= (AdminFacade)this.getFacade();
		Company c = new Company( compName, password, email);
		try {
			facade.createCompany(c);
			Msg = Msg + "Company Crate !!";
		} catch (Exception e) {
			// TODO: handle exception
			Msg = e.getMessage();
		}
		return Msg;
	}

}
