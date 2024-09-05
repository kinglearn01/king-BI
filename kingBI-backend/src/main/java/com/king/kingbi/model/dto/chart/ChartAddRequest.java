package com.king.kingbi.model.dto.chart;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ClassName:ChartAddRequest
 * Description:
 *
 * @Author:kinglearn
 * @Create2024/9/4 21:40
 * @version1.0
 */
@Data
public class ChartAddRequest implements Serializable {
    /**
     * 名称
     */
    private String name;


    /**
     * 分析目标
     */
    private String goal;

    /**
     * 图表数据
     */
    private String chartDate;

    /**
     * 图表类型
     */
    private String chartType;


    private static final long serialVersionUID = 1L;
}
