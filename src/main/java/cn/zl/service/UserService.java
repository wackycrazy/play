package cn.zl.service;

import cn.zl.entity.User;

public interface UserService {

	public User login(String account);
	
	public boolean updateById(Long userId, String name);
}
