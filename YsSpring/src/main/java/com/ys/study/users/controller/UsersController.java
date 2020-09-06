package com.ys.study.users.controller;

import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ys.study.users.dto.UsersDto;
import com.ys.study.users.service.UsersService;

@Controller
public class UsersController {
	
	@Autowired
	private UsersService service;
	
	@RequestMapping("/users/signup_form")
	public String signupForm() {
		
		return "users/signup_form";
	}
	
	@RequestMapping("/users/signup")
	public ModelAndView signup(UsersDto dto, ModelAndView mV) {
		
		service.addUser(dto);
		mV.setViewName("users/signup");
		return mV;
	}
	
	@RequestMapping("/users/loginform")
	public String loginform() {
		return  "users/loginform";
	}
	
	@RequestMapping("/users/login")
	public ModelAndView login(ModelAndView mV, UsersDto dto,HttpSession session, HttpServletRequest request) {
		String url=request.getParameter("url");
		String encodedUrl=URLEncoder.encode(url);
		mV.addObject("url", url);
		mV.addObject("encodedUrl", encodedUrl);
		service.login(dto, mV, session);
		mV.setViewName("users/login");
		return mV;
	}
	
	@RequestMapping("/users/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home.do";
	}
	
	@RequestMapping("/users/private/info")
	public ModelAndView info(HttpServletRequest request,ModelAndView mV) {
		service.getInfo(request.getSession(), mV);
		mV.setViewName("users/private/info");
		return mV;
	}
	@RequestMapping("/users/private/pwd_updateform")
	public ModelAndView pwdUpdateform(ModelAndView mView) {
		mView.setViewName("users/private/pwd_updateform");
		return mView;
	}
	@RequestMapping("/users/private/pwd_update")
	public ModelAndView pwdUpdate(ModelAndView mView,
			UsersDto dto, HttpServletRequest request) {
		service.updateUserPwd(request.getSession(), dto, mView);
		mView.setViewName("users/private/pwd_update");
		return mView;
	}
	@RequestMapping("/users/checkid")
	@ResponseBody
	public Map<String, Object> checkid(@RequestParam String inputId){
		return service.isExistId(inputId);
	}
	
}
