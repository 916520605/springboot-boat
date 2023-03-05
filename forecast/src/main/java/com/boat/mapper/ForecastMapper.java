package com.boat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.boat.entity.BaseShip;
import com.boat.entity.Forecast;

/**
 * @author 李云鹏
 * @date 2022/11/22 8:10
 * @version 1.0
 */
@Mapper
public interface ForecastMapper {

    /**
     * 插入选择性
     *
     * @param forecast 预测
     * @return int
     * @author 李云鹏
     * @date 2022/11/23 20:23
     */
    int insertSelective(Forecast forecast);

    /**
     * 查询所有
     *
     * @param forecast 预抵
     * @return {@link List }<{@link Forecast }>
     * @author 李云鹏
     * @date 2022/11/23 21:35
     */
    List<Forecast> findAllByAll(Forecast forecast);

    /**
     * 查询所有在列表之外的基础船舶，
     * 
     * @param baseShip 基地船
     * @return {@link List }<{@link BaseShip }>
     * @author 李云鹏
     * @date 2022/11/24 08:21
     */
    List<BaseShip> selectBySearchNotInIds(@Param("baseShip") BaseShip baseShip);

    /**
     * 查询需要修改的基础船舶是否在预抵船舶中
     *
     * @param baseShipId 基地船id
     * @return {@link Long }
     * @author 李云鹏
     * @date 2022/11/28 10:13
     */
    Long selectBaseShipIdByBaseShipId(@Param("baseShipId") Long baseShipId);

    /**
     * 更新基础船舶的同时，需要同步更新预抵船舶的基本信息
     *
     * @param updated 更新
     * @return int
     * @author 李云鹏
     * @date 2022/11/28 10:19
     */
    int updateByBaseShipId(Forecast updated);

    /**
     * 批量删除基础船舶
     *
     * @param baseShipIds 基础船舶id的数组
     * @return int
     * @author 李云鹏
     * @date 2022/12/02 15:48
     */
    int deleteByBaseShipIds(@Param("baseShipIds") Long[] baseShipIds);

    /**
     * 通过id查询
     *
     * @param id 主键id
     * @return {@link Forecast }
     * @author 李云鹏
     * @date 2022/12/02 18:18
     */
    Forecast selectById(Long id);

    /**
     * TODO:暂未处理
     *
     * @param updated 更新
     * @return int
     * @author 李云鹏
     * @date 2023/02/25 17:54
     */
    int updateById(@Param("updated") Forecast updated);

}