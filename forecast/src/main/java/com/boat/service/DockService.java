package com.boat.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boat.entity.Dock;
import com.boat.entity.Port;
import com.boat.mapper.DockMapper;
import com.boat.mapper.PortMapper;
import com.boat.util.Utils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @Author 李云鹏
 * @Date 2022/10/1 0:41
 * @Version 1.0
 */
@Service
public class DockService {

    @Resource
    private DockMapper dockMapper;
    @Resource
    private PortMapper portMapper;

    public List<Map<String, Object>> selectDockAndPortWithPage(int pageNum, int pageSize, Dock dock) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> mapList = this.dockMapper.selectDockAndPort(dock);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(mapList);
        long total = pageInfo.getTotal();
        List<Map<String, Object>> maps = Utils.transferList(pageInfo.getList());
        Map<String, Object> map = new HashMap<>(16);
        map.put("total", total);
        maps.add(map);
        return maps;

    }

    public Map<String, Object> findById(Long id) {
        Map<String, Object> stringObjectMap = this.dockMapper.selectAllById(id);
        return Utils.transferMap(stringObjectMap);
    }

    public Dock checkDockCodeIfUnique(String dockCode) {
        return this.dockMapper.selectDockCodeByDockCode(dockCode);
    }

    /**
     * 新增或更新
     *
     * @param map 地图
     * @return int
     * @author 李云鹏
     * @date 2022/10/18
     */
    @Transactional(rollbackFor = Exception.class)
    public int insertOrUpdate(Map<String, Object> map) {
        // 判断传过来的map是否包含id属性，有则是更新，没有就是新增

        boolean flag = map.containsKey("id");
        Dock dock = new Dock();
        Port port = new Port();
        if (flag) {
            dock.setDockId(Long.valueOf(map.get("dockId").toString()));
            dock.setDockName((String)map.get("dockName"));
            dock.setDockCode((String)map.get("dockCode"));
            port.setPortName((String)map.get("portName"));
            port.setPortCode((String)map.get("portCode"));
            port.setId(Long.valueOf(map.get("id").toString()));
            port.setPortDraft((String)map.get("portDraft"));
            int i = this.dockMapper.updateByDockId(dock);
            int j = this.portMapper.updateById(port);
            return i + j;
        } else {
            dock.setDockName((String)map.get("dockName"));
            dock.setDockCode((String)map.get("dockCode"));
            port.setPortName((String)map.get("portName"));
            port.setPortCode((String)map.get("portCode"));
            port.setPortDraft((String)map.get("portDraft"));
            int i = this.dockMapper.insert(dock);
            Dock dock1 = this.dockMapper.selectDockCodeByDockCode((String)map.get("dockCode"));
            Long dockId = dock1.getDockId();
            port.setDockId(dockId);
            int insert = this.portMapper.insert(port);
            return i + insert;
        }

    }

    /**
     * 检查端口代码独特
     *
     * @param portCode 港口代码
     * @return {@link Port }
     * @author 李云鹏
     * @date 2022/10/18
     */
    public Port checkPortCodeUnique(String portCode) {
        return this.portMapper.selectByPortCode(portCode);
    }

    /**
     * 在修改的页面中新增一个泊位
     *
     * @param port 港口
     * @return int
     * @author 李云鹏
     * @date 2022/10/19
     */
    public int addPort(Port port) {
        return this.portMapper.insert(port);
    }

    /**
     * 删除由ids 该方法涉及到事务异常回滚。
     * 
     * @param ids id
     * @return int
     * @author 李云鹏
     * @date 2022/10/22
     */
    @Transactional(rollbackFor = Exception.class)
    public int deleteByIds(Long[] ids) {
        List<Long> inDockIds = this.portMapper.selectByInIds(ids);
        List<Long> notInIds = this.portMapper.selectByNotInIds(ids);
        // 删码头的dockId集合
        List<Long> deleteDock = new ArrayList<>(16);

        for (Long inDockId : inDockIds) {
            boolean flag = notInIds.contains(inDockId);
            if (!flag) {
                deleteDock.add(inDockId);
            }
        }

        if (deleteDock.size() != 0) {
            // dockId集合去重
            List<Long> longList = deleteDock.stream().distinct().collect(Collectors.toList());
            for (Long i : longList) {
                this.dockMapper.deleteByDockId(i);
            }
        }
        return this.portMapper.deleteByIds(ids);

    }
}
