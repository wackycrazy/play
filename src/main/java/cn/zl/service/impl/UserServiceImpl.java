package cn.zl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.zl.entity.User;
import cn.zl.mapper.UserMapper;
import cn.zl.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	public User login(String account) {

		User user = userMapper.selectByAccount(account);
		return user;
	}

	public boolean updateById(Long userId, String name) {
		int num = 0;
		try{
			num = userMapper.updateName(userId, name);
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(num != 0) {
			return true;
		}else {
			return false;
		}
	}

}
