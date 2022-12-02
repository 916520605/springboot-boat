package com.boat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.boat.entity.BaseShip;

/**
 * 基地船映射器
 *
 * @author 李云鹏
 * @description
 * @date 2022/10/13
 */
@Mapper
public interface BaseShipMapper {
    int insertSelective(BaseShip record);

    BaseShip selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BaseShip record);

    List<BaseShip> findAllBYAll(BaseShip baseShip); // 查询所有（模糊查询）

    int deleteByIds(Long[] ids);// 批量删除

    BaseShip selectByImo(@Param("imo") String imo);// 检查imo号的唯一性

    BaseShip selectAllByImoAndNotId(@Param("id") Long id, @Param("imo") String imo);

}