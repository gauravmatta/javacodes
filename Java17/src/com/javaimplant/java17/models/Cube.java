package com.javaimplant.java17.models;

public class Cube extends BaseShape{
    private int side;
    @Override
    void paintMe() {
        System.out.println("Iam about to start drawing a cube with side "+side);
        try {
            Thread.sleep(5000);
            System.out.println("Finished Drawing Cube");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public int getSide() {
        return side;
    }
    public void setSide(int side) {
        this.side = side;
    }
}
