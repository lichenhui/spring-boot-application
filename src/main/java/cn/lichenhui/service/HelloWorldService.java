package cn.lichenhui.service;

import cn.lichenhui.dao.UserDao;
import cn.lichenhui.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HelloWorldService {

	@Resource(name = "userJdbcDao")
	private UserDao userDao;

	public void printHello() {
		System.out.println("Hello world!");
	}

	public User getUserById(long id) {
		return userDao.getUerById(id);
	}

}
