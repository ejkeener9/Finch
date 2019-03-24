package Keener;

/**
 * Created by: Emily Keener
 * Date: 7/26/20
 * Indiana Finch - Basics & Loops
 * Finch will complete a maze
 */

// Import statements
import java.util.*;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import edu.cmu.ri.createlab.terk.robot.finch.FinchInterface;
import java.awt.Color;

// Indiana Class
public class Indiana
{       
    // Main Method
    public static void main(final String[] args)
    {
      // Instantiate a new Finch object  
      Finch myFinch = new Finch();
      
      // While Loop for End condition; uses isBeakUp() method
      while(!myFinch.isBeakUp()){
         // Use isObstacle method to detect obstacles on either side of the Finch
          if(myFinch.isObstacle()){
           // Selection statement to turn if the Finch meets an obstacle  
           if(myFinch.isObstacleRightSide()){
             myFinch.setWheelVelocities(100, 0);
            }
            else{
                myFinch.setWheelVelocities(0, 100);
            }
          }
          // If no obstacle, Finch can continue forward
          else{
            // Move the Finch foward
            myFinch.setWheelVelocities(100, 100);
          }
        }
      
      // Once out of the maze, set LED to green for 5 seconds before quiting
      myFinch.setLED(0, 255, 0, 5000);
      
      // Quit Finch and System Exit methods
      myFinch.quit();
      System.exit(0);
    }
}
