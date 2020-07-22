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
        return "hello new";
    }

    @RequestMapping("/hello3/docker")
    public String hello3() {
        logger.info("hello/docker log");
        return "hello3";
    }

    @RequestMapping("/pressure")
    public String pressure() {
        Thread thread = new Thread(new DemoThread());
        thread.start();
        return thread.getName();
    }

}
