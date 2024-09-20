package com.king.kingbi;

import com.king.kingbi.model.AI.AIResultDto;
import com.king.kingbi.model.entity.Chart;
import com.king.kingbi.mq.MessageConsumer;
import com.king.kingbi.mq.MessageProducer;
import com.king.kingbi.utils.excelAnalysis.AiUtils;
import org.junit.jupiter.api.Test;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * 主类测试
 *
 *
 * 
 */
@SpringBootTest
class MainApplicationTests {
    @Resource
    RedissonClient redissonClient;
    @Resource
    private MessageProducer messageProducer;

    @Test
    void contextLoads() throws Exception {
        Chart chart = new Chart();
        chart.setId(100L);
        AiUtils aiUtils = new AiUtils(redissonClient);
         AIResultDto ans = aiUtils.getAns(chart.getId(), "李白是谁");
        System.out.println(ans.getOnAnalysis());

    }
    @Test
    void testMessageProducer()  {
        messageProducer.sendMessage("kingbi_exchange","text", "你好");
    }


}
