package com.company;


public class CreepingGame {
    private int antsNum;
    private int[] antsDirection;
    private int[] antsPosition;
    private int antsSpeed;
    private int length;

    CreepingGame(int antsNum, int[] antsDirection, int[] antsPosition, int antsSpeed, int length){
        this.antsNum = antsNum;
        this.antsDirection = antsDirection;
        this.antsPosition = antsPosition;
        this.antsSpeed = antsSpeed;
        this.length=length;
    }

    public int playGame() {
        //初始化蚂蚁
        Ant[] ants = new Ant[antsNum];
        for (int i = 0; i < antsNum; i++) {
            ants[i] = new Ant(antsDirection[i], antsPosition[i], antsSpeed, length);

            //ants[i].printAnts();
        }
        //游戏操作
        int time = 0;
        Pole pole = new Pole(antsNum, length, ants);
        if(pole.getOnAnt() == 0) {
            return time;
        }
        else {
           // System.out.println(pole.getOnAnt());
            while (pole.getOnAnt() > 0) {
                for (Ant i : ants) {
                    if (i.getState()) {
                        i.Move();
                        i.setState(i);
                    }
                }
                IfMeet(ants);
                time++;
            }

            return time;
        }
    }

    public void IfMeet(Ant[] ants){
        for( int i = 0; i < ants.length - 1; i++){
            for( int j = i+1; j < ants.length; j++){
                if(ants[i].getPosition() ==ants[j].getPosition()){
                    ants[i].TurnAround();
                    ants[j].TurnAround();
                }
            }
        }
    }
}