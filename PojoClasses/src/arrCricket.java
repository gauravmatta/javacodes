
import java.util.stream.IntStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gaurav Matta
 */
public class arrCricket 
{
    private static int runs=0;
    
    public String commentry()
    {
        String [][] comments=new String[5][];
        comments[0]=new String[]{   "Bowled Him That's a big wicket",
                                    "That's in the air and Taken"};
//        String [] wickets={"Bowled Him That's a big wicket","That's in the air and Taken"};
//        comments[0]=wickets;
        return null; 
    }
    
    
    
    
    public int score()
    {
        int run=(int)(6*Math.random());
        if(run==0)
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
        else if(run==5)
        {
            System.out.println("4 Wides that's what you not want any part of the Game");
        }
        else if(run==6)
        {
            System.out.println("That's Huge It's Out of Ground That's a six");
        }
        return run;
    }
    
    public static void main(String args[])
    {
        arrCricket ac=new arrCricket();
        String []players={"RG Sharma","S Dhawan","RR Pant","SK Raina","MK Pandey","KD Karthik","V Shankar","Washington Sundar","SN Thakur","JD Unadkat","YS Chahal"};
        int score[]=new int[players.length];
        int i=0;
        for(String player:players)
        {
            System.out.println(player+" walks in");
            int run=0;
            do
            {
                run=ac.score();
                runs=runs+run;
            }while(run!=0);
            score[i++]=runs;
            System.out.println(player+" scored "+runs);
            runs=0;
        }
        System.out.println("Scorecard Today");
        i=0;
        for(String player:players)
        {
            System.out.println(player+" "+score[i++]);
        }
        System.out.println("Total Score "+IntStream.of(score).sum());
    }
}
