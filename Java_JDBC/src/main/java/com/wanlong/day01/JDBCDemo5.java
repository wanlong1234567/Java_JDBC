package com.wanlong.day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * 指定DQL语句
 *
 * @author wanlong
 * Date:
 */
public class JDBCDemo5 {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@192.168.201.205:1521:orcl",
                    "openlab",
                    "open123"
            );
            System.out.println("已建立连接!");
            Statement state = conn.createStatement();
            /**
             * SELECT id,username,password,nickname,account
             * FROM userinfo_xxx
             */
            String sql = "SELECT id,username,password,nickname,account "
                    + "FROM userinfo";

            ResultSet rs = state.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String nickname = rs.getString("nickname");
                int account = rs.getInt("account");
                System.out.println(id+","+username+","+password+","+nickname+","+account);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
