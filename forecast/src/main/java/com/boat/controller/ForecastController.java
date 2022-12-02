package com.boat.controller;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.bind.annotation.*;

import com.boat.entity.BaseShip;
import com.boat.entity.Forecast;
import com.boat.service.ForecastService;
import com.boat.utils.Result;
import com.github.pagehelper.PageInfo;

/**
 * @author 李云鹏
 * @version 1.0
 * @date 2022/11/22 18:18
 */

@RestController
@CrossOrigin
@RequestMapping("/forecast")
public class ForecastController {
    @Resource
    private ForecastService forecastService;

    @PostMapping("/insert")
    public Result<T> insert(@RequestBody Forecast forecast) {
        return this.forecastService.insertSelective(forecast);
    }

    @PostMapping("/list")
    public Result<PageInfo<Forecast>> findAll(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize,
        @RequestBody Forecast forecast) {
        return this.forecastService.findAllBySearch(pageNum, pageSize, forecast);
    }

    @PostMapping("/baseShipList")
    public Result<PageInfo<BaseShip>> findOtherBaseShip(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize,
        @RequestBody BaseShip baseShip) {
        return this.forecastService.selectAllNotInIds(pageNum, pageSize, baseShip);
    }

    @PutMapping("/baseShip/update")
    public Result<T> update(@RequestBody BaseShip baseShip) {
        return this.forecastService.updateByPrimaryKeySelective(baseShip);
    }

    @DeleteMapping("/baseShip/delete/{ids}")
    public Result<T> deleteByIds(@PathVariable Long[] ids) {
        return this.forecastService.deleteByBaseShipIds(ids);
    }
}
