package cn.zl.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.zl.entity.User;
import cn.zl.mapper.UserMapper;

@RestController
public class Demo {

	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping(name="/he", method=RequestMethod.GET)
	public String hello() {
		
		userMapper.insert(new User("bell", 10));
		return "hello";
	}
}
