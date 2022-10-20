package com.boat.mapper;

import com.boat.entity.Forecast;
import org.apache.ibatis.annotations.Mapper;


/**
 * @Author 李云鹏
 * @Date 2022/9/27 17:47
 * @Version 1.0
 */
@Mapper
public interface ForecastMapper {
    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Forecast record);
}