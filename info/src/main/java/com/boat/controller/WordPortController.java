package com.boat.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.*;

import com.boat.entity.Wordport;
import com.boat.service.WordportService;
import com.github.pagehelper.PageInfo;

/**
 * @Author 李云鹏
 * @Date 2022/9/24 14:46
 * @Version 1.0
 */

@CrossOrigin
@RestController
@RequestMapping("/wordPort")
public class WordPortController {
    @Resource
    private WordportService wordportService;

    @PostMapping("/list")
    public List<Wordport> showAllPort() {
        return this.wordportService.getAllPort();
    }

    @PostMapping("/list/{pageNum}/{pageSize}")
    public PageInfo<Wordport> getAllList(@PathVariable("pageNum") Integer pageNum,
        @PathVariable("pageSize") Integer pageSize, @RequestBody Wordport wordport) {
        return this.wordportService.findAllByPageHelp(pageNum, pageSize, wordport);
    }

    @GetMapping("/unique/{portCode}")
    public Wordport checkPortCodeUnique(@PathVariable("portCode") String portCode) {
        return this.wordportService.checkPortCodeUnique(portCode);
    }

    @GetMapping("/{id}")
    public Wordport selectById(@PathVariable("id") Long id) {
        return this.wordportService.selectById(id);
    }

    @GetMapping("/UniqueInEdit/{portCode}/{id}")
    public Wordport checkPortCodeUniqueInEdit(@PathVariable("portCode") String portCode, @PathVariable("id") Long id) {
        return this.wordportService.checkPortCodeUniqueInEdit(portCode, id);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody Wordport wordport) {
        return this.wordportService.insert(wordport);
    }

    @PostMapping("/insertOrUpdate")
    public int insertOrUpdate(@RequestBody Wordport wordport) {
        return this.wordportService.insertOrUpdate(wordport);
    }

    @DeleteMapping("/delete/{ids}")
    public int deleteByIds(@PathVariable Long[] ids) {
        return this.wordportService.deleteByIds(ids);
    }
}
