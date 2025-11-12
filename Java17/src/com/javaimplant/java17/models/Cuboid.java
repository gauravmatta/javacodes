package com.javaimplant.java17.models;

public class Cuboid extends BaseShape{
    private int len;
    private int hght;
    @Override
    public void paintMe() {
        System.out.println("Iam about to start drawing a cuboid len"+len+" height"+hght);
        try {
            Thread.sleep(5000);
            System.out.println("Finished Drawing Cuboid");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public int getLen() {
        return len;
    }
    public void setLen(int len) {
        this.len = len;
    }
    public int getHght() {
        return hght;
    }
    public void setHght(int hght) {
        this.hght = hght;
    }
}
