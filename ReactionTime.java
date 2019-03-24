package Keener;

/**
 * Created by: Emily Keener
 * Date: 10/17/18
 * Reaction time
 */

// Import Statements
import java.util.*;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.awt.*;

// ReactionTime Class
public class ReactionTime
{
    //genLED 
   public static int genLED(){
       // Generate a random number (Finch will move up to 10 seconds)
      Random rand = new Random();
      int randomNum = rand.nextInt((4 - 1) + 1) + 1;
      
      // Multiply by 1000 for it to be in milliseconds
      int time = randomNum * 1000;
      
      // Returns the speed int
      return time;
    }
    
    public static int time(Finch myFinch, int[] array){
        // Red LED for generated time
        myFinch.setLED(255,0,0, genLED());
        
        // Green LED
        myFinch.setLED(0, 255, 0);
        
        // Begin recording time here
        Date startDate = new Date();
        
        // While loop - until the finch is pointed down, record time and LED stay green
        while(myFinch.getXAcceleration()<0){
            myFinch.setLED(0, 255, 0);
        }
        
        // Record end time
        Date endDate = new Date();  
        
        // Return time in ms
        return (int)(endDate.getTime() - startDate.getTime());
    }
    
    // Main Method
    public static void main(final String[] args)
   {
      // Instantiating the Finch object
      Finch myFinch = new Finch();
      
      // Number of records
      int rec = 10;
      
      // Array
      int[] array = new int[rec];
      
      // Sum to find mean
      int sum = 0;
      
      // For Loop for recording times
      for(int i = 0; i < rec ; i++){
        array[i] = time(myFinch, array);
        System.out.println("Time " + (i+1) + ": " + array[i]);
        sum += array[i];
      }
      
      int mean = sum / rec;
      
      System.out.println("Average reaction time: " + mean);
      
      
      // Quit Finch
      myFinch.quit();
      System.exit(0);

     }
}
