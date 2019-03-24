package Keener;

/**
 * Created by: Emily Keener
 * Date: 7/26/20
 * Dance - Basics
 * Simple program to have the Finch do a dance
 */

// Import statements for the Finch and awt.Color
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.awt.Color;

// Dance class
public class Dance
{
   // Main Method
   public static void main(final String[] args)
   {
      // Instantiating the Finch object
      Finch myFinch = new Finch();

      // Make the Finch buzz for 1 second (262Hz is Middle C) using buzz method
      myFinch.buzz(262, 1000);
      
      // Set LED green with the setLED method
      myFinch.setLED(0, 255, 0);
      
      // Move forward for one second using the setWheelVelocities method
      myFinch.setWheelVelocities(100, 100, 1000);
      
      // Set LED blue and turn right for three seconds using setWheelVelocities and setLED methods
      myFinch.setLED(0, 0, 255);
      myFinch.setWheelVelocities(0, 100, 3000);
      
      // Set LED red and turn left for three seconds
      myFinch.setLED(255, 0, 0);
      myFinch.setWheelVelocities(100, 0, 3000);

      // Quit Finch and System exit methods
      myFinch.quit();
      System.exit(0);
    }
}