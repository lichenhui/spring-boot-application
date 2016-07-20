package cn.lichenhui.service;

import cn.lichenhui.dao.UserDao;
import cn.lichenhui.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public User getUserById(long id) {
		return userDao.getUerById(id);
	}
}
