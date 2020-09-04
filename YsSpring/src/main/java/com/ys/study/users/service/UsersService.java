package com.ys.study.users.service;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.ys.study.users.dto.UsersDto;

public interface UsersService {
	public void addUser(UsersDto dto);
	public void login(UsersDto dto, ModelAndView mV,HttpSession session);
}