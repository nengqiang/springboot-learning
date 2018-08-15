package com.hnq.study.dao.mapper.cluster;

import com.hnq.study.dao.domain.cluster.City;
import com.hnq.study.dao.domain.cluster.CityCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CityMapper {
    int countByExample(CityCriteria example);

    int deleteByExample(CityCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(City record);

    int insertSelective(City record);

    List<City> selectByExampleWithRowbounds(CityCriteria example, RowBounds rowBounds);

    List<City> selectByExample(CityCriteria example);

    City selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") City record, @Param("example") CityCriteria example);

    int updateByExample(@Param("record") City record, @Param("example") CityCriteria example);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}