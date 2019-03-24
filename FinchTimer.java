package Keener;

/**
 * Created by: Emily Keener
 * Date: 10/17/18
 * Finch acts as a timer
 */
// Import Statements
import java.util.*;
import java.lang.*;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.awt.Color;
// FinchTimer Class
public class FinchTimer
{
   public static int mag(Finch myFinch){
       double x = myFinch.getXAcceleration();
       double y = myFinch.getYAcceleration();
       double z = myFinch.getZAcceleration();
       
       // Formula
       double a = Math.sqrt(Math.pow(x, 2) + Math.pow(x, 2) + Math.pow(x, 2));
       
       return (int)a;
    }
    
    // Main Method
    public static void main(final String[] args)
   {
      // Instantiating the Finch object
      Finch myFinch = new Finch();
      
      // Timer boolean
      boolean timesUp = false;
      
      // Scanner to take user input
      Scanner in = new Scanner(System.in);
      String input = "";
      
      // Ouput Instruction
      System.out.println("Enter number of seconds for timer: ");
      // Parse input from a string into an int
      int x = Integer.parseInt(in.next());
      

      // Use Sleep for timer
      myFinch.sleep(x*1000);

      
      // While loop - until Finch is shaken, buzzing will continue
      while(mag(myFinch) < 2){
          myFinch.buzz(262, 1000);
        }
      
      // Quit Finch
      myFinch.quit();
      System.exit(0);
    }
}
