package Keener;

/**
 * Created by: Emily Keener
 * Date: 7/26/20
 * Confused Wanderings - Decisions & Loops
 * Finch will wander, backup, and turn away from obstacles
 */

// Import statements
import java.util.*;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.awt.Color;

// Confused class
public class Confused
{
   // Main Method 
    public static void main(final String[] args)
   {
      // Instantiating the Finch object
      Finch myFinch = new Finch();
      
      // While loop for End condition - If the beak is up, the Finch will quit
      while(!myFinch.isBeakUp()){
          // Selection Statement - If no obstacles are present, move Finch forward with green LED
          if(!myFinch.isObstacleRightSide() && !myFinch.isObstacleLeftSide()){
              // Set LED to green
              myFinch.setLED(0,255,0);
              
              // Move forward at a speed of 100
              myFinch.setWheelVelocities(100, 100);
            }
            
          // If there is an obstacle, Finch will backup away from the obstacle with red LED
          else{
              // Set LED to red
              myFinch.setLED(255,0,0);
              
              // Buzz Apologetically
              myFinch.buzz(200, 2000);
              
              // Generate a random number (Backup wheel velocities)
              Random rand = new Random();
              // Use a negative speed to make the Finch go backwards
              int speed = -1 * (rand.nextInt((255 - 1) + 1) + 1);
              
              // Select statement - Finch will turn away from obstacles
              if(myFinch.isObstacleRightSide()){
                  // Backup to the left
                  myFinch.setWheelVelocities(speed, 0, 2000);
              }
              // Obstacle on left side
              else{
                  // Backup to the right
                  myFinch.setWheelVelocities(0, speed, 2000);
                }
            }
      }
      
      // Quit Finch and System exit methods
      myFinch.quit();
      System.exit(0);
    }
}
