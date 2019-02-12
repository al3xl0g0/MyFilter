package com.coutrap.services;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import facade.CouponClientFacade;

@Path("/admin")
public class AdminService {
	
	@Context
	private HttpServletRequest request;
	@Context
	private HttpServletRequest response;
	
	public AdminService() {
		
		CouponClientFacade facade = (CouponClientFacade)this.request.getSession(false).getAttribute("CouponClientFacade");
		
	}

}
