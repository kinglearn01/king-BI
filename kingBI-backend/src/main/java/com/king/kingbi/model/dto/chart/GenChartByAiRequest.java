package com.king.kingbi.model.dto.chart;

import java.io.Serializable;
import lombok.Data;

/**
 * 文件上传请求
 *
 *
 * 
 */
@Data
public class GenChartByAiRequest implements Serializable {
    /**
     * 名称
     */
    private String name;
    /**
     * 目标
     */
    private String goal;

    /**
     * 图表类型
     */
    private String chartType;

    private static final long serialVersionUID = 1L;
}