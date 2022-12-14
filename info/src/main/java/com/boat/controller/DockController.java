package com.boat.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.bind.annotation.*;

import com.boat.entity.Dock;
import com.boat.entity.Port;
import com.boat.service.DockService;
import com.boat.utils.Result;
import com.boat.utils.Status;

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
    public List<?> selectAllByPage(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize,
        @RequestBody Dock dock) {

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

    @DeleteMapping("/delete/{ids}")
    public Result<T> deleteByIds(@PathVariable("ids") Long[] ids) {
        int i = this.dockService.deleteByIds(ids);
        if (i > 0) {
            return Result.buildR(Status.OK, "删除成功");
        } else {
            return Result.buildR(Status.SYSTEM_ERROR, "删除失败");
        }

    }

    @GetMapping("/list")
    public Result<List<Dock>> getDockList() {
        return this.dockService.selectAll();
    }

    @GetMapping("/portList")
    public Result<List<Port>> getPortListByDockId(@RequestParam("dockId") Long dockId) {
        return this.dockService.selectByDockId(dockId);
    }
}
