package application;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.mkyong.crypto.utils.CryptoUtils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class function 
{
	@FXML
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private TextField t1;
	@FXML
	private TextField t2;
	@FXML
	private TextArea t3;
	@FXML
	private TextField t4;
	@FXML
	private TextField t5;
	@FXML
	private TextField textFiel;
	@FXML
	private TextField textFiell;
	long temp;
	long tempp;
	
	public void START(ActionEvent event) throws IOException
	{
		Parent root=(Parent) FXMLLoader.load(getClass().getResource("2nd.fxml"));
		stage =(Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void Text(ActionEvent event) throws IOException
	{
		Parent root=(Parent) FXMLLoader.load(getClass().getResource("3rd.fxml"));
		stage =(Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void Decryp(ActionEvent event) throws IOException
	{
		Parent root=(Parent) FXMLLoader.load(getClass().getResource("4th.fxml"));
		stage =(Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void Back(ActionEvent event) throws IOException
	{
		Parent root=(Parent) FXMLLoader.load(getClass().getResource("2nd.fxml"));
		stage =(Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void Backk(ActionEvent event) throws IOException
	{
		Parent root=(Parent) FXMLLoader.load(getClass().getResource("2nd.fxml"));
		stage =(Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void Encrypt(ActionEvent event)
	{
		String PASSWORD;
		String pText;
		String OUTPUT_FORMAT = "%-30s:%s";
		
		PASSWORD=t1.getText();
		pText=t2.getText();
		
		 final Charset UTF_8 = StandardCharsets.UTF_8;
		 try {
			String encryptedTextBase64 = EncryptorAesGcmPasswor.encrypt(pText.getBytes(UTF_8), PASSWORD);
			t3.setText(encryptedTextBase64);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void Decrypt(ActionEvent event)
	{
		String PASSWORD;
		String pText;
		String OUTPUT_FORMAT = "%-30s:%s";
	
		PASSWORD=t4.getText();
		 final Charset UTF_8 = StandardCharsets.UTF_8;
			 if(PASSWORD.equals(PASSWORD))
			 {
				 String encryptedTextBase64 = t3.getText();
				try {
					String decryptedText = EncryptorAesGcmPasswor.decrypt(encryptedTextBase64, PASSWORD);
					t5.setText(decryptedText);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
			 else
			 {
				 JOptionPane.showMessageDialog(null," Invalid Password ");
			 }
	}
	
	public void encry(ActionEvent event)
	{
		String text= textFiel.getText();  //takes text input
        temp =  Long.parseLong(text);  // type casting
        Stego.operate((int) temp);
	}
	public void decry(ActionEvent event)
	{

		String text= textFiell.getText();  //takes text input
        tempp =  Long.parseLong(text);  
        if (tempp==temp)
        {
        	Stego.operate((int) temp);// type casting
        }
        else
        {
        	JOptionPane.showMessageDialog(null, " Enter correct password !! ");
        }
	}
	
	
}	