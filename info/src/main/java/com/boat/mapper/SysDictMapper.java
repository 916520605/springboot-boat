package com.boat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.boat.entity.SysDict;

/**
 * @author 李云鹏
 * @date 2022/11/8 12:12
 * @version 1.0
 */
@Mapper
public interface SysDictMapper {
    /**
     * delete by primary key
     * 
     * @param ids primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long[] ids);

    /**
     * insert record to table selective
     * 
     * @param record the record
     * @return insert count
     */
    int insertSelective(SysDict record);

    /**
     * select by primary key
     * 
     * @param id primary key
     * @return object by primary key
     */
    SysDict selectByPrimaryKey(Long id);

    /**
     * update record selective
     * 
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(SysDict record);

    /**
     * 选择所有选择性
     *
     * @param sysDict sys dict类型
     * @return {@link List }<{@link SysDict }>
     * @author 李云鹏
     * @date 2023/01/01 14:43
     */
    List<SysDict> selectAllBySelective(SysDict sysDict);
}