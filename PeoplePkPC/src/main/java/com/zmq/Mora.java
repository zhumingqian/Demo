package com.zmq;

/**
 * @Author ZhuMingQ
 * 2020/6/19 20:48
 */
public class Mora {
    Computer computer=new Computer();
    People people=new People();
    private int count_1=0;
    private int count_2=0;
    private int i=3;
    public void mainMenu(){
        System.out.println("******************************************************欢迎来到游戏界面*************************************");
        System.out.println("                                   ******************************************************");
        System.out.println("                                   **********            猜拳   开始              ********");
        System.out.println("                                   ******************************************************");

        System.out.println("");
        System.out.println("出拳规则：1.石头  2.剪刀   3.布");
        computer.actionPC();
        people.actionPer();
        System.out.println(computer.name +"   VS   "+people.name);
        do{
            System.out.println("玩家请出拳：");
            people.actPeo();
            System.out.print("人机出拳：");
            computer.act();
            rule(people.getActPeo,computer.getAct);
            i--;
        }while (i>0);
        int result = count_1-count_2;
        if(result > 0){
            System.out.println("---------------------------------");
            System.out.println("玩家"+count_1+" : "+count_2+"人机");
            System.out.println("恭喜玩家获胜！");
        }else if(result < 0){
            System.out.println("---------------------------------");
            System.out.println("人机"+count_2+" : "+count_1+"玩家");
            System.out.println("恭喜人机获胜！");
        }else {
            System.out.println("平局！");
        }
    }

    //出拳规则
    public void rule(int r,int c){

        int res = r - c;
        if(res == 0){
            System.out.println("本回合平局！");
        }else if(res == -1 || res == 2){
            count_1++;
            System.out.println("本回合玩家赢一局！");
        }else if(res == 1 || res == -2){
            count_2++;
            System.out.println("本回合人机赢一局！");
        }else{
            count_2++;
            System.out.println("出拳不合法！");
        }
    }
}
