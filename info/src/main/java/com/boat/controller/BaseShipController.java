package com.boat.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.*;

import com.boat.entity.BaseShip;
import com.boat.mapper.BaseShipMapper;
import com.boat.service.BaseShipService;
import com.github.pagehelper.PageInfo;

/**
 * @Author 李云鹏
 * @Date 2022/9/21 14:43
 * @Version 1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/baseShip")
public class BaseShipController {
    @Resource
    private BaseShipService baseShipService;

    /**
     * 特殊情况特殊对待，懒得再写一个service
     */
    @Resource
    private BaseShipMapper baseShipMapper;

    @PostMapping("/list/{pageNum}/{pageSize}")
    public PageInfo<BaseShip> getAllBySearch(@PathVariable("pageNum") Integer pageNum,
        @PathVariable("pageSize") Integer pageSize, @RequestBody BaseShip baseShip) {
        return this.baseShipService.findAll(pageNum, pageSize, baseShip);
    }

    @DeleteMapping("/delete/{ids}")
    public int deleteByIds(@PathVariable Long[] ids) {
        return this.baseShipService.deleteByIds(ids);
    }

    @PostMapping("/unique")
    public BaseShip checkImoUnique(@RequestParam(value = "imo") String imo) {
        return this.baseShipService.checkImoUnique(imo);
    }

    @PostMapping("/add")
    public int addOne(@RequestBody BaseShip baseShip) {
        return this.baseShipService.insertSelective(baseShip);
    }

    @GetMapping("/{id}")
    public BaseShip getInfoById(@PathVariable("id") Long id) {
        return this.baseShipService.selectByPrimaryKey(id);
    }

    @GetMapping("/checkImo/{id}/{imo}")
    public BaseShip getObject(@PathVariable("id") Long id, @PathVariable("imo") String imo) {
        return this.baseShipService.getObject(id, imo);
    }

    @PutMapping("/update")
    public int update(@RequestBody BaseShip baseShip) {
        return this.baseShipService.updateByPrimaryKeySelective(baseShip);
    }

    @PostMapping("/list")
    public List<BaseShip> getAll(@RequestBody BaseShip baseShip) {
        return this.baseShipMapper.findAllBYAll(baseShip);
    }

}
