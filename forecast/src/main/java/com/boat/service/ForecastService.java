package com.boat.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.boat.mapper.ForecastMapper;
import com.boat.entity.Forecast;

/**
 * @Author 李云鹏
 * @Date 2022/9/27 17:45
 * @Version 1.0
 */
@Service
public class ForecastService {

    @Resource
    private ForecastMapper forecastMapper;


    public int insert(Forecast record) {
        return forecastMapper.insert(record);
    }

}

