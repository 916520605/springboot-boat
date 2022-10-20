package com.boat.controller;

import com.boat.entity.Nationality;
import com.boat.service.NationalityService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 李云鹏
 * @Date 2022/9/22 22:53
 * @Version 1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/nationality")
public class NationalityController {

    @Resource
    private NationalityService nationalityService;

    //带分页的所有列表
    @PostMapping("/list/{pageNum}/{pageSize}")
    public PageInfo<Nationality> getAllNationality(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize, @RequestBody Nationality nationality){
        return nationalityService.findByAllOrderByNumberCodeAndLetterCodeDescwithPage(pageNum,pageSize,nationality);
    }
    //不带分页的所有列表
    @PostMapping("/list")
    public List<Nationality> findAllSelected(){
        return nationalityService.findAllSelected();
    }
    //插入数据
    @PostMapping("/add")
    public  int add(@RequestBody Nationality nationality){
        return nationalityService.insert(nationality);
    }
    //根据字母编码查询单个数据
    @GetMapping("/uniqueLetterCode/{letterCode}")
    public Nationality CheckUniqueByLetterCode(@PathVariable("letterCode") String letterCode){
        return nationalityService.CheckUniqueByLetterCode(letterCode);
    }
    //根据数字编码查询单一数据
    @GetMapping("/uniqueNumberCode/{numberCode}")
    public Nationality CheckUniqueByNumberCode(@PathVariable("numberCode") String numberCode){
        return nationalityService.CheckUniqueByNumberCode(numberCode);
    }
    //根据主键回显数据
    @GetMapping("/getOne/{id}")
    public Nationality selectById(@PathVariable("id") Long id){
        return nationalityService.selectByPrimaryKey(id);
    }
    //判断修改中的字母编码的唯一性。
    @GetMapping("/checkLetterCode/{letterCode}/{id}")
    public Nationality checkLetterCode(@PathVariable("letterCode") String letterCode,@PathVariable("id") Long id){
        return nationalityService.checkLetterCode(letterCode,id);
    }
    //判断修改中的数字编码的唯一性
    @GetMapping("/checkNumberCode/{numberCode}/{id}")
    public Nationality checkNumberCode(@PathVariable("numberCode") String numberCode,@PathVariable("id") Long id){
        return nationalityService.checkNumberCode(numberCode,id);
    }

    //更新、修改国籍信息
    @PutMapping("/update")
    public int update(@RequestBody Nationality nationality){
        return nationalityService.updateByPrimaryKey(nationality);
    }
    //根据主键批量删除
    @DeleteMapping("/delete/{ids}")
    public int deleteByIds(@PathVariable Long[] ids){
        return nationalityService.deleteByIds(ids);
    }
}
