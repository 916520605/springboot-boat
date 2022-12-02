package com.boat.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.boat.entity.SysDict;
import com.boat.mapper.SysDictMapper;
import com.boat.utils.Result;
import com.boat.utils.Status;

/**
 * @author 李云鹏
 * @date 2022/11/8 12:12
 * @version 1.0
 */
@Service
public class SysDictService {

    @Resource
    private SysDictMapper sysDictMapper;

    public Result<T> deleteByPrimaryKey(Long[] ids) {
        int i = this.sysDictMapper.deleteByPrimaryKey(ids);
        return i > 0 ? Result.buildR(Status.OK, "删除成功") : Result.buildR(Status.SYSTEM_ERROR, "删除失败");
    }

    public Result<SysDict> selectByPrimaryKey(Long id) {
        SysDict sysDict = this.sysDictMapper.selectByPrimaryKey(id);
        return ObjectUtils.isEmpty(sysDict) ? Result.buildR("查无此数据") : Result.buildR(Status.OK, sysDict);
    }

    public Result<List<SysDict>> getAllBySearch(SysDict sysDict) {
        List<SysDict> sysDictS = this.sysDictMapper.selectAllBySelective(sysDict);
        return sysDictS.size() > 0 ? Result.buildR(Status.OK, sysDictS) : Result.buildR(Status.SYSTEM_ERROR, "查无数据");
    }

    public Result<T> insertOrUpdate(SysDict sysDict) {
        Long id = sysDict.getId();
        if (id != null) {
            int update = this.sysDictMapper.updateByPrimaryKeySelective(sysDict);
            return update > 0 ? Result.buildR(Status.OK, "更新成功") : Result.buildR(Status.SYSTEM_ERROR, "更新失败");
        } else {
            int insert = this.sysDictMapper.insertSelective(sysDict);
            return insert > 0 ? Result.buildR(Status.OK, "新增成功") : Result.buildR(Status.SYSTEM_ERROR, "新增失败");
        }
    }

}
