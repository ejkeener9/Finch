package Keener;

/**
 * Created by: Emily Keener
 * Date: 10/17/18
 * Finch moves in fractal shapes
 */

// Import Statements
import edu.cmu.ri.createlab.terk.robot.finch.Finch;

// FinchFractals Class
public class FinchFractals
{
    // Size method
    public static void size(Finch myFinch, int l){
        myFinch.setWheelVelocities(100, 100, l);
    }
    
    // Left 60 deg method
    public static void left(Finch myFinch){
        myFinch.setWheelVelocities(0, 100, 900);
    }
    
    // Right 120 deg method
    public static void right(Finch myFinch){
        myFinch.setWheelVelocities(100, 0, 1800);
    }
    
    // Koch Fractal Method
    public static void koch(Finch myFinch, int n, int l){
        //Select statement
        if(n==0){size(myFinch, l);}
        else{
            koch(myFinch, n-1, l/3);
            left(myFinch);
            koch(myFinch, n-1, l/3);
            right(myFinch);
            koch(myFinch, n-1, l/3);
            left(myFinch);
            koch(myFinch, n-1, l/3);
        }
    }
    
    // Main Method
    public static void main(final String[] args){
      // Instantiating the Finch object
      Finch myFinch = new Finch();
      
      // Number of orders
      int n = 2;
      
      // Size
      int l = 500;

      // Koch Fractal Method
      koch(myFinch, n, l);
    }
}