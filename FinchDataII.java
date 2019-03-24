package Keener;

/**
 * Created by: Emily Keener
 * Date: 10/8/18
 * Finch collects data and saves it to a txt file
 */

// Import Statements
import java.util.*;
import java.lang.*;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.awt.Color;
import java.io.*;

public class FinchDataII
{
    public static void main(final String[] args)
   {
      // Instantiating the Finch object
      Finch myFinch = new Finch();
      
      // int timer
      int time = 0;
      
      // Scanner to take user input
      Scanner in = new Scanner(System.in);
      String input = "";
      
      // Ouput Instruction
      System.out.println("Enter number of seconds for data recording: ");
      // Parse input from a string into an int
      time = Integer.parseInt(in.next());
      
      // Multidimensional Array - 6 rows for data categories, columns is based on time
      double[][] data = new double[6][time];
      
      // For loop to record data
      for(int i=0; i<time; i++){
          System.out.println("Begin Recording " + (i+1));
          System.out.println("Recording Light Data");
          // Light recording
          data[0][i] = myFinch.getLeftLightSensor();
          data[1][i] = myFinch.getRightLightSensor();
            
          System.out.println("Recording Acceleration Data");
          // Acceleration
          data[2][i] = myFinch.getXAcceleration();
          data[3][i] = myFinch.getYAcceleration();
          data[4][i] = myFinch.getZAcceleration();

          System.out.println("Recording Temperature Data");
          // Temperature
          data[5][i] = myFinch.getTemperature();
          
          // 1 record per second
          myFinch.sleep(1000);
          
          System.out.println("End Recording");
        }
          
      System.out.println("Start Write to file");  
      // Write data to txt file  
      try {
            java.io.File file = new java.io.File("FinchDataII.txt");
			java.io.PrintWriter output = new java.io.PrintWriter(file);
			output.println("Finch Data Collector II");
			for(int i=0; i<time; i++){
			  output.printf("%nRecord " + (i+1) +
			  "%nLight Left: " + data[0][i] + " Light Right: " + data[1][i] +
			  "%nAcceleration X: " + data[2][i] + " Y: " + data[3][i] + " Z: " + data[4][i] +
			  "%nTemperature " + data[5][i] + "%n");
            }
			output.close();
			System.out.println("Data Saved!");
		} catch (IOException e) {
			e.printStackTrace();
		}
      
      // Quit Finch
      myFinch.quit();
      System.exit(0);
    }
}
