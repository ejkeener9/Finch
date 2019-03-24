package Keener;

/**
 * Created by: Emily Keener
 * Date: 8/10/20
 * Finch hosts Simon Says - List using charAt vs Arrays
 */

// Import Statements
import java.util.*;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.awt.*;

// FinchSimon Class
public class FinchSimon
{
    // generateMove method returns move based on random number
    public static String generateMove(char m){      
      String r ="";
      // Switch statement to generate move
      switch (m){
          case '1':
          r = "Beak Up";
          break;
          case '2':
          r =  "Beak Down";
          break;
          case '3': 
          r =  "Left Wing Down";
          break;
          case '4': 
          r =  "Right Wing Down";
          break;
        }
        
        return r;
    }
    

    // moveCorrect returns true if the move the user performs is correct
    public static boolean moveCorrect(Finch myFinch, char m){
        boolean c = false;
        myFinch.sleep(2000);
          // Switch statement
          switch (m){
              case '1':
                if(myFinch.getXAcceleration()<0){ 
                  c = true;
                }
              break;
              case '2': 
              if(myFinch.getXAcceleration()>0){ 
                  c = true;
                }
              break;
              case '3': 
              if(myFinch.getYAcceleration()>0){ 
                  c = true;
                }
              break;
              case '4': 
              if(myFinch.getYAcceleration()<0){ 
                  c = true;
                }
              break;
            }
           return c;
    }
    
    public static int generateNumber(){
       // Generate a random number (Finch has 6 orientations)
       // 0 Beak up, 1 Beak down, 2 Left wing down, 3 right wing down
       Random rand = new Random();
       return rand.nextInt(4) + 1;
    }
    
    // Main Method
    public static void main(final String[] args)
   {
      // Instantiating the Finch object
      Finch myFinch = new Finch();
      
      // move String, list of moves (moves are appended)
      String moves = "";
      
      int level = 0;
      
      // randomNum variable
      int randomNum = 0;
      
      // lastMove so that moves aren't repeated
      int lastMove = 5;
      
      // Lose Variable
      boolean lose = false;
      
      while(!lose){   
      if(level != 0){System.out.println("\nLevel " + level);}    
      randomNum = generateNumber();
      while(randomNum == lastMove){randomNum = generateNumber();}
          
      moves = moves + randomNum;
      
      for(int i = 1; i< moves.length(); i++){
         System.out.print("Simon Says " + generateMove(moves.charAt(i)) + "\n");
         if(moveCorrect(myFinch, moves.charAt(i))){
            System.out.println("Nice!\n");
            myFinch.buzz(250, 1000);
            myFinch.setLED(0, 255, 0, 1000);
         }
         else{ 
            System.out.println("You made it to " + (moves.length()-1) + " moves.");
            if(level < 4){System.out.print("Wow, your memory is terrible.");}
            else if(level < 9){System.out.print("Try harder next time.");}
            else{System.out.print("Congrats! Your memory is excellent.");}
            lose = true;
            break;
          }
        }
      
      lastMove = randomNum;  
      level++;
    }
      
      // Quit Finch
      myFinch.quit();
      System.exit(0);
    

    
     }
}
