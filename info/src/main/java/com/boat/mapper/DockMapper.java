package com.boat.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.boat.entity.Dock;

/**
 * @Author 李云鹏
 * @Date 2022/10/1 0:41
 * @Version 1.0
 */
@Mapper
public interface DockMapper {
    /**
     * insert record to table
     * 
     * @param record the record
     * @return insert count
     */
    int insert(Dock record);

    /**
     * 选择码头和港口
     *
     * @param dock 码头
     * @return {@link List }<{@link Map }<{@link String }, {@link Object }>>
     * @author 李云鹏
     * @date 2022/10/14
     */
    List<Map<String, Object>> selectDockAndPort(Dock dock);

    /**
     * 根据码头id查询所有
     *
     * @param id id
     * @return {@link Map }<{@link String },{@link Object }>
     * @author 李云鹏
     * @date 2022/10/16
     */
    Map<String, Object> selectAllById(Long id);

    /**
     * 通过码头编码查询编码，旨在判断dockCode的唯一性
     *
     * @param dockCode 码头代码
     * @return {@link List }<{@link String }>
     * @author 李云鹏
     * @date 2022/10/17
     */
    Dock selectDockCodeByDockCode(@Param("dockCode") String dockCode);

    /**
     * 更新通过码头id
     *
     * @param dock 码头
     * @return int
     * @author 李云鹏
     * @date 2022/10/19
     */
    int updateByDockId(Dock dock);

    /**
     * 删除通过码头id
     *
     * @param dockId 码头id
     * @return int
     * @author 李云鹏
     * @date 2022/10/22
     */
    int deleteByDockId(@Param("dockId") Long dockId);

    /**
     * 选择所有(存入vuex中的数据)
     *
     * @return {@link List }<{@link Dock }>
     * @author 李云鹏
     * @date 2022/12/05 13:15
     */
    List<Dock> selectAll();
}