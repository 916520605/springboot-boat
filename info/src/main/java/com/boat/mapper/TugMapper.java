package com.boat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.boat.entity.Tug;

/**
 * @Author 李云鹏
 * @Date 2022/10/30 5:04
 * @Version 1.0
 */
@Mapper
public interface TugMapper {
    /**
     * delete by primary key
     * 
     * @param tugId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long tugId);

    /**
     * insert record to table
     * 
     * @param record the record
     * @return insert count
     */
    int insert(Tug record);

    /**
     * select by primary key
     * 
     * @param tugId primary key
     * @return object by primary key
     */
    Tug selectByPrimaryKey(Long tugId);

    /**
     * update record
     * 
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Tug record);

    /**
     * 选择所有由拖轮公司id
     *
     * @param tugCompanyId 拖轮公司id
     * @return {@link List }<{@link Tug }>
     * @author 李云鹏
     * @date 2022/11/01
     */
    List<Tug> selectAllByTugCompanyId(Long tugCompanyId);

    /**
     * 删除company id
     *
     * @param tugCompanyId 拖轮公司id
     * @return int
     * @author 李云鹏
     * @date 2022/11/03
     */
    int deleteByCompanyId(Long tugCompanyId);
}