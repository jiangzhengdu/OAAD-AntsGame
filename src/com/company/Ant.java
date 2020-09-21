package com.company;

public class Ant {
    public static int count;
    private final int id = (count++)%5 ;
    private int direction;
    private int position;
    private int speed;
    private boolean isAlive;

    Ant(int direction, int position, int speed) {
        this.direction = direction;
        this.position = position;
        this.speed = speed;
        isAlive = true;
    }

    public void Move(){ //0:left 1:right
        if(direction == 1)
            position += speed;
        else position -= speed;
    }

    public void TurnAround(){
        direction = (direction+1)%2;
    }

    public int getPosition() { return position;}

    public void setIsAlive(){ isAlive = false; }

    public boolean getIsAlive() { return isAlive;}

    public void ifAlive(Ant ant) {
        if (ant.getPosition() <= Pole.getSTART() || ant.getPosition() >= Pole.getEND()) {
            Pole.setAliveAnt();
            ant.setIsAlive();
        }
    }
    /*public void printAnts() {
        System.out.println("id = " + id);
        System.out.println("direction = " + direction);
        System.out.println("position = " + position);
        System.out.println("speed = " + speed);
    }*/
}
