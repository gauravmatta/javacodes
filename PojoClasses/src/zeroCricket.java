/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gaurav Matta
 */
public class zeroCricket 
{    
    private static int runs=0;
    
    public int score()
    {
        int run=(int)(6*Math.random());
        if(run==0 || run==5)
        {
            System.out.println("You are Out!");
            run=0;
        }
        else if(run==1)
        {
            System.out.println("That's a quick single");
        }
        else if(run==2)
        {
            System.out.println("You looked for a double and got it");
        }
        else if(run==3)
        {
            System.out.println("Three more added to the total");
        }
        else if(run==4)
        {
            System.out.println("Brilliant Grounded Shot That's a four");
        }
        else if(run==6)
        {
            System.out.println("That's Huge That's a six");
        }
        return run;
    }
    
    public static void main(String args[])
    {
        zeroCricket zc=new zeroCricket();
        int run=0;
        do
        {
            run=zc.score();
            runs=runs+run;
        }
        while(run!=0 && run!=5);
        System.out.println("You'r total score: "+runs);
    }
}
