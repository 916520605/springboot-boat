package com.boat.controller;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.bind.annotation.*;

import com.boat.entity.PilotStation;
import com.boat.service.PilotStationService;
import com.boat.utils.Result;
import com.boat.utils.Status;
import com.github.pagehelper.PageInfo;

/**
 * @Author 李云鹏
 * @Date 2022/10/26 18:04
 * @Version 1.0
 */

@CrossOrigin
@RestController
@RequestMapping("/pilotStation")
public class PilotStationController {
    @Resource
    private PilotStationService pilotStationService;

    @PostMapping("/list/{pageNum}/{pageSize}")
    public Result<PageInfo<PilotStation>> getAll(@PathVariable("pageNum") int pageNum,
        @PathVariable("pageSize") int pageSize, @RequestBody PilotStation pilotStation) {
        PageInfo<PilotStation> pilotStationPageInfo =
            this.pilotStationService.selectAllByAllWithPage(pageNum, pageSize, pilotStation);
        return Result.buildR(Status.OK, "查询成功", pilotStationPageInfo);
    }

    @PutMapping("/updateOrAdd")
    public Result<T> updateOrAdd(@RequestBody PilotStation pilotStation) {
        return this.pilotStationService.updateOrAdd(pilotStation);
    }

    @DeleteMapping("/delete/{ids}")
    public Result<T> deleteByIds(@PathVariable Long[] ids) {
        return this.pilotStationService.deleteByIds(ids);
    }
}
