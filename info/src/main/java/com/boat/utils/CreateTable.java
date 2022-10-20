package com.boat.utils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * @Author 李云鹏
 * @Date 2022/9/20 12:41
 * @Version 1.0
 */
public class CreateTable {
    //支持map通过K-v获取值
    private  List getClassInfo(Object o) {

        Field[] fields = o.getClass().getDeclaredFields();

        String[] fieldNames = new String[fields.length];

        List list = new ArrayList();

        Map infoMap = null;

        for (int i = 0; i < fieldNames.length; i++) {
            infoMap = new HashMap();

            infoMap.put("type", fields[i].getType().toString());

            infoMap.put("name", fields[i].getName());

            list.add(infoMap);
        }
        return list;

    }
    //获取类的属性名称
    private  String[] getClassdatatype(Object o){
        Field[] fields = o.getClass().getDeclaredFields();

        String[] fieldtypes = new String[fields.length];


        for (int i = 0; i < fieldtypes.length; i++) {
            fieldtypes[i] = fields[i].getType().toString();
        }
        return fieldtypes;
    }

    //获取类的属性类型
    private  String[] getClassdataName(Object o){
        Field[] fields = o.getClass().getDeclaredFields();

        String[] fieldNames = new String[fields.length];


        for (int i = 0; i < fieldNames.length; i++) {
            fieldNames[i] = fields[i].getName();
        }
        return fieldNames;
    }

    //自动生成sql语句
    public String createTablesql(String tablename,Object obs){
        //判断是否符合规范
        if(tablename.isEmpty()||obs==null){
            return "参数不完整";
        }
        //获得类的属性名称
        String[] name = getClassdataName(obs);
        String[] type = getClassdatatype(obs);
        String sql ="create table if not exists "+tablename+"(";
        //转换数据类型
        for(int i = 0;i<type.length;i++){
            if(type[i].equals("class java.lang.String")){
                type[i] = "varchar(255)";
            }else if (type[i].equals("class java.math.BigDecimal")){
                type[i] ="decimal";
            }else if (type[i].equals("class java.lang.Long")){
                type[i] ="bigint";
            }
        }
        for(int i = 0;i<name.length-1;i++){
            sql=sql+name[i]+" "+type[i]+",";
        }
        sql=sql+name[name.length-1]+" "+type[name.length-1]+")";

        return sql;
    }

    public static String createTable(Config config, String sql,String tablename) throws ClassNotFoundException, SQLException {
        Class.forName(config.getDriverClassName());
        String url = config.getUrl();
        String user=config.getUsername();
        String password = config.getPassword();
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement st = conn.createStatement();
        //4. 执行sql
        st.executeUpdate(sql);//创建表
        String sql1 = "select * from "+tablename;
        int res =0;
        if(st.executeQuery(sql1)!=null){
            res=1;
        }
        //5. 释放资源
        st.close();
        conn.close();
        return  res>0? "创建成功":"创建失败";
    }

    public String createTableUtils(Object obs,String tablename) throws SQLException, ClassNotFoundException {
        if(obs!=null){
            Config config = new Config();
            CreateTable con = new CreateTable();
            String sql =  con.createTablesql(tablename,obs);
            System.out.println(sql);
            System.out.println(createTable(config,sql,tablename));
        }
        return null;
    }
}
