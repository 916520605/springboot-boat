package com.boat.controller;


import com.boat.entity.PreArrivalShip;
import com.boat.service.BoatService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/boat")
public class BoatController {
    @Autowired
    BoatService boatService;
    @PostMapping("/list/{pageNum}/{pageSize}")
    public PageInfo<Map<String,Object>> getAllList(@PathVariable("pageNum") Integer pageNum , @PathVariable("pageSize")  Integer pageSize,@RequestBody PreArrivalShip boat){
        return boatService.getAll(pageNum,pageSize,boat);
    }
}
