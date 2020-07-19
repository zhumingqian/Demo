package com.zmq;

import java.util.Scanner;

/**
 * @Author ZhuMingQ
 * 2020/6/19 20:48
 */
public class People {
    Scanner input = new Scanner(System.in);
    String name="";
    int getActPeo;

    public void actionPer(){
        System.out.println("请输入游戏名：");
        name= input.next();
    }

    public void actPeo(){
        getActPeo = input.nextInt();
//        return getActPeo;
    }
}
