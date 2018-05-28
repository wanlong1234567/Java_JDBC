package com.wanlong.day01;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 向表中插入一条记录
 *
 * @author wanlong
 * Date:2018/5/28
 * @since JDK1.8
 * @version 1.0
 */
public class JDBCDemo3 {
    public static void main(String[] args) {
        try {
            /**
             * 要求用户输入用户名，密码，昵称
             * 将该用户存入userinfo表
             * 账户余额默认都是5000
             */
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入用户名:");
            String username = scanner.nextLine();
            System.out.println("请输入密码:");
            String password = scanner.nextLine();
            System.out.println("请输入昵称:");
            String nickname = scanner.nextLine();



            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@192.168.201.205:1521:orcl",
                    "openlab",
                    "open123"
            );
            System.out.println("已建立连接!");
            Statement state = conn.createStatement();

            /**
             *
             * INSERT INTO userinfo_xxx
             * (id,username,password,nickname,account)
             * VALUES
             * (seq_userinfo_id_xxx.NEXTVAL,'','','',5000)
             *
             */
            String sql = "INSERT INTO userinfo "
                    + "(id,username,password,nickname,account) "
                    + "VALUES "
                    + "(seq_userinfo_id.NEXTVAL,'"+username+"','"+password+"','"+nickname+"',5000)";

            int d = state.executeUpdate(sql);
            if(d>0){
                System.out.println(d+"行已插入!");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
