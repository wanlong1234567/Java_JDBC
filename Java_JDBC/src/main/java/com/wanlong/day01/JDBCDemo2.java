package com.wanlong.day01;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
/**
 * 创建序列 seq_userinfo_id_xxxx
 * 从1开始，步进为1
 *
 * @author wanlong
 * Date:2018/5/28
 * @since JDK1.8
 * @version 1.0
 */
public class JDBCDemo2 {
    public static void main(String[] args) {
        try {
            /**
             * 1 加载驱动包
             * 不同的数据库，参数值不一样。
             */
            Class.forName("oracle.jdbc.driver.OracleDriver");
            /**
             * 2 建立连接
             * 数据库地址不同的数据库格式不一样
             */
            Connection conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@192.168.201.205:1521:orcl",//数据库的地址
                    "openlab",//数据库的用户名
                    "open123" //数据库的密码
            );
            System.out.println("已建立连接!");
            /**
             *	通过Connection创建用于执行SQL语句的
             *  Statement实例
             */
            Statement state = conn.createStatement();

            /**
             * 创建序列
             *
             * CREATE SEQUENCE seq_userinfo_id_xxx
             * START WITH 1
             * INCREMENT BY 1
             */
            String sql = "CREATE SEQUENCE seq_userinfo_id "+
                    "START WITH 1 "+
                    "INCREMENT BY 1 ";
            System.out.println(sql);
            state.execute(sql);
            System.out.println("序列创建完毕!");

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
