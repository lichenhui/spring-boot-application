package cn.lichenhui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringBootApp {

    private static final String EGD_KEY = "java.security.egd";
    private static final String URANDOM = "/dev/urandom";

    public static void main( String[] args ) {
        if (Files.exists(Paths.get(URANDOM))) {
            // make Tomcat startup faster
            System.setProperty(EGD_KEY, "file://" + URANDOM);
        }
        SpringApplication.run(SpringBootApp.class, args);
    }
}
