package com.boat.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 李云鹏
 * @Date 2022/10/16 18:38
 * @Version 1.0
 */

public class Utils {
    /**
     * 将数据库中包含下划线的“_”，例如port_name转换为portName，接受一个List的集合，泛型是map
     *
     * @param list 列表
     * @return {@link List }<{@link Map }<{@link String },{@link Object }>> 返回值也是也list集合，泛型是map
     * @author 李云鹏
     * @date 2022/10/16
     */

    public static List<Map<String, Object>> transferList(List<Map<String, Object>> list) {
        List<Map<String, Object>> newList = new ArrayList<>(16);
        for (Map<String, Object> map : list) {
            HashMap<String, Object> newMap = new HashMap<>(16);
            for (String key : map.keySet()) {
                if (key.contains("_")) {
                    int i = key.indexOf("_");
                    String newString = key.replace("_", "");
                    StringBuffer sb = new StringBuffer(newString);
                    char c = Character.toUpperCase(newString.charAt(i));
                    sb.replace(i, i + 1, String.valueOf(c));
                    newMap.put(String.valueOf(sb), map.get(key));
                } else {
                    newMap.put(key, map.get(key));
                }
            }
            newList.add(newMap);
        }
        return newList;
    }

    public static Map<String, Object> transferMap(Map<String, Object> map) {
        Map<String, Object> newMap = new HashMap<>(16);
        for (String s : map.keySet()) {
            if (s.contains("_")) {
                int i = s.indexOf("_");
                String replace = s.replace("_", "");
                char c = Character.toUpperCase(replace.charAt(i));
                StringBuffer sb = new StringBuffer(replace);
                sb.replace(i, i + 1, String.valueOf(c));
                newMap.put(String.valueOf(sb), map.get(s));
            } else {
                newMap.put(s, map.get(s));
            }

        }
        return newMap;
    }
}
