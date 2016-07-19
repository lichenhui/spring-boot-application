package cn.lichenhui.service;

import cn.lichenhui.dao.UserDao;
import cn.lichenhui.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HelloWorldService {

	private static final Logger log = LoggerFactory.getLogger(HelloWorldService.class);

	@Resource(name = "userJdbcDao")
	private UserDao userDao;

	public void printHello() {
		System.out.println("Hello world!");
	}

	public User getUserById(long id) {
		return userDao.getUerById(id);
	}

	public void logHello() {
		log.info("Hello world!");
	}


}
