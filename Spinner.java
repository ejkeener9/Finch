package Keener;

/**
 * Created by: Emily Keener
 * Date: 7/26/20
 * Finch Spinner - Basics
 * Finch will spin for a random number of time
 */

// Import statements
import java.util.*;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.awt.Color;

// Spinner Class
public class Spinner
{
   // generateSpeed Method will return a random speed for the Finch to spin 
   public static int generateSpeed(){
       // Generate a random number (Finch will move up to 10 seconds)
      Random rand = new Random();
      int randomNum = rand.nextInt((10 - 1) + 1) + 1;
      
      // Multiply by 1000 for it to be in milliseconds
      int speed = randomNum * 1000;
      
      // Returns the speed int
      return speed;
    }
    
   // Main Method 
   public static void main(final String[] args)
   {
      // Instantiating the Finch object
      Finch myFinch = new Finch();
      
      // Spin the Finch (References generateSpeed() to get speed value)
      myFinch.setWheelVelocities(0, 255, generateSpeed());
      
      // Quit Finch and System exit methods
      myFinch.quit();
      System.exit(0);
    }
}

