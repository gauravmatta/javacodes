/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8.threads;

/**
 *
 * @author Gaurav Matta
 */
public class InterruptedSleepingThread extends Thread{

    @Override
    public void run() {
        doAPseudoHeavyWeightJob();
    }
    
   private void doAPseudoHeavyWeightJob()
   {
       for(int i=0;i<Integer.MAX_VALUE;i++)
       {
           System.out.println(i + " " + i*2);
           if(Thread.currentThread().isInterrupted()) 
           {
                System.out.println("Thread interrupted\n Exiting...");
                break;
           }
           else 
           {
                sleepBabySleep();
           }
       }
   }
   
   protected void sleepBabySleep() 
   {
        try 
        {
            Thread.sleep(1000);
        } 
        catch (InterruptedException e) 
        {
            Thread.currentThread().interrupt();
        }
    }
    
}
