package com.boat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.boat.entity.Wordport;

/**
 * @Author 李云鹏
 * @Date 2022/9/24 2:54
 * @Version 1.0
 */
@Mapper
public interface WordportMapper {

    /**
     * 插入
     *
     * @param record 记录
     * @return int
     * @author 李云鹏
     * @date 2022/10/12
     */
    int insert(Wordport record);

    /**
     * 选择所有
     *
     * @return {@link List }<{@link Wordport }>
     * @author 李云鹏
     * @date 2022/10/12
     */
    List<Wordport> selectAll();

    /**
     * 找到所有港口代码和港口名称
     *
     * @param wordport wordport
     * @return {@link List }<{@link Wordport }>
     * @author 李云鹏
     * @date 2022/10/12
     */
    List<Wordport> findAllByPortCodeAndPortName(Wordport wordport);

    /**
     * 选择通过港口代码
     *
     * @param portCode 港口代码
     * @return {@link Wordport }
     * @author 李云鹏
     * @date 2022/10/12
     */
    Wordport selectByPortCode(String portCode);

    /**
     * 选择通过id
     *
     * @param id id
     * @return {@link Wordport }
     * @author 李云鹏
     * @date 2022/10/12
     */
    Wordport selectById(@Param("id") Long id);

    /**
     * 根据id更新
     * 
     * @param wordport 对象
     * @return 是否更新成功
     */
    int updateById(Wordport wordport);

    /**
     * 批量删除id
     *
     * @param ids id
     * @return int
     * @author 李云鹏
     * @date 2022/10/13
     */
    int deleteByIdInIds(Long[] ids);

}