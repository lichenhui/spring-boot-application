package cn.lichenhui;

import cn.lichenhui.service.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringBootApp {

    @Autowired
    private HelloWorld helloWorld;

    public static void main( String[] args ) {
        SpringApplication.run(SpringBootApp.class);
    }

    @PostConstruct
    public void hello() {
        helloWorld.printHello();
    }
}
