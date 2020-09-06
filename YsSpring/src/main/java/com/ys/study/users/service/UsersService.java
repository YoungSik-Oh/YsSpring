package com.ys.study.users.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.ys.study.users.dto.UsersDto;

public interface UsersService {
	public void addUser(UsersDto dto);
	public void login(UsersDto dto, ModelAndView mV,HttpSession session);
	public void getInfo(HttpSession session, ModelAndView mV);
	public void updateUserPwd(HttpSession session, UsersDto dto, ModelAndView mView);
	public Map<String, Object> isExistId(String inputId) ;
}
