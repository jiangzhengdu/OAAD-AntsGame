package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("please enter the number of ants: ");
        Scanner scanner = new Scanner(System.in);
        int antsNum = scanner.nextInt();
        int[] allDirection = new int[antsNum]; //0:left 1:right
        int[] allPostion = new int[antsNum];
        int allSpeed;

        System.out.println("please enter the position of each ant: ");
        for ( int i = 0; i < antsNum; i++){
            allPostion[i] = scanner.nextInt();
        }
        System.out.println("please enter the speed of ants");
        allSpeed = scanner.nextInt();

        System.out.println("ants:" + antsNum);
        System.out.println(Arrays.toString(allPostion));
        System.out.println("speed: " + allSpeed);
        System.out.println(Arrays.toString(allDirection));

        for (int i = 0; i < Math.pow(2,antsNum); i++) {

            initDirection(i, allDirection);
            System.out.println(Arrays.toString(allDirection));

        }

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
