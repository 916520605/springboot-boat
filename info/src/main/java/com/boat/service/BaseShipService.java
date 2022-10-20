package com.boat.service;

import com.boat.entity.Nationality;

import com.boat.mapper.WordportMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.boat.entity.BaseShip;
import com.boat.entity.Wordport;
import com.boat.mapper.NationalityMapper;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.boat.mapper.BaseShipMapper;

import java.util.List;

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

    
    public int deleteByPrimaryKey(Long id) {
        return baseShipMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(BaseShip record) {
        return baseShipMapper.insert(record);
    }

    
    public int insertSelective(BaseShip record) {
        return baseShipMapper.insertSelective(record);
    }

    
    public BaseShip selectByPrimaryKey(Long id) {
        return baseShipMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(BaseShip record) {
        return baseShipMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(BaseShip record) {
        return baseShipMapper.updateByPrimaryKey(record);
    }

    /**
     * 模糊查询和展示所有分页列表数据
     * @param pageNum 页码
     * @param pageSize 每页展示多少条数据
     * @param baseShip 对象
     * @return
     */

    public PageInfo<BaseShip> findAll(Integer pageNum, Integer pageSize,BaseShip baseShip){
        PageHelper.startPage(pageNum, pageSize);
        List<BaseShip> allBYAll = baseShipMapper.findAllBYAll(baseShip);
        List<Nationality> nationalityList = nationalityMapper.findAll();
        List<Wordport> wordports = wordportMapper.selectAll();
        for (BaseShip item : allBYAll){
            for (Nationality item2 : nationalityList){
                if (item.getNationality()!=null){
                    if (item.getNationality().equals(item2.getLetterCode())){
                        item.setNationality(item2.getCountryName());
                    }
                }
            }
            for (Wordport item3 : wordports){
                if (item.getHomePort()!=null){
                    if (item.getHomePort().equals(item3.getPortCode())){
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
     *
     * @param ids 批量删除
     * @return
     */
    public int deleteByIds(Long[] ids){
        return baseShipMapper.deleteByIds(ids);

    }

    /**
     *检查imo号的唯一性
     * @param imo
     * @return
     */
    public BaseShip  checkImoUnique(String imo){
        return baseShipMapper.selectByImo(imo);

    }

    public BaseShip selectAllByImoAndNotId(Long id,String imo){
        return baseShipMapper.selectAllByImoAndNotId(id,imo);
    }
    /**
     *
     * 修改，根据传过来的id参数查询该条数据，拿到得到的对象的imo和传过来的imo对比，如果一样则不进行操作
     * 不一样，则判断传过来的imo号在除了该id下，是否有相同，有则给提示
     * 该方法和新增中的方法一样，都是用来保证imo号在系统中的唯一性。     9.25
     * @param id
     * @param imo
     * @return
     */
    public BaseShip getObject(Long id,String imo){
        BaseShip baseShip = selectByPrimaryKey(id);
        String imo1 = baseShip.getImo();
        if (imo1!=null){
            boolean equals = imo1.equals(imo);
            if (!equals){
                return    selectAllByImoAndNotId(id,imo);
            }else {
                return baseShip;
            }
        }else {
            return selectAllByImoAndNotId(id,imo);
        }

    }
}
