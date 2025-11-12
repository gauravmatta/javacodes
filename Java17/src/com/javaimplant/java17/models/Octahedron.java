package com.javaimplant.java17.models;

public class Octahedron extends BaseShape{
    private int side;
    @Override
    void paintMe() {
        System.out.println("Iam about to start drawing a octahedron with eight faces with side length of "+side);
        try {
            Thread.sleep(5000);
            System.out.println("Finished Drawing Octahedron with eight faces");
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
