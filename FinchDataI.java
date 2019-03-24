package Keener;

/**
 * Created by: Emily Keener
 * Date: 10/9/18
 * Finch collects light data
 */

import java.util.*;
import java.lang.*;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.awt.Color;
public class FinchDataI
{
    public static void main(final String[] args)
   {
      // Instantiating the Finch object
      Finch myFinch = new Finch();
      
	  // Number of data collection spots
      int spots = 5;
      
	  // Data arrays for left and right sensors
      int[] leftData = new int[spots];
      int[] rightData = new int[spots];
	  
	  // Sum array
      int[] sum = new int[spots];
      
      // Record pattern control
      for(int i = 0; i<spots;i++){
          myFinch.setWheelVelocities(100, 100, 1000);
          myFinch.setLED(255,0,0);
          leftData[i] = myFinch.getLeftLightSensor(); 
          rightData[i] = myFinch.getRightLightSensor();
          sum[i] = leftData[i] + rightData[i];    
          System.out.println((i+1) + ". Left value: " + leftData[i] + " | Right value: " + rightData[i]);
        }
        
      // Get brightest spot  
      int bright = 0;
      int brightIndex = 0;
      
      // Get darkest spot  
      int dark = 300;  
      int darkIndex = 0;
      
	  // Sort light data
      for(int i=0; i<spots; i++){
          if(leftData[i] > rightData[i]){
              if (leftData[i] > bright){
                  bright = leftData[i];
                  brightIndex = i;
                }
            }
          else if(rightData[i] > leftData[i]){
              if(rightData[i] > bright){
                  bright = rightData[i];
                  brightIndex = i;
                }
            }
            else{}
            
          
          if(leftData[i] < rightData[i]){
              if (leftData[i] < dark){
                  dark = leftData[i];
                  darkIndex = i;
                }
            }
          else if(rightData[i] < leftData[i]){
              if(rightData[i] < dark){
                  dark = rightData[i];
                  darkIndex = i;
                }
            }
            else{}
           
        }
      
	  // Output Sums
      System.out.println("Sums:");  
        
      for(int i=0; i<spots; i++){
          System.out.println( (i+1)+ ". " + sum[i]);
        }
        
      System.out.println("The brightest is point is " + (1+brightIndex) + " with " + bright); 
      System.out.println("The darkest is point is " + (1+darkIndex) + " with " + dark);
      
      // Quit Finch
      myFinch.quit();
      System.exit(0);
    }
}
