package com.example.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.n3r.idworker.Sid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.advice.MyExceptionHandler;
import com.example.pojo.SysUser;
import com.example.result.ResponseResult;
import com.example.service.SysUserService;

@RestController
public class UserController extends MyExceptionHandler {

	@Resource
	private SysUserService userService;
	
	@Resource
	private Sid sid;
	
	@GetMapping("/saveUser")
	public ResponseResult saveUser() {
		
		String id = sid.nextShort();
		
		SysUser user = new SysUser();
		user.setId(id);
		user.setUsername("Ysl");
		user.setPassword("abc123");
		user.setRegistTime(new Date());
		user.setIsDelete(0);
		user.setNickname("YSL");
		
		userService.saveUser(user);
		return ResponseResult.resultSuccess(user);
	}
	
	
	
	@GetMapping("/updateUser")
	public ResponseResult updateUser() {
		SysUser user = new SysUser();
		user.setId("10011001");
		user.setUsername("Ysl"+123);
		user.setNickname("YSL"+123);
		userService.updateUser(user);
		return ResponseResult.resultSuccess(user);
	}
	
	
	
	@GetMapping("/deleteUser")
	public ResponseResult deleteUser() {
		userService.deleteUser("1803269654BP2428");
		return ResponseResult.resultSuccess();
	}
	
	
	
	@GetMapping("/selectUser")
	public ResponseResult selectUser() {
		SysUser user = userService.queryUserById("10011001");
		return ResponseResult.resultSuccess(user);
	}
	
	
	@GetMapping("/selectUserList")
	public ResponseResult selectUser(Integer page) {
		if(page == null) {
			page = 1;
		}
		int pageSize = 10;
		SysUser user = new SysUser();
		List<SysUser> list = userService.queryUserListPaged(user, page, pageSize);
		return ResponseResult.resultSuccess(list);
	}
	
	
	@GetMapping("/queryUser")
	public ResponseResult queryUser() {
		return ResponseResult.resultSuccess(userService.querySysUserById("10011001"));
	}
	
	
	
	@GetMapping("/transactional")
	public ResponseResult transactional() {
		SysUser user = new SysUser();
		user.setId("123");
		userService.saveUser(user);
		int i = 1 / 0;
		user.setIsDelete(1);
		userService.updateUser(user);
		return ResponseResult.resultSuccess();
	}
	
	
}
