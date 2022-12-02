package com.boat.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.bind.annotation.*;

import com.boat.entity.Tug;
import com.boat.service.TugService;
import com.boat.utils.Result;

/**
 * @author 李云鹏
 * @version 1.0
 * @date 2022/11/1 6:05
 */
@RestController
@CrossOrigin
@RequestMapping("/tug")
public class TugController {
    @Resource
    private TugService tugService;

    @GetMapping("/list/{tugCompanyId}")
    public Result<List<Tug>> selectByCompanyId(@PathVariable Long tugCompanyId) {
        return this.tugService.selectAllByCompanyId(tugCompanyId);
    }

    @DeleteMapping("/delete")
    public Result<T> deleteById(@Param("tugId") Long tugId) {
        return this.tugService.deleteByPrimaryKey(tugId);
    }

    @PostMapping("/updateOrAdd")
    public Result<T> updateOrAdd(@RequestBody Tug tug) {
        return this.tugService.insertOrUpdateTug(tug);
    }

    @GetMapping("/selectByTugId")
    public Result<Tug> selectByTugId(@Param("tugId") Long tugId) {
        return this.tugService.selectByPrimaryKey(tugId);
    }
}
