package application;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class Stego 
{
	  public static void operate (int key)
	  {
	       JFileChooser fileChooser =  new JFileChooser();  //  to choose file
	        fileChooser.showOpenDialog(null);
	        File file  = fileChooser.getSelectedFile();

	        try {
	           
				FileInputStream fileInputStream = new FileInputStream(file);
	            byte []data =  new byte[fileInputStream.available()];   //creating an array
	            fileInputStream.read(data);    //image taken will be converted on byte
	            int i=0;

	            for (byte b: data){
	                System.out.println(b);
	                data[i] = (byte) (b^key);   //  for performing encryption and decryption, XOR function is used.
	                i++;
	            }

	            FileOutputStream fileOutputStream =  new FileOutputStream(file);
	            fileOutputStream.write(data);
	            fileOutputStream.close();
	            fileInputStream.close();
	            JOptionPane.showMessageDialog(null, "Done");

	        }catch (Exception e){
	            e.printStackTrace();
	        }
	    }
	   
}
