package com.boat.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.bind.annotation.*;

import com.boat.entity.SysDict;
import com.boat.entity.SysDictItem;
import com.boat.service.SysDictItemService;
import com.boat.utils.Result;

/**
 * @author 李云鹏
 * @version 1.0
 * @date 2022/11/11 22:59
 */
@RestController
@CrossOrigin
@RequestMapping("/sysDictItem")
public class SysDictItemController {
    @Resource
    private SysDictItemService sysDictItemService;

    @GetMapping("/list")
    public Result<List<SysDict>> getAllName() {
        return this.sysDictItemService.listOfDictName();
    }

    @PostMapping("/itemList")
    public Result<List<SysDictItem>> getAllList(@RequestBody SysDictItem sysDictItem) {
        return this.sysDictItemService.getAllList(sysDictItem);
    }

    @GetMapping("/selectById/{id}")
    public Result<SysDictItem> selectById(@PathVariable Long id) {
        return this.sysDictItemService.selectByPrimaryKey(id);
    }

    @PostMapping("/insertOrUpdate")
    public Result<T> insertOrUpdate(@RequestBody SysDictItem sysDictItem) {
        return this.sysDictItemService.insertOrUpdate(sysDictItem);
    }

    @DeleteMapping("/delete/{ids}")
    public Result<T> deleteByIds(@PathVariable Long[] ids) {
        return this.sysDictItemService.deleteByPrimaryKey(ids);
    }

    @GetMapping("/select")
    public Result<List<SysDictItem>> getPurposeList() {
        return this.sysDictItemService.selectAllWithPurposes();
    }
}
