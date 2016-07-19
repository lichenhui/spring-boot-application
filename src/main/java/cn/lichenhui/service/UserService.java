package cn.lichenhui.service;

import cn.lichenhui.dao.UserDao;
import cn.lichenhui.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

	@Resource(name = "userJdbcDao")
	private UserDao userDao;

	public User getUserById(long id) {
		return userDao.getUerById(id);
	}
}
