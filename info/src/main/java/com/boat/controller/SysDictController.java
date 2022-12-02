package com.boat.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.bind.annotation.*;

import com.boat.entity.SysDict;
import com.boat.service.SysDictService;
import com.boat.utils.Result;

/**
 * @author 李云鹏
 * @version 1.0
 * @date 2022/11/9 12:50
 */
@CrossOrigin
@RestController
@RequestMapping("/sysDict")
public class SysDictController {
    @Resource
    private SysDictService sysDictService;

    @PostMapping("/list")
    public Result<List<SysDict>> getAllBySearch(@RequestBody SysDict sysDict) {
        return this.sysDictService.getAllBySearch(sysDict);
    }

    @GetMapping("/id")
    public Result<SysDict> findById(@Param("id") Long id) {
        return this.sysDictService.selectByPrimaryKey(id);
    }

    @PostMapping("/insertOrUpdate")
    public Result<T> insertOrUpdate(@RequestBody SysDict sysDict) {
        return this.sysDictService.insertOrUpdate(sysDict);
    }

    @DeleteMapping("/delete/{ids}")
    public Result<T> deleteByIds(@PathVariable Long[] ids) {
        return this.sysDictService.deleteByPrimaryKey(ids);
    }
}
