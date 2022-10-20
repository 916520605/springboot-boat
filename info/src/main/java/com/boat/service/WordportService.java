package com.boat.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.boat.entity.Wordport;
import com.boat.mapper.WordportMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @Author 李云鹏
 * @Date 2022/9/24 2:54
 * @Version 1.0
 */
@Service
public class WordportService {

    @Resource
    private WordportMapper wordportMapper;

    public int insert(Wordport record) {
        return this.wordportMapper.insert(record);
    }

    /**
     * 查询所有的世界港口(不分页)
     * 
     * @return
     */
    public List<Wordport> getAllPort() {
        return this.wordportMapper.selectAll();
    }

    /**
     * 查询所有港口数据（分页）
     * 
     * @param pageNum 页码
     * @param pageSize 每页数据条数
     * @param wordport
     * @return
     */
    public PageInfo<Wordport> findAllByPageHelp(Integer pageNum, Integer pageSize, Wordport wordport) {
        List<Wordport> all = this.wordportMapper.findAllByPortCodeAndPortName(wordport);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Wordport> wordPortPageInfo = new PageInfo<>(all);
        wordPortPageInfo.setPageNum(pageNum);
        wordPortPageInfo.setPageSize(pageSize);
        return wordPortPageInfo;

    }

    /**
     * 检查港口编码的唯一性
     * 
     * @param portCode
     * @return
     */
    public Wordport checkPortCodeUnique(String portCode) {
        return this.wordportMapper.selectByPortCode(portCode);
    }

    /**
     * 根据id查询数据（回显数据）
     * 
     * @param id 主键
     * @return 世界港口类型
     */
    public Wordport selectById(Long id) {
        return this.wordportMapper.selectById(id);
    }

    public Wordport checkPortCodeUniqueInEdit(String portCode, Long id) {
        Wordport wordport = this.wordportMapper.selectById(id);
        String portCode1 = wordport.getPortCode();
        if (portCode != null) {
            if (portCode.equals(portCode1)) {
                return wordport;
            } else {
                return this.checkPortCodeUnique(portCode);
            }
        }
        return this.wordportMapper.selectByPortCode(null);

    }

    /**
     * 插入或更新
     *
     * @param wordport wordport
     * @return int
     * @author 李云鹏
     * @date 2022/10/12
     */
    public int insertOrUpdate(Wordport wordport) {

        if (wordport.getId() == null) {
            return this.wordportMapper.insert(wordport);
        }
        return this.wordportMapper.updateById(wordport);
    }

    /**
     * 删除由ids
     *
     * @param ids id
     * @return int
     * @author 李云鹏
     * @date 2022/10/13
     */
    public int deleteByIds(Long[] ids) {
        return this.wordportMapper.deleteByIdInIds(ids);
    }
}
