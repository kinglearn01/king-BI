package com.king.kingbi.model.dto.chart;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.king.kingbi.common.PageRequest;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ClassName:ChartQueryRequest
 * Description:
 *
 * @Author:kinglearn
 * @Create2024/9/4 21:41
 * @version1.0
 */
@Data
public class ChartQueryRequest extends PageRequest implements Serializable {
    /**
     * id
     */

    private Long id;
    /**
     * 名称
     */
    private String name;

    /**
     * 分析目标
     */
    private String goal;

    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * 图表类型
     */
    private String chartType;


    private static final long serialVersionUID = 1L;
}
