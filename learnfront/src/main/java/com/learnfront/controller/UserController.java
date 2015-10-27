package com.learnfront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnback.service.UserService;

/**
 * 
 * @Description: TODO(用户控制器)
 * @Author <a href="zhangwu@wxchina.com">Wu.Zhang</a>
 * @Date 2015年10月27日
 * @Version 1.0.0
 */
@Controller
public class UserController {

	private UserService userService;

	@RequestMapping(value = Keys.USER_COUNT_TYPE)
	public String countTypeUser(Model model,
			@RequestParam(value = "type", defaultValue = "2") int type) {
		int countType = userService.countTypeUser(type);
		model.addAttribute(Keys.JSON_DATA, countType);
		return Keys.USER_INDEX;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
