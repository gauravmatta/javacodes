package com.javaimplant.java17.main;

public class ParametrizedThreadMain extends Thread {
    private int val;
    public int getVal() {
        return val;
    }
    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public void run() {
        this.setVal(10);
        for(int j=0;j<this.val;j++){
            System.out.println(" !!!!!!"+Math.log(j));
        }
    }

    public static void main(String[] args) {
        var ptm = new ParametrizedThreadMain();
        ptm.setVal(100);
        ptm.start();
    }
}
