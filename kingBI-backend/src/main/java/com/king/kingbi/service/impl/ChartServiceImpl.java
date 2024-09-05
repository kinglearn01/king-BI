package com.king.kingbi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.king.kingbi.model.entity.Chart;
import com.king.kingbi.service.ChartService;
import com.king.kingbi.mapper.ChartMapper;
import org.springframework.stereotype.Service;

/**
* @author 13615
* @description 针对表【chart(图表信息表)】的数据库操作Service实现
* @createDate 2024-09-04 21:27:45
*/
@Service
public class ChartServiceImpl extends ServiceImpl<ChartMapper, Chart>
    implements ChartService{

}




