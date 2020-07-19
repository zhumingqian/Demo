import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * BUG:::::系统时间存入数据库变为1995.
 *
 *
 * @Author ZhuMingQ
 * 2020/7/17 18:59
 */
public class DVDManager {

    static Connection con;

    static {
        try {
            con = jdbc.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static Statement st = null;
    static ResultSet rs = null;
    /**
     * 创建存放DVD的List集合
     */
    static int id = 1;
    public void menu(){
        System.out.println("欢迎******DVD管理");
        System.out.println("(根据编号选择操作：)");
        System.out.println("1.添加DVD\n2.查看DVD\n3.删除DVD\n4.借出DVD\n5.归还DVD\n6.退  出");
        Scanner input = new Scanner(System.in);
        int cho = input.nextInt();
        switch(cho){
            case 1:add();
                break;
            case 2:queryDvd();
                break;
            case 3:delete();
                break;
            case 4:lend();
                break;
            case 5:getBack();
                break;
            case 6:System.out.println("谢谢使用！");
                    System.exit(0);
                break;
        }
        menu();
    }

    /**
     * 初始化
     */
//    public void initial(List<DVDInfo> listDvd){
//
//    }
    /**
     * 添加DVD
     */
    public void add(){
        DVDInfo di = new DVDInfo();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入DVD名：");
        String dName = input.next();
        int state = 0;
//        String stime = " ";
        try {
//            con = jdbc.getConnection();
            String sql = "insert into dvdinfo(name,state) values('"+dName+"','"+state+"')";
            st = con.createStatement();
            st.execute(sql);
            System.out.println("添加成功!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 查看DVD
     */
    public void queryDvd(){
        System.out.println("序号\t状态\t  名称 \t\t\t借出日期");
        try {
//            con=jdbc.getConnection();
            String sql = "select * from dvdinfo";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                String stt;
                String time;
                if(rs.getInt(3) == 0){
                    stt = "可借";
                }else{
                    stt = "已借出";
                }
                if(rs.getString(4) == null){
                    time = " ";
                }else{
                    time = rs.getString(4);
                }
                System.out.println(rs.getString(1)+"\t\t"+stt+"\t"+"《"+rs.getString(2)+"》"+"\t"+time);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 删除DVD
     */
    public void delete(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要删除的DVD编号:");
        int choice = input.nextInt();
        try {
//            con = jdbc.getConnection();
            String sql = "delete from dvdinfo where id="+choice;
            st = con.createStatement();
            st.executeUpdate(sql);
            System.out.println("删除成功!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 借出DVD
     */
    public void lend(){
        Scanner input = new Scanner(System.in);
        Date today = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String date = sdf.format(today);
//        java.sql.Date myDate = java.sql.Date.valueOf(date);
        System.out.println("请输入需要借的DVD编号:");
        int choice = input.nextInt();
        int state=1;
//        String sql1 = "select * from dvdinfo where id="+choice;
        try {
            st = con.createStatement();
//            rs = st.executeQuery(sql1);

            String sql2 = "update dvdinfo set state="+state+",startTime=now() where id="+choice;
            st.executeUpdate(sql2);
            System.out.println("借出成功！");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    /**
     * 归还DVD
     */
    public void getBack(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要归还的DVD序号:");
        Date today = new Date();
        int choice = input.nextInt();
        int state=0;
//        String Nowtime=new SimpleDateFormat("0000-00-00").format(new Date());//一个string类型的当前时间
//        java.sql.Date mysqldate=java.sql.Date.valueOf(Nowtime);
//        String dat=" ";
        String sql1 = "select startTime from dvdinfo where id="+choice;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql1);
            rs.next();
            int num = CalcDay(rs.getString(1),today);
            String sql2 = "update dvdinfo set state='"+state+"',startTime=null where id="+choice;
            st.executeUpdate(sql2);
            System.out.println("归还成功！共借出"+num+"天。");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 计算DVD借还天数
     */
    public int CalcDay(String lend,Date today){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date lendDat = null;
        try {
            //将字符串转为日期格式
            lendDat = sdf.parse(lend);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int day = (int)(today.getTime() - lendDat.getTime())/(1000*3600*24);
        return day;
    }
}
