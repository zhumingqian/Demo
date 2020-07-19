import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Properties;

/**
 * 封装JDBC
 * @Author ZhuMingQ
 * 2020/7/18 12:58
 */
public class jdbc {
    private static String url="";
    private static String Driver="";
    private static String userName="";
    private static String password="";

    static{
        Properties p = new Properties();
        try {
            p.load(new FileInputStream("src/main/resources/jdbc.properties"));
            userName = p.getProperty("username");
            password = p.getProperty("password");
            url = p.getProperty("url");
            Driver = p.getProperty("Driver");

            Class.forName(Driver);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //创建连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,userName,password);
    }

    //关闭资源
    public static void close(Connection con,Statement st,ResultSet rs) {
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
