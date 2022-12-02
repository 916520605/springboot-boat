package com.boat.service;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.boat.entity.TugCompany;
import com.boat.mapper.TugCompanyMapper;
import com.boat.mapper.TugMapper;
import com.boat.utils.Result;
import com.boat.utils.Status;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author 李云鹏
 * @date 2022/10/30 5:55
 * @version 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TugCompanyService {
    @Resource
    private TugCompanyMapper tugCompanyMapper;
    @Resource
    private TugMapper tugMapper;

    public PageInfo<TugCompany> selectAllCompanyWithPage(int page, int pageSize, TugCompany tugCompany) {
        PageHelper.startPage(page, pageSize);
        return new PageInfo<>(this.tugCompanyMapper.selectAllCompany(tugCompany));
    }

    public Result<T> insertOrUpdate(TugCompany tugCompany) {
        if (tugCompany.getTugCompanyId() == null) {
            int insert = this.tugCompanyMapper.insert(tugCompany);
            return insert > 0 ? Result.buildR(Status.OK, "新增成功") : Result.buildR(Status.SYSTEM_ERROR, "新增失败");
        } else {
            int update = this.tugCompanyMapper.updateByPrimaryKey(tugCompany);
            return update > 0 ? Result.buildR(Status.OK, "更新成功") : Result.buildR(Status.SYSTEM_ERROR, "更新失败");
        }

    }

    /**
     * 删除 此删除涉及事务。因为没有外键，删除公司的同时应该删除该公司名下的拖轮。注意回滚。待会做（1/1） 在tug表里如果没有该公司的id，每次都会去tug里查询一遍，影响效率？ 需要再添加一个索引。
     * 
     * @param id id 公司id
     * @return {@link Result }<{@link T }>
     * @author 李云鹏
     * @date 2022/11/03
     */
    public Result<T> delete(Long id) {
        int i = this.tugCompanyMapper.deleteByPrimaryKey(id);
        int i1 = this.tugMapper.deleteByCompanyId(id);
        return i + i1 > 0 ? Result.buildR(Status.OK, Status.OK.getMessage())
            : Result.buildR(Status.SYSTEM_ERROR, Status.SYSTEM_ERROR.getMessage());
    }

    public Result<TugCompany> selectByCompanyId(Long id) {
        TugCompany tugCompany = this.tugCompanyMapper.selectByPrimaryKey(id);
        return ObjectUtils.isEmpty(tugCompany) ? Result.buildR(Status.SYSTEM_ERROR)
            : Result.buildR(Status.OK, tugCompany);
    }
}
