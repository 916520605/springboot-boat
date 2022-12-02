package com.boat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.boat.entity.Delegation;

/**
 * @author 李云鹏
 * @date 2022/11/16 3:06
 * @version 1.0
 */
@Mapper
public interface DelegationMapper {
    /**
     * 批量删除
     * 
     * @param ids primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKeys(Long[] ids);

    /**
     * insert record to table selective
     * 
     * @param record the record
     * @return insert count
     */
    int insertSelective(Delegation record);

    /**
     * select by primary key
     * 
     * @param id primary key
     * @return object by primary key
     */
    Delegation selectByPrimaryKey(Long id);

    /**
     * update record selective
     * 
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Delegation record);

    /**
     * 根据实体类查询所有
     *
     * @param delegation 委托方
     * @return {@link List}<{@link Delegation}>
     */
    List<Delegation> findByAllExceptCreateTimeAndUpdateTime(Delegation delegation);

}