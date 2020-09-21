package com.company;


public class CreepingGame {
    private int antsNum;
    private int[] antsDirection;
    private int[] antsPosition;
    private int antsSpeed;

    CreepingGame(int antsNum, int[] antsDirection, int[] antsPosition, int antsSpeed){
        this.antsNum = antsNum;
        this.antsDirection = antsDirection;
        this.antsPosition = antsPosition;
        this.antsSpeed = antsSpeed;
    }

    public int playGame(){
        //初始化蚂蚁
        Ant[] ants = new Ant[antsNum];
        for (int i = 0; i < antsNum; i++) {
            ants[i] = new Ant(antsDirection[i], antsPosition[i], antsSpeed);
           // ants[i].printAnts();
        }
        //游戏操作
        int time = 0;
        Pole pole = new Pole(antsNum);
        while(pole.getAliveAnt()>0){
            for(Ant i : ants) {
                if(i.getIsAlive()){
                    i.Move();
                    i.ifAlive(i);
                }
            }
            ifCollision(ants);
            time++;
            //System.out.println(time);
        }

        return time;
    }

    public void ifCollision(Ant[] ants){
        for( int i = 0; i < ants.length - 1; i++){
            for( int j = i+1; j < ants.length; j++){
                if(ants[i].getPosition() == ants[j].getPosition()){
                    ants[i].TurnAround();
                    ants[j].TurnAround();
                }
            }
        }
    }
}