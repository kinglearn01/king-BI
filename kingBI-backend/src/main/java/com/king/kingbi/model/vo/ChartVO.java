package com.king.kingbi.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.util.Date;
import lombok.Data;

/**
 * ClassName:ChartVO
 * Description:
 *
 * @Author:kinglearn
 * @Create2024/9/4 21:41
 * @version1.0
 */
@Data
public class ChartVO {
    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private Long id;

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

    /**
     * 生成的分析结论
     */
    private String genResult;

    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
