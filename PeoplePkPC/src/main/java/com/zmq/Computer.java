package com.zmq;

import java.util.Random;
import java.util.Scanner;

/**
 * @Author ZhuMingQ
 * 2020/6/19 20:48
 */
public class Computer {
    Scanner input = new Scanner(System.in);
    String name="";
    int getAct=0;
    public void actionPC(){
        System.out.println("请选择对方角色：1.刘备  2.关羽  3.曹操");
        int c = input.nextInt();
        switch (c){
            case 1:{
                System.out.println("您选择了刘备");
                name = "刘备";
                break;
            }
            case 2:{
                System.out.println("您选择了关羽");
                name = "关羽";
                break;
            }
            case 3:{
                System.out.println("您选择了曹操");
                name = "曹操";
                break;
            }
            default:
                System.out.println("选择错误！");
                break;
        }
    }

    public void act(){
        Random r = new Random();
        getAct= r.nextInt(3)+1;
//        return getAct;
        if(getAct == 1){
            System.out.println("石头");
        }else if(getAct == 2){
            System.out.println("剪刀");
        }else{
            System.out.println("布");
        }
    }
}
