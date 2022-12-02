package com.boat.controller;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.bind.annotation.*;

import com.boat.entity.TugCompany;
import com.boat.service.TugCompanyService;
import com.boat.utils.Result;
import com.boat.utils.Status;
import com.github.pagehelper.PageInfo;

/**
 * @Author 李云鹏
 * @Date 2022/10/31 6:19
 * @Version 1.0
 */
@RestController
@CrossOrigin
@RequestMapping("/tugCompany")
public class TugCompanyController {

    @Resource
    private TugCompanyService tugCompanyService;

    @PostMapping("/list/{page}/{pageSize}")
    public Result<PageInfo<TugCompany>> getAll(@PathVariable("page") int page, @PathVariable("pageSize") int pageSize,
        @RequestBody TugCompany tugCompany) {
        PageInfo<TugCompany> tugCompanyPageInfo =
            this.tugCompanyService.selectAllCompanyWithPage(page, pageSize, tugCompany);
        return Result.buildR(Status.OK, "请求列表成功", tugCompanyPageInfo);
    }

    @PostMapping("/insertOrUpdate")
    public Result<T> insert(@RequestBody TugCompany tugCompany) {
        return this.tugCompanyService.insertOrUpdate(tugCompany);
    }

    @DeleteMapping("/delete")
    public Result<T> delete(@Param("tugCompanyId") Long tugCompanyId) {
        return this.tugCompanyService.delete(tugCompanyId);
    }

    @GetMapping("/selectById")
    public Result<TugCompany> selectByCompanyId(@Param("tugCompanyId") Long tugCompanyId) {
        return this.tugCompanyService.selectByCompanyId(tugCompanyId);
    }
}
