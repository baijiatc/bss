package cn.bjtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.model.User;
import cn.bjtc.service.IUserService;

@RestController
public class UserController {

	@RequestMapping("user/all")
	public List<User> getUsers(){
		return userService.findAllUser();
	}
	
	@Autowired
	private IUserService userService;
}
