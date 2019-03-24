package Keener;

/**
 * Created by: Emily Keener
 * Date: 8/22/20
 * Time: 27 Min (For terminal versions)
 * Remote Control Finch
 */

import java.util.*;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;
public class RemoteListener 
{

    public static void main(String args[]) {
 // Instantiating the Finch object
      Finch myFinch = new Finch();
        
  JFrame frame = new JFrame("Key Listener");

  Container contentPane = frame.getContentPane();

  KeyListener listener = new KeyListener() {


    @Override
    
    public void keyTyped(KeyEvent event) {
        int keyCode = event.getKeyCode();
        
        switch(keyCode){
              case KeyEvent.VK_F: 
              myFinch.setWheelVelocities(100, 100);
                    break;
              case KeyEvent.VK_B:  
              myFinch.setWheelVelocities(-100, -100);
                    break;
              case KeyEvent.VK_R:  
              myFinch.setWheelVelocities(0, 100);
                    break;
             case KeyEvent.VK_L:  
             myFinch.setWheelVelocities(100, 0);
                    break;
              case KeyEvent.VK_X:  
              myFinch.stopWheels();
                    break;
              case KeyEvent.VK_Q: 
              myFinch.quit();
              System.exit(0);
        }
        
    }
};

}
}
