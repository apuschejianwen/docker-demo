package com.kankan.docker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DockerDemoApplication.class);

    @Value("${user.aaa}")
    private String userName;

    @RequestMapping("/hello")
    public String hello() {
        logger.info("hello2 log");
        /**
         * 项目1.0.0版本（镜像1.0.0）返回 hello1
         * 项目2.0.0版本（镜像2.0.0）返回 hello2
         * 项目3.0.0版本（镜像3.0.0）返回 hello3
         */
        return "hello2";
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

    /**
     * 阿里ACM测试用接口
     *
     * @return
     */
    @RequestMapping("/testAcm")
    public String testAcm() {
        return userName;
    }
}
