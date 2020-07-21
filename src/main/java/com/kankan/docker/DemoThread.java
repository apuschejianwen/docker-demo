package com.kankan.docker;

public class DemoThread implements Runnable {

    @Override
    public void run() {
        long result = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i ++) {
            if (i == Integer.MAX_VALUE - 1) {
                i = 0;
                result = 0;
                continue;
            }
            result += i;
        }
    }
}
