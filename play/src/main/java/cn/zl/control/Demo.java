package cn.zl.control;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.zl.entity.Dept;
import cn.zl.mapper.DeptMapper;

@RestController
public class Demo {

	@Autowired
	private DeptMapper deptMapper;
	
	@RequestMapping(name="/heloHtml", method=RequestMethod.GET)
	public String hello(HttpServletRequest request, Map<String,Object> map) {
		
		/*try {
			List<Dept> list = deptMapper.getAll();
			request.setAttribute("list", list);
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		 map.put("hello","from Demo.helloHtml"); 
		 return"/helloHtml"; 
	}
}
