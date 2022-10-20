package com.boat.service;

import com.boat.entity.Nationality;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.boat.mapper.NationalityMapper;

import java.util.List;

/**
 * @Author 李云鹏
 * @Date 2022/9/22 19:21
 * @Version 1.0
 */
@Service
public class NationalityService{

    @Resource
    private NationalityMapper nationalityMapper;

    
    public int deleteByIds(Long[] ids) {
        return nationalityMapper.deleteByIds(ids);
    }

    
    public int insert(Nationality record) {
        return nationalityMapper.insert(record);
    }

    
    public int insertSelective(Nationality record) {
        return nationalityMapper.insertSelective(record);
    }

    
    public Nationality selectByPrimaryKey(Long id) {
        return nationalityMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(Nationality record) {
        return nationalityMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Nationality record) {
        return nationalityMapper.updateByPrimaryKey(record);
    }

    public PageInfo<Nationality> findByAllOrderByNumberCodeAndLetterCodeDescwithPage(Integer pageNum, Integer pageSize, Nationality nationality) {
        PageHelper.startPage(pageNum, pageSize);
        List<Nationality> list = nationalityMapper.findByAllOrderByNumberCodeAndLetterCodeDesc(nationality);
        PageInfo<Nationality> pageInfo = new PageInfo<>(list);
        pageInfo.setPageNum(pageNum);
        pageInfo.setPageSize(pageSize);
        return pageInfo;
    }

    public List<Nationality> findAllSelected(){
      return   nationalityMapper.findAll();
    }

    public Nationality CheckUniqueByLetterCode(String letterCode){
       return nationalityMapper.selectByLetterCode(letterCode);
    }

    public Nationality CheckUniqueByNumberCode(String numberCode){
        return nationalityMapper.selectAllByNumberCode(numberCode);
    }

    public Nationality checkLetterCode( String letterCode, Long id){
        Nationality nationality = selectByPrimaryKey(id);
        String letterCode1 = nationality.getLetterCode();
        if (letterCode.equals(letterCode1)){
            return nationality;
        }else {
            return nationalityMapper.checkLetterCodeUnique(letterCode, id);
        }
    }


    public Nationality checkNumberCode(String numberCode,Long id){
        Nationality nationality = selectByPrimaryKey(id);
        String numberCode1 = nationality.getNumberCode();
        if (numberCode1.equals(numberCode)){
            return nationality;
        }else {
            return nationalityMapper.checkNumberCodeUnique(numberCode,id);
        }
    }
}
