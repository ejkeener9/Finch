package Keener;

/**
 * Created by: Emily Keener
 * Date: 8/10/20
 * Time: 40 minutes
 * Simple Simon Says - Decisions
 * Simple Simon Says using 6 Finch Orientations
 */

// Import Statements
import java.util.*;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.awt.*;

// SimonSays Class
public class SimonSays
{
    // Main Method
    public static void main(final String[] args)
   {
      // Instantiating the Finch object
      Finch myFinch = new Finch();
      
      // Win Variable
      boolean win = false;
      
      // Generate a random number (Finch has 6 orientations)
      // 0 Beak up, 1 Beak down, 2 Left wing down, 3 right wing down, 4 level, 5 upside down
      Random rand = new Random();
      int randomNum = rand.nextInt((6 - 1) + 1) + 1;
      
      // Output Instruction
      System.out.println("Position: " + randomNum + "\nSimon says: ");
      
      // Switch statement
      switch (randomNum){
          case 1: System.out.println("Beak Up!"); 
          // Sleep allows time for you to put the finch in position
          myFinch.sleep(5000);
          if(myFinch.getXAcceleration()<0){ win = true; }
          break;
          case 2: System.out.println("Beak Down!"); 
          myFinch.sleep(5000);
          if(myFinch.getXAcceleration()>0){ win = true; }
          break;
          case 3: System.out.println("Left Wing Down!"); 
          myFinch.sleep(5000);
          if(myFinch.getYAcceleration()>0){ win = true; }
          break;
          case 4: System.out.println("Right Wing Down!"); 
          myFinch.sleep(5000);
          if(myFinch.getYAcceleration()<0){ win = true; }
          break;
          case 5: System.out.println("Level!"); 
          myFinch.sleep(5000);
          if(myFinch.isFinchLevel()){ win = true; }
          break;
          case 6: System.out.println("Upside Down!"); 
          myFinch.sleep(5000);
          if(myFinch.isFinchUpsideDown()){ win = true; }
          break;
        }
      
      // Output if the game was won or lost
      if(win){
         System.out.println("Good job!"); 
        }
      else{
          System.out.println("Boo! Try again."); 
        }
      
      // Quit Finch
      myFinch.quit();
      System.exit(0);
    }
}
