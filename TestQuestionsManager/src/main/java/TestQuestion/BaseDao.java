package TestQuestion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 封装jdbc
 * @Author ZMQ
 * 2020/7/18
 * @since 1.8
 */
public class BaseDao {
    static String url="";
    static String username="";
    static String password="";
    static String Driver="";

    /**
     * 初始化信息
     */
    static {
        Properties pp = new Properties();
        try {
            pp.load(new FileInputStream("src"+File.separator+"main"+File.separator+"resources"+File.separator+"jdbc.properties"));
            username=pp.getProperty("username");
            password = pp.getProperty("password");
            url=pp.getProperty("url");
            Driver= pp.getProperty("Driver");
            Class.forName(Driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建链接方法
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    /**
     * 关闭数据库
     */
    public static void close(Connection con, Statement st, ResultSet rs){
        try {
            if(con != null){
                con.close();
            }if(st != null){
                st.close();
            }if(rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
