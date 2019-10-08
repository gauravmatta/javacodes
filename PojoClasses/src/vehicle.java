import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gaurav Matta
 */
public class vehicle {
    
    private int speed;
    private int noOfWheels;
    private String type;
    private int distanceRun;
    private Date serviceDate;
    private char String;
    
    public vehicle(int speed,int noOfWheels,String type,int distanceRun)
    {
        this.speed=speed;
        this.noOfWheels=noOfWheels;
        this.type=type;
        this.distanceRun=distanceRun;
        this.serviceDate=new Date();
    }
    
    public void updateDistanceRun(int distance)
    {
        this.distanceRun=distance;
    }
    
    public int checkWheelChange()
    {
        if(this.distanceRun>30000)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
    
    public int checkServiceStatus()
    {
        Date d1=this.serviceDate;
        Date d2=new Date();
        int diffInDays = (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
        if (diffInDays>365)
        {
            this.serviceDate=new Date();
            return 1;
        }
        else
        {
            return 0;
        }
    }
    
    public static void main(String args[])
    {
        vehicle v=new vehicle(180,8,"Truck",50000);
        int wheelStatus=v.checkWheelChange();
        System.out.println(wheelStatus);
    }
}
