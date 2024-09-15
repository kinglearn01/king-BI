package com.king.kingbi.manager;

import com.king.kingbi.common.ErrorCode;
import com.king.kingbi.exception.BusinessException;
import com.yupi.yucongming.dev.client.YuCongMingClient;
import com.yupi.yucongming.dev.common.BaseResponse;
import com.yupi.yucongming.dev.model.DevChatRequest;
import com.yupi.yucongming.dev.model.DevChatResponse;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * ClassName:AiManager
 * Description:
 *
 * @Author:kinglearn
 * @Create2024/9/6 14:37
 * @version1.0
 */
@Component
public class AiManager {
    @Resource
    private YuCongMingClient yuCongMingClient;

    public String doChart(long modelId,String message){
        DevChatRequest devChatRequest = new DevChatRequest();
        devChatRequest.setModelId(modelId);
        devChatRequest.setMessage(message);
        BaseResponse<DevChatResponse> response = yuCongMingClient.doChat(devChatRequest);
        if(response==null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"AI 错误");
        }
        return response.getData().getContent();
    }
}
