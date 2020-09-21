package com.company;

import java.math.*;
import java.util.Scanner;

public class PlayRoom {

    public static void main(String[] args) {
      /*  int antsNum = 5;
        int[] allDirection = new int[antsNum]; //0:left 1:right
        int[] allPostion = {30,80,110,160,250};
        int allSpeed = 5;*/

      //UI
        System.out.println("*********Welcome to paly the game of CreepingAnts*********");
        System.out.println("\n>> And now, you need to enter some initialize imformation");
        System.out.println("                 The lenght of pole is 300");
        System.out.println("----------------------------------------------------------");
        System.out.println(">> Please enter the number of ants: ");
        Scanner scanner = new Scanner(System.in);
        int antsNum = scanner.nextInt();
        int[] allDirection = new int[antsNum]; //0:left 1:right
        int[] allPostion = new int[antsNum];
        int allSpeed;

        System.out.println(">> Please enter the position of each ant: ");
        for ( int i = 0; i < antsNum; i++){
            allPostion[i] = scanner.nextInt();
        }
        System.out.println(">> Please enter the speed of ants");
        allSpeed = scanner.nextInt();

        int times = (int)Math.pow(2,antsNum);
        int[] time = new int[times];
        PlayRoom playRoom = new PlayRoom();

      // 开始游戏
        for (int i = 0; i < Math.pow(2,antsNum); i++){
            initDirection(i, allDirection);
            CreepingGame creepingGame = new CreepingGame(antsNum,allDirection,allPostion,allSpeed);
            time[i] = creepingGame.playGame();
        }
        playRoom.printMaxTime(time);
        playRoom.printMinTime(time);
        System.out.println("\n***************** game over ******************");

    }

    public void printMaxTime(int[] time){
        int maxTime = time[0];
        for (int i = 1; i < time.length; i++){
            if(time[i] > maxTime)
                maxTime = time[i];
        }
        System.out.println("maxTime = " + maxTime);
    }

    public void printMinTime(int[] time){
        int minTime = time[0];
        for (int i = 1; i < time.length; i++){
            if (time[i] < minTime)
                minTime = time[i];
        }
        System.out.println("minTime = " + minTime);
    }

    public static void initDirection(int i, int[] allDirection){
        int j = 0;
        do{
            allDirection[j] = i%2;
            j++;
            i /=2;
        }while (i != 0);
    }
}
