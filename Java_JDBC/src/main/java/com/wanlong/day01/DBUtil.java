package com.wanlong.day01;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 * 数据库连接的管理类
 *
 * @author wanlong
 * Date:
 */
public class DBUtil {
    private static String driverclass;
    private static String url;
    private static String username;
    private static String password;


    static{
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("config.properties"));
            driverclass = prop.getProperty("driverclass");
            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");
            System.out.println("初始化数据库连接...");
            System.out.println(driverclass);
            System.out.println(url);
            System.out.println(username);
            System.out.println(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取一个数据库连接
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        try {
            Class.forName(driverclass);
            Connection conn = DriverManager.getConnection(
                    url,username,password);
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("驱动加载失败!");
            throw e;
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void closeConnection(Connection conn){
        try {
            if(conn != null){
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
