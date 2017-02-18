package com.tgb.web.controller.annotation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * 注意这里面的优化：
 * 1.把每个方法中共同的/user2提出来放到类上面，请求的时候还是像原来的请求一样
 * 		比如第一个方法请求方式为：/projectName/user2/addUser
 * 2.不区分get和post请求，因为基于团队开发考虑，在界面上发ajax时要考虑请求方式比较
 * 		麻烦，如果界面是另外一个人单独写那么就跟麻烦了
 * @author xiaobai
 *
 */

@Controller
@RequestMapping("/user2")
public class User2Controller {
	/**
	 * 1.注意这里方法的@requestMapping原来写法是
	 * 		@RequestMapping(value="/user/addUser",method=RequestMethod.POST)
	 * 2.注意方法的返回值不再是ModelAndView 而是字符串，当然这么写的话模型数据传递可以用
	 * 		request.setAttribut方式传递
	 * 		
	 * @param request
	 * @return
	 */
	@RequestMapping("/addUser")
	public String addUser(HttpServletRequest request){
		
		String result ="this is addUser------优化版";
		request.setAttribute("result", result);
		return "/jquery";
	}
	
	@RequestMapping("/delUser")
	public String delUser(HttpServletRequest request){
		String result ="this is delUser------优化版";
		request.setAttribute("result", result);
		return "/jquery";
	}
	@RequestMapping("/toUser")
	public String toUser(HttpServletRequest request){
		return "/jquery";
	}
}
