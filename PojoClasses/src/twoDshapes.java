/**
 *
 * @author Gaurav Matta
 */
public class twoDshapes {
    static double PIE=3.14;
    double length;
    double breadth;
    double thirdside;
    final static int[] VALUES=new int[10];
    
    //Initialization Block
    static
    {
        System.out.println("Running Initialization Block");
        for(int i=0; i<VALUES.length; i++) 
        {
            VALUES[i] = (int)(100.0*Math.random());    
        }
    }
    
    public twoDshapes(double length,double breadth,double thirdside)
    {
        this.length=length;
        this.breadth=breadth;
        this.thirdside=thirdside;
    }
    
    void listValues()
    {
        for(int value : VALUES) 
        {
            System.out.print(" "+value);
        }
    }
    
    protected double Area()
    {
        return 0;
    }
    
    public double areaTriangle()
    {
        double S=this.triangleS();
        double Area=Math.sqrt(S*(S-length)*(S-breadth)*(S-thirdside));
        return Area;
    }
    
    private void incrementSides(twoDshapes s)
    {
        s.length++;
        s.breadth++;
        s.thirdside++;
    }
    
    private double triangleS()
    {
        double s=(length+breadth+thirdside)/2;
        return s;
    }
    
    public static void main(String args[])
    {
        twoDshapes t1=new twoDshapes(20,20,10);
        t1.listValues();
        System.out.println("Incremented Sides : "+t1.length+" "+t1.breadth+" "+t1.thirdside);
        t1.incrementSides(t1);
        System.out.println("Incremented Sides : "+t1.length+" "+t1.breadth+" "+t1.thirdside);
    }
}
