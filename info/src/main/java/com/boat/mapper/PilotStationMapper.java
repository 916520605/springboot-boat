package com.boat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.boat.entity.PilotStation;

/**
 * @Author 李云鹏
 * @Date 2022/10/26 13:56
 * @Version 1.0
 */
@Mapper
public interface PilotStationMapper {
    /**
     * insert record to table
     * 
     * @param record the record
     * @return insert count
     */
    int insert(PilotStation record);

    /**
     * 根据条件查询所有
     *
     * @param pilotStation 引航站
     * @return {@link List }<{@link PilotStation }>
     * @author 李云鹏
     * @date 2022/10/26
     */
    List<PilotStation> selectAllByAll(PilotStation pilotStation);

    /**
     * 更新通过id
     *
     * @param pilotStation 引航站
     * @return int
     * @author 李云鹏
     * @date 2022/10/27
     */
    int updateById(PilotStation pilotStation);

    /**
     * 删除由ids
     *
     * @param ids id
     * @return int
     * @author 李云鹏
     * @date 2022/10/28
     */
    int deleteByIds(Long[] ids);

}