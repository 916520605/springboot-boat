package com.boat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.boat.entity.SysDict;
import com.boat.entity.SysDictItem;

/**
 * @author 李云鹏
 * @version 1.0
 * @date 2022/11/11 11:31
 */
@Mapper
public interface SysDictItemMapper {
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
    int insertSelective(SysDictItem record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    SysDictItem selectByPrimaryKey(Long id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(SysDictItem record);

    /**
     * 字典二级页面的字典名称下拉列表
     *
     * @return {@link List}<{@link SysDict}>
     */
    List<SysDict> selectPart();

    /**
     * 选择所有所有
     *
     * @param sysDictItem sys dict类型项
     * @return {@link List}<{@link SysDictItem}>
     */
    List<SysDictItem> selectAllByAll(SysDictItem sysDictItem);

    int updateType(SysDictItem sysDictItem);

    /**
     * 查询来港目的列表，放在vuex中
     *
     * @return {@link List }<{@link SysDictItem }>
     * @author 李云鹏
     * @date 2022/12/12 20:49
     */
    List<SysDictItem> selectAllInVuex();

    /**
     * 删除字典数据时，要同步删除字典项的所有数据
     *
     * @param dictIdCollection dict id集合
     * @return int
     * @author 李云鹏
     * @date 2023/01/31 16:54
     */
    int deleteByDictIdIn(@Param("dictIdCollection") Long[] dictIdCollection);

    /**
     * 查询所有船舶性质，放入vuex中
     *
     * 
     * @return {@link List }<{@link SysDictItem }>
     * @author 李云鹏
     * @date 2023/01/31 23:07
     */
    List<SysDictItem> selectAllByType();

}