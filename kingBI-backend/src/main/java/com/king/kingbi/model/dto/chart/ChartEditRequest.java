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
 * ClassName:ChartEditRequest
 * Description:
 *
 * @Author:kinglearn
 * @Create2024/9/4 21:42
 * @version1.0
 */
@Data
public class ChartEditRequest  implements Serializable {
    /**
     * 名称
     */
    private String name;
    /**
     * id
     */
    private Long id;

    /**
     * 分析目标
     */
    private String goal;

    /**
     * 图表数据
     */
    private String chartData;

    /**
     * 图表类型
     */
    private String chartType;


    private static final long serialVersionUID = 1L;
}
