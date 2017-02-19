package com.tgb.web.controller.annotation;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tgb.web.controller.entity.User;

@Controller
@RequestMapping("/user/data")
public class DataController {
	
	@RequestMapping("/addUser")
	public String addUser(User user,HttpServletRequest request){
		request.setAttribute("userName", user.getUserName());
		request.setAttribute("age", user.getAge());
		
		return "/userManager";
	}
	
	@RequestMapping("/addUserJson")
	public void addUserJson(User user,HttpServletRequest request,HttpServletResponse response){
		//{"username":"userName","age","age"}
		String result = "{\"userName\":\" "+ user.getUserName() +" \",\"age\":\" "+ user.getAge()+" \"}";
		PrintWriter out = null;
		response.setContentType("application/json");
		
		try {
			out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/delUser")
	public String delUser(){
		return "";	}
	
	@RequestMapping("/toUser")
	public String toUser(){
		return "/json";	
		}
	
	@RequestMapping("/toImg")
	public String toIMg(){
		return "/staticFile";	
		}

}

