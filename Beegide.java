package Keener;

/**
 * Created by: Emily Keener
 * Date: 10/4/18
 * Finch is happy in ideal lighting conditions. (70-90 int range)
 */

// Import Statements
import java.util.*;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.awt.Color;
// Beegide Class
public class Beegide
{
    // Main Method
    public static void main(final String[] args)
   {
      // Instantiating the Finch object
      Finch myFinch = new Finch();
      
      // Run Condition
      while(!myFinch.isBeakUp()){
          // Get the min and max for measuring light from both sensors
          int max = Math.max(myFinch.getLeftLightSensor(), myFinch.getRightLightSensor());
          int min = Math.min(myFinch.getLeftLightSensor(), myFinch.getRightLightSensor());
          
          // Print light levels
          System.out.println("Left: " + myFinch.getLeftLightSensor() + " Right: " + myFinch.getRightLightSensor());
          
          // Min < 70 Condition determins if light level is too low
          if(min < 70){
              // The red LED will increase as the conditions get worse
              myFinch.setLED((255-min), 0, 0);
              System.out.println("It's too dark!");
            }
          // Max > 90 Condition determins if light level is too high
          else if(max > 90){
              // The red LED will increase as the conditions get worse
              myFinch.setLED((90+max), 0, 0);
              System.out.println("It's too bright!");
            }
          // Finch is happy and will remain green within this range
          else{
              myFinch.setLED(0,255,0);
              System.out.println("I'm happy!");
            }
            myFinch.sleep(1000);
        }
      
      // Quit Finch
      myFinch.quit();
      System.exit(0);
    }
}
