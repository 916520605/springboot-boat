package com.boat.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.boat.entity.BaseShip;
import com.boat.entity.Nationality;
import com.boat.entity.Wordport;
import com.boat.mapper.BaseShipMapper;
import com.boat.mapper.NationalityMapper;
import com.boat.mapper.WordportMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @Author 李云鹏
 * @Date 2022/9/21 14:15
 * @Version 1.0
 */
@Service
public class BaseShipService {

    @Resource
    private BaseShipMapper baseShipMapper;
    @Resource
    private NationalityMapper nationalityMapper;
    @Resource
    private WordportMapper wordportMapper;

    public int insertSelective(BaseShip record) {
        return this.baseShipMapper.insertSelective(record);
    }

    public BaseShip selectByPrimaryKey(Long id) {
        return this.baseShipMapper.selectByPrimaryKey(id);
    }

    /**
     * 模糊查询和展示所有分页列表数据
     * 
     * @param pageNum 页码
     * @param pageSize 每页展示多少条数据
     * @param baseShip 对象
     * @return
     */

    public PageInfo<BaseShip> findAll(Integer pageNum, Integer pageSize, BaseShip baseShip) {
        PageHelper.startPage(pageNum, pageSize);
        List<BaseShip> allBYAll = this.baseShipMapper.findAllBYAll(baseShip);
        List<Nationality> nationalityList = this.nationalityMapper.findAll();
        List<Wordport> wordports = this.wordportMapper.selectAll();
        for (BaseShip item : allBYAll) {
            for (Nationality item2 : nationalityList) {
                if (item.getNationality() != null) {
                    if (item.getNationality().equals(item2.getLetterCode())) {
                        item.setNationality(item2.getCountryName());
                    }
                }
            }
            for (Wordport item3 : wordports) {
                if (item.getHomePort() != null) {
                    if (item.getHomePort().equals(item3.getPortCode())) {
                        item.setHomePort(item3.getPortName());
                    }
                }
            }
        }

        PageInfo<BaseShip> baseShipPageInfo = new PageInfo<>(allBYAll);
        baseShipPageInfo.setPageNum(pageNum);
        baseShipPageInfo.setPageSize(pageSize);
        return baseShipPageInfo;
    }

    /**
     * 检查imo号的唯一性
     * 
     * @param imo
     * @return
     */
    public BaseShip checkImoUnique(String imo) {
        return this.baseShipMapper.selectByImo(imo);

    }

    public BaseShip selectAllByImoAndNotId(Long id, String imo) {
        return this.baseShipMapper.selectAllByImoAndNotId(id, imo);
    }

    /**
     *
     * 修改，根据传过来的id参数查询该条数据，拿到得到的对象的imo和传过来的imo对比，如果一样则不进行操作 不一样，则判断传过来的imo号在除了该id下，是否有相同，有则给提示
     * 该方法和新增中的方法一样，都是用来保证imo号在系统中的唯一性。 9.25
     * 
     * @param id
     * @param imo
     * @return
     */
    public BaseShip getObject(Long id, String imo) {
        BaseShip baseShip = this.selectByPrimaryKey(id);
        String imo1 = baseShip.getImo();
        if (imo1 != null) {
            boolean equals = imo1.equals(imo);
            if (!equals) {
                return this.selectAllByImoAndNotId(id, imo);
            } else {
                return baseShip;
            }
        } else {
            return this.selectAllByImoAndNotId(id, imo);
        }

    }
}
