package com.wanlong.day01;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
/**
 * 输入一个用户名，然后将该用户删除
 *
 * @author wanlong
 * Date:
 */
public class JDBCDemo4 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入用户名:");
            String username = scanner.nextLine();

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@192.168.201.205:1521:orcl",
                    "openlab",
                    "open123"
            );
            System.out.println("已建立连接!");
            Statement state = conn.createStatement();

            String sql = "DELETE FROM userinfo "
                    + "WHERE username='"+username+"'";

            int d = state.executeUpdate(sql);
            if(d>0){
                System.out.println("用户:"+username+"已删除!");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
