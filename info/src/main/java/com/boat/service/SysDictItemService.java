package com.boat.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.boat.entity.SysDict;
import com.boat.entity.SysDictItem;
import com.boat.mapper.SysDictItemMapper;
import com.boat.utils.Result;
import com.boat.utils.Status;

/**
 * @author 李云鹏
 * @date 2022/11/11 11:31
 * @version 1.0
 */
@Service
public class SysDictItemService {

    @Resource
    private SysDictItemMapper sysDictItemMapper;

    public Result<T> deleteByPrimaryKey(Long[] ids) {
        int i = this.sysDictItemMapper.deleteByPrimaryKey(ids);
        return i > 0 ? Result.buildR(Status.OK, "删除成功") : Result.buildR(Status.SYSTEM_ERROR, "删除成功");
    }

    public int insertSelective(SysDictItem record) {
        return this.sysDictItemMapper.insertSelective(record);
    }

    public Result<SysDictItem> selectByPrimaryKey(Long id) {
        SysDictItem sysDictItem = this.sysDictItemMapper.selectByPrimaryKey(id);
        return ObjectUtils.isEmpty(sysDictItem) ? Result.buildR(Status.SYSTEM_ERROR, "暂无数据")
            : Result.buildR(Status.OK, "查询成功", sysDictItem);
    }

    public int updateByPrimaryKeySelective(SysDictItem record) {
        return this.sysDictItemMapper.updateByPrimaryKeySelective(record);
    }

    public Result<List<SysDict>> listOfDictName() {
        List<SysDict> sysDict = this.sysDictItemMapper.selectPart();
        return Result.buildR(Status.OK, "查询成功", sysDict);
    }

    public Result<List<SysDictItem>> getAllList(SysDictItem sysDictItem) {
        List<SysDictItem> sysDictItems = this.sysDictItemMapper.selectAllByAll(sysDictItem);
        return sysDictItems.size() > 0 ? Result.buildR(Status.OK, "查询成功", sysDictItems)
            : Result.buildR(Status.SYSTEM_ERROR);
    }

    public Result<T> insertOrUpdate(SysDictItem sysDictItem) {
        Long id = sysDictItem.getId();
        if (id == null) {
            // 新增
            int insert = this.sysDictItemMapper.insertSelective(sysDictItem);
            return insert > 0 ? Result.buildR(Status.OK, "新增成功") : Result.buildR(Status.SYSTEM_ERROR, "新增失败");
        } else {
            // 修改
            int update = this.sysDictItemMapper.updateByPrimaryKeySelective(sysDictItem);
            return update > 0 ? Result.buildR(Status.OK, "修改成功") : Result.buildR(Status.SYSTEM_ERROR, "修改失败");
        }
    }

    public Result<List<SysDictItem>> selectAllWithPurposes() {
        List<SysDictItem> sysDictItems = this.sysDictItemMapper.selectAllInVuex();
        return sysDictItems.size() > 0 ? Result.buildR(Status.OK, sysDictItems)
            : Result.buildR(Status.SYSTEM_ERROR, "暂无数据");
    }

    public Result<List<SysDictItem>> selectAllShipNature() {
        List<SysDictItem> shipNatures = this.sysDictItemMapper.selectAllByType();
        if (shipNatures.size() == 0) {
            return Result.buildR(Status.SYSTEM_ERROR, "暂无数据");
        }
        return Result.buildR(Status.OK, "查询成功", shipNatures);
    }
}
