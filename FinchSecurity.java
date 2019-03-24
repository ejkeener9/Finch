package Keener;

/**
 * Created by: Emily Keener
 * Date: 10/8/18
 * Finch secures a door
 */
 
// Import Statements
import java.util.*;
import java.lang.*;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.awt.Color;

// FinchSecurity Class
public class FinchSecurity
{
    // Main Method
    public static void main(final String[] args)
   {
      // Instantiating the Finch object
      Finch myFinch = new Finch();
      
      // Finch blinks while door closed
      while(myFinch.isObstacle()){
          myFinch.setLED(255,0,0, 1000);
          myFinch.sleep(200);
        }
        
      // When door opens, Finch moves, lights up, and makes noise
      while(!myFinch.isBeakUp()){
          myFinch.buzz(262, 1000);
          myFinch.setLED(0,255, 0, 1000);
          myFinch.setWheelVelocities(-100, 0);
        }
        
      // Quit Finch
      myFinch.quit();
      System.exit(0);
    }
}
