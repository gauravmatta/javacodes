
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gaurav Matta
 */
public class Area {
    
    final float PIE=3.14f;
//    public String greet="Hi";
//    public char me='H';
    
    
    private float CircleArea(int diameter)
    {
        float radius=diameter/2;
        float area=this.PIE*radius*radius;
        return area;
    }
    
    public static void main(String args[])
    {
       Area a=new Area();
       int count=args.length;
       if(count==1)
       {
            System.out.println("I believe this is diameter of circle");
            float area = a.CircleArea(Integer.parseInt(args[0]));
            System.out.println("Area is :"+area);
       }
       else if(count==2)
       {
           System.out.println("I could not build a figure with 2 sides");
       }
       else if(count==3)
       {
           System.out.println("Assuming that's a right Triangle");
           Arrays.sort(args);
           float area=(Integer.parseInt(args[0])*Integer.parseInt(args[1]))/2;
           System.out.println("Area is :"+area);
       }
       else if(count==4)
       {
           Arrays.sort(args);   
           if((Integer.parseInt(args[0])==Integer.parseInt(args[1])) &&(Integer.parseInt(args[0])==Integer.parseInt(args[3])))
           {
                System.out.println("That's a Square");
                float area=Integer.parseInt(args[0])*Integer.parseInt(args[1]);
                System.out.println("Area is :"+area);
           }
           else if((Integer.parseInt(args[0])==Integer.parseInt(args[1])) &&(Integer.parseInt(args[2])==Integer.parseInt(args[3])))
           {
                System.out.println("That's a Rectngle");  
                float area=Integer.parseInt(args[0])*Integer.parseInt(args[2]);
                System.out.println("Area is :"+area);
           }
           else
           {
               System.out.println("That's a Trapzoid(currently not supported)");
           }
           
       }
       else if(count==5)
       {
           if((Integer.parseInt(args[0])==Integer.parseInt(args[1])) && (Integer.parseInt(args[0])==Integer.parseInt(args[3])))
           {
               if (Integer.parseInt(args[3])==Integer.parseInt(args[4])) {
                   System.out.println("That's a Pentagon");
                   double area = (Integer.parseInt(args[0])*Integer.parseInt(args[1]))*(Math.sqrt(5*(5+(2*Math.sqrt(5)))))/4;
                   System.out.println("Area is :"+area);
               }
           }
       }
       else if(count==6)
       {
           if((Integer.parseInt(args[0])==Integer.parseInt(args[1])) && (Integer.parseInt(args[0])==Integer.parseInt(args[3])))
           {
               if ((Integer.parseInt(args[3])==Integer.parseInt(args[4])) && (Integer.parseInt(args[4])==Integer.parseInt(args[5]))) 
               {
                   System.out.println("That's a Hexagon");
                   double area = (Integer.parseInt(args[0])*Integer.parseInt(args[1]))*(3*Math.sqrt(3))/2;
                   System.out.println("Area is :"+area);
               }
           }
       }
       else if(count==7)
       {
           System.out.println("That's a Heptagon");
       }
       else if(count==8)
       {
           System.out.println("That's a Octagon");
       }
       else if(count==9)
       {
           System.out.println("That's a Nonagon");
       }
       else if(count==10)
       {
           System.out.println("That's a Decagon");
       }
    }
}
