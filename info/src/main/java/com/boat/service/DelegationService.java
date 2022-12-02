package com.boat.service;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.boat.entity.Delegation;
import com.boat.mapper.DelegationMapper;
import com.boat.utils.Result;
import com.boat.utils.Status;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author 李云鹏
 * @date 2022/11/16 3:06
 * @version 1.0
 */
@Service
public class DelegationService {

    @Resource
    private DelegationMapper delegationMapper;

    public Result<T> deleteByPrimaryKeys(Long[] ids) {
        int i = this.delegationMapper.deleteByPrimaryKeys(ids);
        return i > 0 ? Result.buildR(Status.OK, "删除成功") : Result.buildR(Status.SYSTEM_ERROR, "删除失败");
    }

    public Result<Delegation> selectByPrimaryKey(Long id) {
        Delegation delegation = this.delegationMapper.selectByPrimaryKey(id);
        return ObjectUtils.isEmpty(delegation) ? Result.buildR(Status.SYSTEM_ERROR, "暂无数据")
            : Result.buildR(Status.OK, "查询成功", delegation);
    }

    public PageInfo<Delegation> findByAllExceptCreateTimeAndUpdateTimeWithPage(int page, int pageSize,
        Delegation delegation) {
        PageHelper.startPage(page, pageSize);
        return new PageInfo<>(this.delegationMapper.findByAllExceptCreateTimeAndUpdateTime(delegation));
    }

    public Result<T> insertOrUpdate(Delegation delegation) {
        Long id = delegation.getId();
        if (id == null) {
            // 新增
            int insert = this.delegationMapper.insertSelective(delegation);
            return insert > 0 ? Result.buildR(Status.OK, "新增成功") : Result.buildR(Status.SYSTEM_ERROR, "新增失败");
        } else {
            // 修改
            int update = this.delegationMapper.updateByPrimaryKeySelective(delegation);
            return update > 0 ? Result.buildR(Status.OK, "修改成功") : Result.buildR(Status.SYSTEM_ERROR, "修改失败");
        }
    }
}
