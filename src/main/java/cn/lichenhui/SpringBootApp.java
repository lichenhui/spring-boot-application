package cn.lichenhui;

import cn.lichenhui.model.User;
import cn.lichenhui.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.annotation.PostConstruct;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringBootApp {

    @Autowired
    private HelloWorldService helloWorldService;

    public static void main( String[] args ) {
        SpringApplication.run(SpringBootApp.class);
    }

    @PostConstruct
    public void hello() {
        helloWorldService.printHello();
        User user = helloWorldService.getUserById(1);
        System.out.println(user.getName());
        System.out.println(user.getPhone());
    }
}
