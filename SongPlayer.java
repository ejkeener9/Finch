package Keener;

/**
 * Created by: Emily Keener
 * Date: 8/10/20
 * Time: 60 minutes
 * Song Player - Decisions
 * Compose a song with the Finch!
 */

// Import Statements
import java.util.*;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.awt.*;

// SongPlayer Class
public class SongPlayer
{
    // Main Method
    public static void main(final String[] args)
   {
      // Instantiating the Finch object
      Finch myFinch = new Finch();
      
      // Scanner allows user input
      Scanner in = new Scanner(System.in);
      //String pattern = "^[aAbBcCdDeEfFgG]+$";
      String input = "";
      
      // Output Instruction
      System.out.println("Compose your song! Enter it below: ");
      input = in.next();
      
      // While Loop - Checks if user entered invalid characters
      while(!(input.matches("^[aAbBcCdDeEfFgG]+$"))){
        System.out.println("Invalid. Enter notes aA - gG: ");
        input = in.next();
      }
    
      //System.out.println(input);
      // For loop - based on input length
      for(int i = 0; i<input.length(); i++){
       if (input.charAt(i)=='a'){
         myFinch.buzz(880, 600);
         myFinch.sleep(600);
        }
       else if (input.charAt(i)=='A'){
         myFinch.buzz(880, 1200);
         myFinch.sleep(1200);
        }
        else if (input.charAt(i)=='b'){
         myFinch.buzz(988, 600);
         myFinch.sleep(600);
        }
        else if (input.charAt(i)=='B'){
         myFinch.buzz(988, 1200);
         myFinch.sleep(1200);
        }
        else if (input.charAt(i)=='c'){
         myFinch.buzz(523, 600);
         myFinch.sleep(600);
        }
        else if (input.charAt(i)=='C'){
         myFinch.buzz(523, 1200);
         myFinch.sleep(1200);
        }
        else if (input.charAt(i)=='d'){
         myFinch.buzz(587, 600);
         myFinch.sleep(600);
        }
        else if (input.charAt(i)=='D'){
         myFinch.buzz(587, 1200);
         myFinch.sleep(1200);
        }
        else if (input.charAt(i)=='e'){
         myFinch.buzz(659, 600);
         myFinch.sleep(600);
        }
        else if (input.charAt(i)=='E'){
         myFinch.buzz(659, 1200);
         myFinch.sleep(1200);
        }
        else if (input.charAt(i)=='f'){
         myFinch.buzz(698, 600);
         myFinch.sleep(600);
        }
        else if (input.charAt(i)=='F'){
         myFinch.buzz(698, 1200);
         myFinch.sleep(1200);
        }
        else if (input.charAt(i)=='g'){
         myFinch.buzz(784, 600);
         myFinch.sleep(600);
        }
        else{
         myFinch.buzz(784, 1200);
         myFinch.sleep(1200);
        }
        
       /*myFinch.sleep(600);
       
       if(Character.isLowerCase(input.charAt(i))){
            //myFinch.sleep(600);
        }
        else{
           myFinch.sleep(600); 
        }*/
       System.out.print(input.charAt(i));
      }
      // Quit Finch
      myFinch.quit();
      System.exit(0);
    }
}
