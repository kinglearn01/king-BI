package com.king.kingbi.utils.excelAnalysis;

import com.king.kingbi.manager.BigModelNew;
import com.king.kingbi.model.AI.AIResultDto;
import org.redisson.api.RedissonClient;

public class AiUtils {
    private final RedissonClient redissonClient;
    public AiUtils(RedissonClient redissonClient){
        this.redissonClient = redissonClient;
    }
    public AIResultDto getAns(long chartId, String question) {
        BigModelNew bigModelNew = new BigModelNew(chartId,redissonClient);
        bigModelNew.getResult(question);
        String aReturn = bigModelNew.getReturn();
        System.out.println(aReturn);
        String chartData = "";
        String onAnalysis = "";
        if(aReturn.contains("：") && aReturn.contains("然后输出【【【【【"))
            onAnalysis = aReturn.substring(aReturn.indexOf("：") + 1,aReturn.indexOf("然后输出【【【【【"));
        String[] split = aReturn.split("```json");
        if(split.length == 2){
            chartData = split[1].substring(0,split[1].indexOf("```"));
        }
        AIResultDto aiResultDto = new AIResultDto();
        aiResultDto.setChartData(chartData.trim());
        aiResultDto.setOnAnalysis(onAnalysis.trim());
        System.out.println(onAnalysis);
        System.out.println(chartData);
        return aiResultDto;
    }
}