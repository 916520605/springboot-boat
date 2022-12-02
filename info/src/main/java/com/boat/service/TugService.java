package com.boat.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.boat.entity.Tug;
import com.boat.mapper.TugMapper;
import com.boat.utils.Result;
import com.boat.utils.Status;

/**
 * @Author 李云鹏
 * @Date 2022/10/30 5:04
 * @Version 1.0
 */
@Service
public class TugService {

    @Resource
    private TugMapper tugMapper;

    public Result<T> deleteByPrimaryKey(Long tugId) {
        int i = this.tugMapper.deleteByPrimaryKey(tugId);
        return i > 0 ? Result.buildR(Status.OK) : Result.buildR(Status.SYSTEM_ERROR);
    }

    public int insert(Tug record) {
        return this.tugMapper.insert(record);
    }

    public Result<Tug> selectByPrimaryKey(Long tugId) {
        Tug tug = this.tugMapper.selectByPrimaryKey(tugId);
        return ObjectUtils.isEmpty(tug) ? Result.buildR(Status.SYSTEM_ERROR, "查无数据")
            : Result.buildR(Status.OK, "查询成功", tug);
    }

    public int updateByPrimaryKey(Tug record) {
        return this.tugMapper.updateByPrimaryKey(record);
    }

    public Result<List<Tug>> selectAllByCompanyId(Long companyId) {
        List<Tug> tugs = this.tugMapper.selectAllByTugCompanyId(companyId);
        return tugs.size() > 0 ? Result.buildR(Status.OK, Status.OK.getMessage(), tugs)
            : Result.buildR(Status.SYSTEM_ERROR, Status.SYSTEM_ERROR.getMessage());
    }

    public Result<T> insertOrUpdateTug(Tug tug) {
        if (tug.getTugId() == null) {
            // 新增
            int insert = this.tugMapper.insert(tug);
            return insert > 0 ? Result.buildR(Status.OK, "新增成功") : Result.buildR(Status.SYSTEM_ERROR, "新增失败");
        } else {
            // 修改
            int update = this.tugMapper.updateByPrimaryKey(tug);
            return update > 0 ? Result.buildR(Status.OK, "更新成功") : Result.buildR(Status.SYSTEM_ERROR, "更新失败");
        }

    }
}
