package com.boat.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.*;

import com.boat.entity.Dock;
import com.boat.entity.Port;
import com.boat.service.DockService;

/**
 * @Author 李云鹏
 * @Date 2022/10/14 3:38
 * @Version 1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/dock")
public class DockController {
    @Resource
    private DockService dockService;

    @PostMapping("/list/{pageNum}/{pageSize}")
    public List<Map<String, Object>> selectAllByPage(@PathVariable("pageNum") Integer pageNum,
        @PathVariable("pageSize") Integer pageSize, @RequestBody Dock dock) {

        return this.dockService.selectDockAndPortWithPage(pageNum, pageSize, dock);
    }

    @GetMapping("/{id}")
    public Map<String, Object> findById(@PathVariable("id") Long id) {
        return this.dockService.findById(id);
    }

    @GetMapping("/unique/{dockCode}")
    public Dock checkDockCodeUnique(@PathVariable("dockCode") String dockCode) {
        return this.dockService.checkDockCodeIfUnique(dockCode);
    }

    @PostMapping("/updateOrAdd")
    public int insertOrUpdate(@RequestBody Map<String, Object> map) {
        return this.dockService.insertOrUpdate(map);
    }

    @GetMapping("/uniqueP/{portCode}")
    public Port checkPortCodeUnique(@PathVariable("portCode") String portCode) {
        return this.dockService.checkPortCodeUnique(portCode);
    }

    @PostMapping("/addAtUpdate")
    public int insert(@RequestBody Port port) {
        return this.dockService.addPort(port);
    }

}
