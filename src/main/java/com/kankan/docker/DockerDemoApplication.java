package com.kankan.docker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DockerDemoApplication {

    private static final Logger logger = LoggerFactory.getLogger(DockerDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DockerDemoApplication.class, args);
    }

    @RequestMapping("/hello/docker")
    public String hello() {
        logger.info("hello/docker log");
        return "hello";
    }

    @RequestMapping("/pressure")
    public String hello2() {
        double radom = Math.random() * 100000;
        long result = 0L;
        for (int i = 0; i < (int) radom; i ++) {
            result += i;
        }
        logger.info("random is :{}, result is:{}", radom, result);
        return "hello2";
    }
}
