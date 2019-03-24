package Keener;

/**
 * Created by: Emily Keener
 * Date: 10/15/18
 * Gestural Prorammer - Record moves for the Finch
 */

// Import Statements
import java.util.*;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.awt.*;

// FinchSimon Class
public class Gestural
{
    public static void recordMode(int[] listOfOrientations, Finch myFinch, int timer){
        System.out.println("Begin recording");
        myFinch.setLED(255,0,0);
          for(int i=0; i<timer; i++){
              myFinch.sleep(100);
              if(myFinch.getXAcceleration()<0){ 
                 listOfOrientations[i] = 0;
                 System.out.println("Forward");
              }
              else if(myFinch.getXAcceleration()>0){
                  listOfOrientations[i] = 1;
                  System.out.println("Backward");
                }
              else if(myFinch.getYAcceleration()>0){
                  listOfOrientations[i] = 2;
                  System.out.println("Right");
                }
              else if(myFinch.getYAcceleration()<0){
                  listOfOrientations[i] = 3;
                  System.out.println("Left");
                }
              else{
                  listOfOrientations[i] = 4;
                  System.out.println("Stop");
                }
                System.out.println(i);
          }
        System.out.println("End recording");
       }
    
   public static void playMode(int[] listOfOrientations, Finch myFinch){
       System.out.println("Begin play mode");
       myFinch.setLED(0,255,0);
       for(int i = 0; i<listOfOrientations.length; i++){
           if(listOfOrientations[i] == 0){
               myFinch.setWheelVelocities(100, 100, 100);
            }
           else if(listOfOrientations[i] == 1){
               myFinch.setWheelVelocities(-100, -100, 100);
            }
            else if(listOfOrientations[i] == 2){
               myFinch.setWheelVelocities(0, 100, 100);
            }
            else if(listOfOrientations[i] == 3){
               myFinch.setWheelVelocities(100, 0, 100);
            }
            else{
               myFinch.stopWheels();
            }
           myFinch.sleep(100);
           System.out.println(i);
        }
    }
    
    // Main Method
    public static void main(final String[] args)
   {
      // Instantiating the Finch object
      Finch myFinch = new Finch();
      
      int sec = 5;
      // int timer (seconds)
      int timer = sec * 10;
      
      
      // moves array (300 for 30 sec)
      int[] listOfOrientations = new int[timer];
      
      //ArrayList<Integer> listOfOrientations
      
      recordMode(listOfOrientations, myFinch, timer);
      
      myFinch.sleep(5000);
      
      playMode(listOfOrientations, myFinch);
      
      // Quit Finch
      myFinch.quit();
      System.exit(0);
    

    
     }
}
