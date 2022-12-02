package com.boat.controller;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.bind.annotation.*;

import com.boat.entity.Delegation;
import com.boat.service.DelegationService;
import com.boat.utils.Result;
import com.github.pagehelper.PageInfo;

/**
 * @author 李云鹏
 * @version 1.0
 * @date 2022/11/16 10:39
 */

@RestController
@RequestMapping("/delegation")
@CrossOrigin
public class DelegationController {
    @Resource
    private DelegationService delegationService;

    @PostMapping("/list")
    public PageInfo<Delegation> getAllList(@Param("page") int page, @Param("pageSize") int pageSize,
        @RequestBody Delegation delegation) {
        return this.delegationService.findByAllExceptCreateTimeAndUpdateTimeWithPage(page, pageSize, delegation);
    }

    @GetMapping("/selectById/{id}")
    public Result<Delegation> selectById(@PathVariable Long id) {
        return this.delegationService.selectByPrimaryKey(id);
    }

    @PostMapping("/insertOrUpdate")
    public Result<T> insertOrUpdate(@RequestBody Delegation delegation) {
        return this.delegationService.insertOrUpdate(delegation);
    }

    @DeleteMapping("/delete/{ids}")
    public Result<T> deleteByIds(@PathVariable Long[] ids) {
        return this.delegationService.deleteByPrimaryKeys(ids);
    }
}
