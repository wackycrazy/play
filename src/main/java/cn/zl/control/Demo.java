package cn.zl.control;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.zl.dto.DTO;
import cn.zl.entity.Dept;
import cn.zl.entity.User;
import cn.zl.service.UserService;
import cn.zl.util.AuthUtil;
import cn.zl.util.WebTokenUtil;

//@RestController
@Controller
@RequestMapping("/demo")
public class Demo {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
	public String login(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		String account = request.getParameter("account");
		User user = userService.login(account);
		DTO dto = new DTO();
		if(user == null) {
			dto.code = "-1";
			dto.message = "没有该用户";
		}else {
			//把用户信息放到Session中
			Map<String, Object> loginInfo = new HashMap<String, Object>();
			loginInfo.put("userId", user.getId());
			String sessionId = WebTokenUtil.createWebToken(loginInfo);
			/*// 将token放进Cookie
			Cookie cookie = new Cookie("sessionId", sessionId);
			cookie.setPath("/");
			// 过期时间设为10min
			cookie.setMaxAge(60*10);
			response.addCookie(cookie);*/
			System.out.println(sessionId);
			dto.data = sessionId;
		}
		/*map.put("hello", JSON.toJSON(dto));
		return "/helloHtml";*/
		return JSON.toJSONString(dto);
	}
	
	@RequestMapping(value="/update", method = {RequestMethod.GET, RequestMethod.POST})
	public String updateName(HttpServletRequest request, Map<String, Object> map) {
		DTO dto = new DTO();
		String name = request.getParameter("name");
		try {
			Long userId = AuthUtil.getUserId(request);
			boolean userIsExist = userService.updateById(userId, name);
			if(userIsExist == false) {
				dto.setCode("-1");
				dto.setMessage("没有更新");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*map.put("hello", JSON.toJSON(dto));
		return "/helloHtml";*/
		return "/page/login/login"; 
	}
	/*@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String login(HttpServletRequest request, Map<String,Object> map) {
		
		 map.put("hello","from Demo.helloHtml");
		 return "/page/login/login"; 
	}
	
	@RequestMapping(value = "/index", method=RequestMethod.POST)
	public String hello(HttpServletRequest request, Map<String,Object> map) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		 map.put("hello","from Demo.helloHtml");
		 return "/index"; 
	}
	
	@RequestMapping(value = "/world", method=RequestMethod.GET)
	public String world(HttpServletRequest request, Map<String,Object> map) {
		
		 map.put("hello","from Demo.helloHtml");
		 return "/page/main"; 
	}*/
}
