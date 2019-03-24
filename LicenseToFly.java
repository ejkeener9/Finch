package Keener;

/**
 * Created by: Emily Keener
 * Date: 8/10/20
 * License To Fly - Decisions
 * Finch needs to pass a flight test:
 */

// Import Statements
import java.util.*;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.awt.*;

// LicenseToFly Class
public class LicenseToFly
{
  // Main Method
    public static void main(final String[] args)
   {
      // Instantiating the Finch object
      Finch myFinch = new Finch();
      
      // Declare booleans for passing conditions
      boolean xpass = false;
      boolean ypass = false;
      boolean zpass = false;
      
      // Output Instructions
      System.out.println("In order to pass, the Finch must get 0 or greater in X, Y, and Z accelerations");
      
      // For Testing
      System.out.println("Point the Finch downward:");
      
      // You have 2 seconds to move the Finch properly
      myFinch.buzz(262, 2000);
      myFinch.sleep(2000);
      
      // Output X Acceleration value
      System.out.println("X Acceleration: " + myFinch.getXAcceleration());
      
      // Selection Statement - if the Finch passed, change the boolean to true
      if(myFinch.getXAcceleration()>=0){
         xpass = true;
         System.out.println("X pass!");
        }
      
      // For Testing  
      System.out.println("Tilt the Finch's left wing down (beak pointed away from you):");
      
      // You have 2 seconds to move the Finch properly
      myFinch.buzz(262, 2000);
      myFinch.sleep(2000);
      
      // Selection Statement - if the Finch passed, change the boolean to true
      System.out.println("Y Acceleration: " + myFinch.getYAcceleration());
      if(myFinch.getYAcceleration()>=0){
          ypass = true;
          System.out.println("Y pass!");  
        }
      
      // For Testing  
      System.out.println("Don't turn the Finch upside-down!:");
      
      //You have 2 seconds to move the Finch properly
      myFinch.buzz(262, 2000);
      myFinch.sleep(2000);
      
      // Selection Statement - if the Finch passed, change the boolean to true
      System.out.println("Z Acceleration: " + myFinch.getZAcceleration());
      if(myFinch.getZAcceleration()>=0){
          zpass = true;
          System.out.println("Z pass!");
        }

      // Selection Statement - If all 3 tests passed, the user passed!  
      if(xpass && ypass && zpass){
        // Output Passed  
        System.out.println("You pass!");  
        }
        else{
            // Output Failed
            System.out.println("You did not pass.");  
        }
        
      // Quit Finch
      myFinch.quit();
      System.exit(0);
    }
}
