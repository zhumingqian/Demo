package TestQuestion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @Author ZMQ
 * 2020/7/18
 * @since 1.8
 */
public class QuestionInfoDaoImpl extends BaseDao {
    static Connection con;
    static Statement stt;
    static ResultSet rs;
    {
        try {
            con = super.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 菜单功能
     */
    public void menu(){
        System.out.println("*****欢迎进入试题信息管理系统*****");
        System.out.print("请选择操作(1.列出所有试题信息 2.按科目查询 3.按题干模糊查询 4.添加试题 5.删除试题 6.退出系统):");
        Scanner input = new Scanner(System.in);
        try{
            int cho = input.nextInt();
            switch (cho){
                case 1 :findAll();
                    break;
                case 2 :findBySubject();
                    break;
                case 3 :findByQuest();
                    break;
                case 4 :addQuestion();
                    break;
                case 5 :deleteQuestion();
                    break;
                case 6 :
                    System.out.println("谢谢使用！");
                    System.exit(0);
                    break;
            }
        }catch (Exception e){
            System.out.println("输入不合符规则！请重新输入。");
            menu();
        }
        menu();
    }

    /**
     * 列出所有信息功能
     */
    public void findAll(){
        System.out.println();
        String sql="select questionId,question,optionA,optionB,optionC,optionD,answer from question_info";
        try {
            stt = con.createStatement();
            rs = stt.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString(1)+"."+rs.getString(2)+"()\n"+
                                                                "\tA."+rs.getString(3)+"\n"+
                                                                "\tB."+rs.getString(4)+"\n"+
                                                                "\tC."+rs.getString(5)+"\n"+
                                                                "\tD."+rs.getString(6)+"\n"+
                                                                "\t答案:"+rs.getString(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 按科目查询
     */
    public void findBySubject(){
        System.out.println();
        System.out.print("(1.Java 2.C# 3.JSP):");
        Scanner input = new Scanner(System.in);
        int cho = input.nextInt();
        String sql = "select questionId,question,optionA,optionB,optionC,optionD,answer from question_info where subject="+cho;
        try {
            stt = con.createStatement();
            rs = stt.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString(1)+"."+rs.getString(2)+"()\n"+
                        "\tA."+rs.getString(3)+"\n"+
                        "\tB."+rs.getString(4)+"\n"+
                        "\tC."+rs.getString(5)+"\n"+
                        "\tD."+rs.getString(6)+"\n"+
                        "\t答案:"+rs.getString(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 按题干模糊查询
     */
    public void findByQuest(){
        System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.print("输入题干:");
        String question = input.next();
        String sql = "select questionId,question,optionA,optionB,optionC,optionD,answer from question_info where question like '%"+question+"%'";
        try {
            stt = con.createStatement();
            rs = stt.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString(1)+"."+rs.getString(2)+"()\n"+
                        "\tA."+rs.getString(3)+"\n"+
                        "\tB."+rs.getString(4)+"\n"+
                        "\tC."+rs.getString(5)+"\n"+
                        "\tD."+rs.getString(6)+"\n"+
                        "\t答案:"+rs.getString(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 添加题目
     */
    public void addQuestion(){
        System.out.println();
        System.out.print("请输入科目(1.Java 2.C# 3.JSP):");
        Scanner input = new Scanner(System.in);
        //科目
        int sub = input.nextInt();
        input.nextLine();
        //题干
        System.out.print("请输入题干:");
        String question = input.nextLine();
        //选项A
        System.out.print("请输入选项A:");
        String opA = input.nextLine();
        //选项B
        System.out.print("请输入选项B:");
        String opB = input.nextLine();
        //选项C
        System.out.print("请输入选项C:");
        String opC = input.nextLine();
        //选项D
        System.out.print("请输入选项D:");
        String opD = input.nextLine();
        //答案
        System.out.print("请输入答案:");
        String answer = input.nextLine();
        String sql = "insert into question_info(question,optionA,optionB,optionC,optionD,subject,answer) " +
                "values('"+question+"','"+opA+"','"+opB+"','"+opC+"','"+opD+"','"+sub+"','"+answer+"')";
        try {
            stt = con.createStatement();
            if(stt.executeUpdate(sql) > 0){
                System.out.println("添加成功!");
            }else{
                System.out.println("添加失败!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 删除试题
     */
    public void deleteQuestion(){
        System.out.println();
        System.out.print("请输入需要删除的编号:");
        Scanner input = new Scanner(System.in);
        int cho = input.nextInt();
        String sql = "delete from question_info where questionId="+cho;
        try {
            stt = con.createStatement();
            if(stt.executeUpdate(sql) > 0){
                System.out.println("删除成功!");
            }else {
                System.out.println("删除失败!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
