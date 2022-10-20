package com.boat.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.boat.mapper.BoatMapper;
import com.boat.entity.PreArrivalShip;

import java.util.*;

@Service
public class BoatService{

    @Autowired
    private BoatMapper boatMapper;
    public int deleteByPrimaryKey(Long id) {
        return boatMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(PreArrivalShip record) {
        return boatMapper.insert(record);
    }

    
    public int insertSelective(PreArrivalShip record) {
        return boatMapper.insertSelective(record);
    }

    
    public PreArrivalShip selectByPrimaryKey(Long id) {
        return boatMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(PreArrivalShip record) {
        return boatMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(PreArrivalShip record) {
        return boatMapper.updateByPrimaryKey(record);
    }

    public PageInfo<Map<String, Object>> getAll(Integer pageNum, Integer pageSize, PreArrivalShip boat){
        PageHelper.startPage(pageNum, pageSize);
        List<PreArrivalShip> boatList = boatMapper.selectBySearch(boat);

        Integer total = boatMapper.countBYAll(boat);

        PageInfo mapPageInfo = new PageInfo<>(boatList);
        mapPageInfo.setPageNum(pageNum);
        mapPageInfo.setPageSize(pageSize);
        // mapPageInfo.setTotal(total);
      return mapPageInfo;
    }
}
