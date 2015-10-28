package com.webservice.proxy;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.learnback.service.UserService;

@Service
@WebService(serviceName="userWebService")
@SOAPBinding(parameterStyle=ParameterStyle.WRAPPED)
public class UserWebService  extends SpringBeanAutowiringSupport {

	@Autowired
	private UserService userService;
	
	@WebMethod
	public int countTypeUser(int type){
		return userService.countTypeUser(type);
	}
	
	
	
}
