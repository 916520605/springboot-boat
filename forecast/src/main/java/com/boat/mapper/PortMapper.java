package com.boat.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.boat.entity.Port;

/**
 * @Author 李云鹏
 * @Date 2022/10/1 0:41
 * @Version 1.0
 */
@Mapper
public interface PortMapper {
    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Port record);

    /**
     * update record
     *
     * @param port the updated record
     * @return update count
     */
    int updateById(Port port);

    /**
     * 选择通过港口代码,旨在保证portCode的唯一性
     *
     * @param portCode 港口代码
     * @return {@link Port }
     * @author 李云鹏
     * @date 2022/10/18
     */
    Port selectByPortCode(@Param("portCode") String portCode);

}