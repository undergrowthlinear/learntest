package com.webservice.proxy;

import java.util.UUID;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.alibaba.fastjson.JSON;
import com.learnback.service.UserService;
import com.learncommon.User;
import com.learncommon.XmlBeanUtils;

@Service
@WebService(serviceName="userWebService")
@SOAPBinding(parameterStyle=ParameterStyle.WRAPPED)
public class UserWebService  extends SpringBeanAutowiringSupport {

	@Autowired
	private UserService userService;
	
	@WebMethod
	public String countTypeUser(int type){
		int count=userService.countTypeUser(type);
		return JSON.toJSONString(count);
	}
	
	@WebMethod
	public String getUserById(String id){
		User user=new User();
		user.setUserName(id);
		user.setPassword(UUID.randomUUID().toString());
		return XmlBeanUtils.bean2Xml(user);
	}
	
}
