package cn.lichenhui.controller;

import cn.lichenhui.model.User;
import cn.lichenhui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String hello() {
		return "Hello world!";
	}

	@RequestMapping("/user/{id}")
	public ResponseEntity<?> getUser(@PathVariable long id) {
		User user = userService.getUserById(id);
		if (user == null) {
			Map<String, Object> resultMap = new HashMap<>();
			resultMap.put("msg", "该用户不存在");
			return new ResponseEntity<>(resultMap, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(user, HttpStatus.OK);
	}
}
