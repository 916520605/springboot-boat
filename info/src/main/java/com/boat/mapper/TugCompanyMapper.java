package com.boat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.boat.entity.TugCompany;

/**
 * @Author 李云鹏
 * @Date 2022/10/30 5:43
 * @Version 1.0
 */
@Mapper
public interface TugCompanyMapper {
    /**
     * delete by primary key
     * 
     * @param tugCompanyId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long tugCompanyId);

    /**
     * insert record to table
     * 
     * @param record the record
     * @return insert count
     */
    int insert(TugCompany record);

    /**
     * select by primary key
     * 
     * @param tugCompanyId primary key
     * @return object by primary key
     */
    TugCompany selectByPrimaryKey(Long tugCompanyId);

    /**
     * update record
     * 
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(TugCompany record);

    /**
     * 选择所有公司
     *
     * @param tugCompany 拖轮公司
     * @return {@link List }<{@link TugCompany }>
     * @author 李云鹏
     * @date 2022/10/31
     */
    List<TugCompany> selectAllCompany(TugCompany tugCompany);

}