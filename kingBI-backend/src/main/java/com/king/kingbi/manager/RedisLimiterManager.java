package com.king.kingbi.manager;

import com.king.kingbi.common.ErrorCode;
import org.redisson.api.RRateLimiter;
import org.redisson.api.RateIntervalUnit;
import org.redisson.api.RateType;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ClassName:RedisLimiterManager
 * Description:
 *
 * @Author:kinglearn
 * @Create2024/9/13 15:42
 * @version1.0
 */
@Service
public class RedisLimiterManager {
    @Resource
    private RedissonClient redissonClient;
    public void doRateLimit(String key){
         RRateLimiter rateLimiter = redissonClient.getRateLimiter(key);
         rateLimiter.trySetRate(RateType.OVERALL, 2, 1, RateIntervalUnit.SECONDS);
         boolean canAcquire = rateLimiter.tryAcquire(1);
         if (!canAcquire){
             throw new RuntimeException(ErrorCode.TOO_MANY_REQUEST.getMessage());
         }
    }

}
