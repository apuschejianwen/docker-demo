package com.kankan.docker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoThread implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(DemoThread.class);

    /**
     * 压测开启标志，置为false关闭压测线程
     */
    public static volatile boolean run;

    public DemoThread() {}

    @Override
    public void run() {
        long result = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i ++) {
            if (!run) {
                break;
            }
            if (i == Integer.MAX_VALUE - 1) {
                logger.info("DemoThread.result:{}", result);
                i = 0;
                result = 0;
                continue;
            }
            result += i;
        }
    }
}
