package com.boat.mapper;
import org.apache.ibatis.annotations.Param;
import com.boat.entity.Nationality;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


/**
 * @Author 李云鹏
 * @Date 2022/9/22 19:21
 * @Version 1.0
 */
@Mapper
public interface NationalityMapper {
    /**
     * delete by primary key
     * @param ids primaryKey
     * @return deleteCount
     */
   int deleteByIds(Long[] ids);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Nationality record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Nationality record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Nationality selectByPrimaryKey(Long id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Nationality record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Nationality record);


    List<Nationality> findByAllOrderByNumberCodeAndLetterCodeDesc(Nationality nationality);

    //下拉框里的所有国家
    List<Nationality> findAll();

    Nationality selectByLetterCode(@Param("letterCode")String letterCode);

    Nationality selectAllByNumberCode(@Param("numberCode")String numberCode);

   Nationality checkLetterCodeUnique(@Param("letterCode")String letterCode,@Param("id")Long id);


    Nationality checkNumberCodeUnique(@Param("numberCode")String numberCode,@Param("id")Long id);
}