package com.boat.service;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.boat.entity.BaseShip;
import com.boat.entity.Forecast;
import com.boat.mapper.BaseShipMapper;
import com.boat.mapper.ForecastMapper;
import com.boat.utils.Result;
import com.boat.utils.Status;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author 李云鹏
 * @date 2022/11/22 8:10
 * @version 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ForecastService {

    @Resource
    private ForecastMapper forecastMapper;
    @Resource
    private BaseShipMapper baseShipMapper;

    public Result<T> insertSelective(Forecast forecast) {
        int i = this.forecastMapper.insertSelective(forecast);
        return i > 0 ? Result.buildR(Status.OK, "添加成功") : Result.buildR(Status.SYSTEM_ERROR, "添加失败");
    }

    public Result<PageInfo<Forecast>> findAllBySearch(int pageNum, int pageSize, Forecast forecast) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Forecast> forecastPageInfo = new PageInfo<>(this.forecastMapper.findAllByAll(forecast));
        return Result.buildR(Status.OK, "查询成功", forecastPageInfo);
    }

    public Result<PageInfo<BaseShip>> selectAllNotInIds(int pageNum, int pageSize, BaseShip baseShip) {
        PageHelper.startPage(pageNum, pageSize);
        return Result.buildR(Status.OK, "查询成功", new PageInfo<>(this.forecastMapper.selectBySearchNotInIds(baseShip)));
    }

    public Result<T> updateByPrimaryKeySelective(BaseShip record) {
        int update = this.baseShipMapper.updateByPrimaryKeySelective(record);
        String shipName = record.getShipName();
        String imo = record.getImo();
        Long id = record.getId();
        Long aLong = this.forecastMapper.selectBaseShipIdByBaseShipId(id);
        if (aLong != null) {
            Forecast forecast = new Forecast();
            forecast.setShipName(shipName);
            forecast.setImo(imo);
            forecast.setBaseShipId(id);
            int update1 = this.forecastMapper.updateByBaseShipId(forecast);
            return update + update1 > 1 ? Result.buildR(Status.OK, "联表更新成功")
                : Result.buildR(Status.SYSTEM_ERROR, "联表更新失败");
        }
        return update > 0 ? Result.buildR(Status.OK, "更新单表成功") : Result.buildR(Status.SYSTEM_ERROR, "更新单表失败");
    }

    /**
     * 根据基础船舶id删除。如果在基础船舶中删除某个或多个基础船舶，那么也应该同时删除在预抵船舶表中的船舶
     * 
     * @param ids 基础船舶id
     * @return
     */
    public Result<T> deleteByBaseShipIds(Long[] ids) {
        // i必须>0,表示删除基础船舶成功
        int i = this.baseShipMapper.deleteByIds(ids);
        // i1可以为0，可以>0。如果i1=0,表示只删除了基础船舶，未删除预抵船舶。i1>0,表示删了基础船舶的同时，删除了预抵船舶
        int i1 = this.forecastMapper.deleteByBaseShipIds(ids);
        if (i > 0) {
            if (i1 == 0) {
                return Result.buildR(Status.OK, "单表删除成功");
            } else if (i1 > 0) {
                return Result.buildR(Status.OK, "联表删除成功");
            } else {
                return Result.buildR(Status.SYSTEM_ERROR, "联表删除失败");
            }
        } else {
            return Result.buildR(Status.SYSTEM_ERROR, "删除失败");
        }
    }

    public Result<Forecast> findByBaseShipId(Long id) {
        Forecast forecast = this.forecastMapper.selectById(id);
        return ObjectUtils.isEmpty(forecast) ? Result.buildR(Status.SYSTEM_ERROR, "查无此数据")
            : Result.buildR(Status.OK, "查询成功", forecast);
    }
}
