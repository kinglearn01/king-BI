package com.king.kingbi.utils;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * ClassName:ExcelUtils
 * Description:
 *
 * @Author:kinglearn
 * @Create2024/9/5 21:28
 * @version1.0
 */
@Slf4j
public class ExcelUtils {
    public static String excelToCsv(MultipartFile multipartFile)  {
        File file = null;
//        try {
//            file = ResourceUtils.getFile("classpath:test.xlsx");
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
        List<Map<Integer, String>> list = null;
        try {
            list = EasyExcel.read(multipartFile.getInputStream())
                    .excelType(ExcelTypeEnum.XLSX)
                    .sheet()
                    .headRowNumber(0)
                    .doReadSync();
        } catch (IOException e) {
            log.error("表格处理错误",e);
            throw new RuntimeException(e);
        }
        if (CollUtil.isEmpty(list)){
            return "";
        }
        StringBuilder stringBuilder =new StringBuilder();
        Map<Integer, String> headMap =(LinkedHashMap) list.get(0);
        List<String> headerList = headMap.values().stream().filter(ObjectUtils::isNotEmpty).collect(Collectors.toList());
        stringBuilder.append(StringUtils.join(headerList,",")).append("\n");
        for (int i=1;i< list.size();i++){
            LinkedHashMap<Integer, String> dataMap =(LinkedHashMap) list.get(i);
            List<String> dataList = dataMap.values().stream().filter(ObjectUtils::isNotEmpty).collect(Collectors.toList());
            stringBuilder.append(StringUtils.join(dataList,",")).append("\n");
        }

        return stringBuilder.toString();
    }
}
