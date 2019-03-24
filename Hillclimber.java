package Keener;

/**
 * Created by: Emily Keener
 * Date: 7/26/20
 * Hill Climber - Decisions
 * Finch will seek and climb hills
 */

// Import Statements
import java.util.*;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.awt.*;

//  Hillclimber Class
public class Hillclimber
{
    // Instantiating the Finch object
      static Finch myFinch = new Finch();
   
    // Main Method  
    public static void main(final String[] args)
    {
      // Runs as long as the Finch is not on its tail
      while(!myFinch.isBeakUp()){
          // Check if the Finch beak is raised on an incline
          if(myFinch.getXAcceleration()<=0){
              // If the left wheel is raised, turn left into incline
              if(myFinch.getYAcceleration()>0){
                myFinch.setWheelVelocities(100,0, 1000);
              }
              // If the right wheel is raised, turn right into incline
              else if(myFinch.getYAcceleration()<0){
                  myFinch.setWheelVelocities(0,100, 1000);
                }
              // If Finch wheels are level, move forward
              else{
                  myFinch.setWheelVelocities(100,100, 1000);
                }
          }
          // Check if the Finch tail is raised on an incline (has to backup)
          else if(myFinch.getXAcceleration()>0){
              // If the left wheel is raised, turn left into incline
              if(myFinch.getYAcceleration()>0){
              myFinch.setWheelVelocities(-100,0, 1000);
              }
              // If the right wheel is raised, turn right into incline
              else if(myFinch.getYAcceleration()<0){
                  myFinch.setWheelVelocities(0,-100, 1000);
                }
                // If Finch wheels are level, move backward straight
              else{
                  myFinch.setWheelVelocities(-100,-100, 1000);
                }
            }
            // Check if the Finch beak and tail are level, move foward
            else{
                myFinch.setWheelVelocities(100,100);
            }
        }
      
      // Quit Finch
      myFinch.quit();
      System.exit(0);
    }
}
