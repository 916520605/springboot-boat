package com.boat.service;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import com.boat.entity.PilotStation;
import com.boat.mapper.PilotStationMapper;
import com.boat.utils.Result;
import com.boat.utils.Status;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @Author 李云鹏
 * @Date 2022/10/26 13:56
 * @Version 1.0
 */
@Service
public class PilotStationService {

    @Resource
    private PilotStationMapper pilotStationMapper;

    public PageInfo<PilotStation> selectAllByAllWithPage(int pageNum, int pageSize, PilotStation pilotStation) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(this.pilotStationMapper.selectAllByAll(pilotStation));
    }

    public Result<T> updateOrAdd(PilotStation pilotStation) {
        if (pilotStation.getId() != null) {
            int i = this.pilotStationMapper.updateById(pilotStation);
            if (i > 0) {
                return Result.buildR(Status.OK, "更新成功啦");
            } else {
                return Result.buildR(Status.SYSTEM_ERROR, "更新失败");
            }
        } else {
            int i = this.pilotStationMapper.insert(pilotStation);
            if (i > 0) {
                return Result.buildR(Status.OK, "新增成功啦");
            } else {
                return Result.buildR(Status.SYSTEM_ERROR, "新增失败");
            }
        }

    }

    public Result<T> deleteByIds(Long[] ids) {
        int i = this.pilotStationMapper.deleteByIds(ids);
        if (i > 0) {
            return Result.buildR(Status.OK, "删除成功啦");
        } else {
            return Result.buildR(Status.SYSTEM_ERROR, "删除失败");
        }
    }
}
