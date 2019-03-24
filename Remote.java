package Keener;

/**
 * Created by: Emily Keener
 * Date: 8/14/20
 * Time: 27 Min (For terminal versions)
 * Remote Control Finch - Decisions
 */

// Import Statements
import java.util.*;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.awt.*;

// Class Remote
public class Remote
{
   // Main Method
   public static void main(final String[] args)
   {
      // Instantiating the Finch object
      Finch myFinch = new Finch();
      
      // Input Variable for taking user input
      String input = "";
      
      //Quit Variable for End Condition
      boolean quit = false;
      
      // Output Controls
      System.out.println("Control the Finch with \n[F]orward\n[B]ackward\n[R]ight\n[L]eft\n[X] Stop Moving\n[Q]uit");
      
      // While loop - End Condition uses boolean
      while(!quit){
        // Output Instructions  
        System.out.print("Input Instruction: ");
        
        // Scanner for taking user input
        Scanner in = new Scanner(System.in);
        input = in.next();
        
        // Switch statement (toLowerCase Method)
        switch(input.toLowerCase()){
          // f Move forward  
          case "f": myFinch.setWheelVelocities(100, 100);
                break;
          // b Move backward
          case "b":  myFinch.setWheelVelocities(-100, -100);
                break;
          // r Move right
          case "r":  myFinch.setWheelVelocities(0, 100);
                break;
          // l Move left
          case "l":  myFinch.setWheelVelocities(100, 0);
                break;
          // x Stop wheels
          case "x":  myFinch.stopWheels();
                break;
          // q Quits (sets quit condition to true)      
          case "q": quit = true;
        }
      }
      
      // Quit Finch
      myFinch.quit();
      System.exit(0);
    }
}
