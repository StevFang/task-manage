package com.yoyo.monitor;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Created by fbin on 2018/3/15.
 */
@Component
public class RocketMQHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        int errorCode = check();
        if(errorCode != 0){
            return Health.down().withDetail("ErrorCode", errorCode).build();
        }
        return Health.up().build();
    }

    private int check(){
        // 对监控对象的检测操作
        return 0;
    }
}
