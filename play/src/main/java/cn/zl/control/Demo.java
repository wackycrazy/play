package cn.zl.control;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import cn.zl.entity.Dept;
import cn.zl.mapper.DeptMapper;

@Controller
@RequestMapping("/demo")
public class Demo {

	@Autowired
	private DeptMapper deptMapper;
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String login(HttpServletRequest request, Map<String,Object> map) {
		
		 map.put("hello","from Demo.helloHtml");
		 return "/page/login/login"; 
	}
	
	@RequestMapping(value = "/index", method=RequestMethod.POST)
	public String hello(HttpServletRequest request, Map<String,Object> map) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		 map.put("hello","from Demo.helloHtml");
		 return "index"; 
	}
	
	@RequestMapping(value = "/world", method=RequestMethod.GET)
	public String world(HttpServletRequest request, Map<String,Object> map) {
		
		 map.put("hello","from Demo.helloHtml");
		 return "/page/main"; 
	}
}
