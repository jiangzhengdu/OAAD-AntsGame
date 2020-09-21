package com.company;

public class Pole {
    private static int START;
    private static int END;
    private static int aliveAnt;

    Pole(int antNum) {
        this.START = 0;
        this.END = 299;
        this.aliveAnt = antNum;
    }

    Pole(int start, int end, int antNum) {
        this.START = start;
        this.END = end;
        this.aliveAnt = antNum;
    }

    public int getAliveAnt() { return aliveAnt; }
    public static int getSTART() { return START;}
    public static int getEND() { return END;}
    public static void setAliveAnt() { aliveAnt--;}
}
