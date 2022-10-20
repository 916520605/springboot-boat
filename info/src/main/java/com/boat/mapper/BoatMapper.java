package com.boat.mapper;
import java.util.List;

import com.boat.entity.PreArrivalShip;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoatMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PreArrivalShip record);

    int insertSelective(PreArrivalShip record);

    PreArrivalShip selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PreArrivalShip record);

    int updateByPrimaryKey(PreArrivalShip record);

    //统计总共有多少条船
    Integer countBYAll(PreArrivalShip boat);
    //根据查询条件查询船舶
   List<PreArrivalShip> selectBySearch(PreArrivalShip boat);



}