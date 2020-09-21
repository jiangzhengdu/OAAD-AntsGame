package com.company;
/* 蚂蚁类*/
public class Ant {
    public static int count;
    //  private final int id = (count++)%5 ;
    private int direction;
    private int position;
    private int speed;
    private boolean State;    // true is on the pole   false is out the pole

    Ant(int direction, int position, int speed, int length) {
        this.direction = direction;
        this.position = position;
        this.speed = speed;
        this.State = ifOnPole(position, length);

    }

    public void Move() { //0:left 1:right
        if (direction == 1)
            position += speed;
        else position -= speed;
    }

    //    public void Move(int meetPoint){
//
//        if(direction==1)
//            position=meetPoint-(speed-(meetPoint-position));
//        else
//            position=meetPoint+(speed-(position-meetPoint));
//
//    }
    public void TurnAround() {
        direction = (direction + 1) % 2;
    }

    public int getPosition() {
        return position;
    }

    public void setStateOut() {
        State = false;
    }

    public void setStateOn() {
        State = true;
    }

    public boolean getState() {
        return State;
    }

    public void setState(Ant ant) {
        if (ant.getPosition() <= Pole.getSTART() || ant.getPosition() >= Pole.getLENGTH()) {
            Pole.setAntOnNumber();
            ant.setStateOut();
        }
        else
            ant.setStateOn();

    }

    public boolean ifOnPole(int position, int length) {

        if (position <= 0 || position >= length)
            return false;
            return true;
    }
}
   /* public void printAnts() {
        System.out.println("id = " + id);
        System.out.println("direction = " + direction);
        System.out.println("position = " + position);
        System.out.println("speed = " + speed);
    }

    */

