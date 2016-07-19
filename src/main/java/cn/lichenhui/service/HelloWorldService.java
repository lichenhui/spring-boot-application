package cn.lichenhui.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

	private static final Logger log = LoggerFactory.getLogger(HelloWorldService.class);

	public void printHello() {
		System.out.println("Hello world!");
	}

	public void logHello() {
		log.info("Hello world!");
	}


}
