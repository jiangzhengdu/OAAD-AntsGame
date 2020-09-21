package com.company;

import java.math.*;
import java.util.Scanner;
import java.util.Arrays;
public class PlayRoom {

    public static void main(String[] args) {

      //Terminal UI
        System.out.println("----------------Ant Creeping game begin-------------------------");
        System.out.println("now, you need to enter some data to initialize the game");
        System.out.println("----------------------------------------------------------");
        int length=-1;
        int antsNum=0;
        Scanner scanner = new Scanner(System.in);
        while(length<antsNum) {    //the length of the pole must be larger than the number of ants ,else reenter the data
            System.out.println("the length of pole must be larger than the number of ants\n ");
            System.out.println("please enter the length of poles: ");
            length = scanner.nextInt();
            System.out.println("please enter the number of ants: ");
            scanner = new Scanner(System.in);
            antsNum = scanner.nextInt();
        }
        int[] allDirection = new int[antsNum]; //0:left 1:right
        int[] allPostion = new int[antsNum];
        int allSpeed;

        System.out.println("please enter the position of each ant: ");
        for ( int i = 0; i < antsNum; i++){
            allPostion[i] = scanner.nextInt();

        }
        System.out.println("please enter the speed of ants");
        allSpeed = scanner.nextInt();

        int times = (int)Math.pow(2,antsNum);
        int[] time = new int[times];
        PlayRoom playRoom = new PlayRoom();

      // 开始游戏
        for (int i = 0; i < Math.pow(2,antsNum); i++){
            initDirection(i, allDirection);
            CreepingGame creepingGame = new CreepingGame(antsNum,allDirection,allPostion,allSpeed,length);
            time[i] = creepingGame.playGame();
        }
        Arrays.sort(time);
        playRoom.printMaxTime(time);
        playRoom.printMinTime(time);
        System.out.println("\n------------------ game over -------------------");

    }

    public void printMaxTime(int[] time){
        System.out.println("maxTime is " + time[time.length-1]);
    }

    public void printMinTime(int[] time){
        System.out.println("minTime is " + time[0]);
    }

    public static void initDirection(int i, int[] allDirection){
        int j = 0;
        do{
            allDirection[j] = i%2;
            j++;
            i /=2;
        }while (i != 0);
    }


    //if ant_num=5  then i=2^5=2*2*2*2*2=32
    //allDirection[0]=0 j=1 i=16
}
