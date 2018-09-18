package com.hnq.study.dao.mapper.ext;

import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * @author henengqiang
 * @date 2018/9/14
 */
public interface BaiduHotExtMapper {

    /**
     * 获取表中某一字段在指定id中的数据List（去重后）
     * @param titleName 字段名
     * @param idStart   起始id
     * @param idEnd     截止id
     * @return          id间字段数据List
     */
    List<String> getFieldDataList(@Param("titleName") String titleName,
                          @Param("idStart") Integer idStart,
                          @Param("idEnd") Integer idEnd);

}
