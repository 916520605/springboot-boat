package com.boat.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.boat.entity.SysDict;
import com.boat.entity.SysDictItem;
import com.boat.mapper.SysDictItemMapper;
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
    @Resource
    private SysDictItemMapper sysDictItemMapper;

    /**
     * 批量删除，注意！这里删除字典数据的同时，需要同步删除字典项的数据，涉及事务
     * 
     * @param ids 根据主键批量删除
     * @return 受影响行数
     */
    @Transactional(rollbackFor = Exception.class)
    public Result<T> deleteByPrimaryKey(Long[] ids) {
        int i = this.sysDictMapper.deleteByPrimaryKey(ids);
        this.sysDictItemMapper.deleteByDictIdIn(ids);
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

    /**
     * 插入或更新 在更新字典数据的类型时，需要同步更新字典项里的类型，涉及事务。
     * 
     * @param sysDict sys dict类型
     * @return {@link Result }<{@link T }>
     * @author 李云鹏
     * @date 2022/12/04 11:49
     */
    @Transactional(rollbackFor = Exception.class)
    public Result<T> insertOrUpdate(SysDict sysDict) {
        Long id = sysDict.getId();
        if (id != null) {
            int update = this.sysDictMapper.updateByPrimaryKeySelective(sysDict);
            String type = sysDict.getType();
            SysDictItem sysDictItem = new SysDictItem();
            sysDictItem.setDictId(id);
            sysDictItem.setType(type);
            this.sysDictItemMapper.updateType(sysDictItem);
            return update > 0 ? Result.buildR(Status.OK, "更新成功") : Result.buildR(Status.SYSTEM_ERROR, "更新失败");
        } else {
            int insert = this.sysDictMapper.insertSelective(sysDict);
            return insert > 0 ? Result.buildR(Status.OK, "新增成功") : Result.buildR(Status.SYSTEM_ERROR, "新增失败");
        }
    }

}
