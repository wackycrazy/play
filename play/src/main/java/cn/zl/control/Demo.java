package cn.zl.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.zl.entity.Dept;
import cn.zl.entity.User;
import cn.zl.mapper.DeptMapper;

@RestController
public class Demo {

	@Autowired
	private DeptMapper deptMapper;
	
	@RequestMapping(name="/he", method=RequestMethod.GET)
	public String hello() {
		
		try {
			List<Dept> list = deptMapper.getAll();
			System.out.println(list);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "hello";
	}
}
