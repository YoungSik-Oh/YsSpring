package com.ys.study.users.service;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ys.study.users.dao.UsersDao;
import com.ys.study.users.dto.UsersDto;
@Service
public class UsersServiceImpl implements UsersService{
	@Autowired
	private UsersDao dao;
	
	@Override
	public void addUser(UsersDto dto) {
		String inputPwd=dto.getPwd(); 
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String encodedPwd=encoder.encode(inputPwd); 
		dto.setPwd(encodedPwd);
		
		dao.insert(dto);
	}

	@Override
	public void login(UsersDto dto, ModelAndView mV, HttpSession session) {
		boolean isValid=false;
		UsersDto resultDto=dao.getData(dto.getId());
		if(resultDto != null) {
			String encodedPwd=resultDto.getPwd();
			String inputPwd=dto.getPwd();
			isValid=BCrypt.checkpw(inputPwd, encodedPwd);
		}
		
		if(isValid) {//만일 유효한 정보이면 
			//로그인 처리를 한다. 
			session.setAttribute("id", dto.getId());
			//view 페이지에서 사용할 정보 
			mV.addObject("isSuccess", true);
		}else {//아니면 
			mV.addObject("isSuccess", false);
		}
	}

	@Override
	public void getInfo(HttpSession session, ModelAndView mV) {
		// TODO Auto-generated method stub
		String id=(String)session.getAttribute("id");
		UsersDto dto=dao.getData(id);
		mV.addObject("dto",dto);
		
	}


}

