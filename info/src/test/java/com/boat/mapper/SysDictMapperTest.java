package com.boat.mapper;

import java.util.*;

/**
 * @author 李云鹏
 * @version 1.0
 * @date 2022/11/9 11:50
 */

public class SysDictMapperTest {
    public static void main(String[] args) {
        List<Map<String, String>> mapList = new ArrayList();
        Map<String, String> map = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        map.put("name", "张三");
        map.put("height", "1.65");
        map2.put("name", "李斯");
        map2.put("height", "1.78");
        mapList.add(map);
        mapList.add(map2);
        List<Map<String, String>> mapList1 = new ArrayList();
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map3 = new HashMap<>();
        map1.put("age", "23");
        map3.put("address", "aaaaa");
        mapList1.add(map1);
        mapList1.add(map3);
        System.out.println(mapList);
        System.out.println(mapList1);

        for (int i = 0; i < mapList.size(); i++) {
            for (int j = 0; j < mapList1.size(); j++) {
                Map<String, String> map5 = mapList1.get(j);
                Map<String, String> map6 = mapList.get(i);
                if (i == j) {
                    Set<Map.Entry<String, String>> entries = map5.entrySet();
                    for (Map.Entry<String, String> entry : entries) {
                        map6.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
        System.out.println(mapList);
    }
}
