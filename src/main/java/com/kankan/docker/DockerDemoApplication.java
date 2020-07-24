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

    @RequestMapping("/hello")
    public String hello() {
        logger.info("hello1 log");
        /**
         * 项目1.0.0版本（镜像1.0.0）返回 hello1
         * 项目2.0.0版本（镜像2.0.0）返回 hello2
         * 项目3.0.0版本（镜像3.0.0）返回 hello3
         */
        return "hello1";
    }

    /**
     * 开启压测
     *
     * @return
     */
    @RequestMapping("/pressure")
    public String pressure() {
        DemoThread.run = true;
        Thread thread = new Thread(new DemoThread());
        thread.start();
        return thread.getName();
    }

    /**
     * 停止压测
     */
    @RequestMapping("/stopPressure")
    public void stopPressure() {
        DemoThread.run = false;
    }

}
