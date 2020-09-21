package com.company;

public class Pole {
    private static int START;
    private static int OnAnt;
    private static int LENGTH;

    Pole(int antNum,int LENGTH ,Ant ant[]) {
        this.START = 0;
        this.OnAnt = iniOnAnt(ant);
        this.LENGTH=LENGTH;
    }
    public int getOnAnt() { return OnAnt; }
    public static int getSTART() { return START;}
    public static int getLENGTH() {return LENGTH;}
    public static void setAntOnNumber() { OnAnt--;}
    public int iniOnAnt(Ant ant[]){
        int onAnt=0;
        for(Ant i:ant)
        {
            if(i.getState())
                onAnt++;
        }
        return onAnt;
    }
}
