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
public class InterruptedSleepingThreadMain {
        /**
         * @param args
         * @throws InterruptedException
         */
        public static void main(String[] args) throws InterruptedException {
            InterruptedSleepingThread thread = new InterruptedSleepingThread();
            thread.start();
            //Giving 10 seconds to finish the job.
            Thread.sleep(10000);
            //Let me interrupt
            thread.interrupt();
        }
}
