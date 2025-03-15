
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MyController implements Initializable {
	
	@FXML
	private BorderPane root;
	
	@FXML
	private VBox box;
	
	@FXML
	private BorderPane root2;
    
    @FXML
    private TextField textField;
    
    @FXML
    private TextField t1;
    
    @FXML
    private TextField t2;
    
    @FXML
    private Button b1;
    
    @FXML
    private Button b2;
    
    @FXML
    private TextField putText;
    
    //static so each instance of controller can access to update 
    private static String textEntered = "";
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
        
	}
    //method so that the controller created for second view can update the text
    //field with the text from the first view
    public void setText(){
        putText.setText(textEntered);
        System.out.println("hello from setText");
    }
    
    public void setText2(){
        textField.setText(textEntered);
        System.out.println("hello from setText");
    }
	
	public void helloMethod(ActionEvent e) throws IOException {
		
        textEntered = textField.getText(); //get text entered by user
        System.out.println(textEntered);
        
        //get instance of the loader class
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Myfxml2.fxml"));
        Parent root2 = loader.load(); //load view into parent
        MyController myctr = loader.getController();//get controller created by FXMLLoader
        myctr.setText();//use MyLoader class method for setText()
        
        root2.getStylesheets().add("/styles/style2.css");//set style
        
        root.getScene().setRoot(root2);//update scene graph


       	/* original way to load views...nothing shared across FXML files
         
         Parent root2 = FXMLLoader.load(getClass()
                 .getResource("/FXML/Myfxml2.fxml"));
        root2.getStylesheets().add("/styles/style2.css");
		 
		 root.getScene().setRoot(root2);
       */
        
        
	}
	
	public void b1Method(ActionEvent e) {
		t2.setText(t1.getText() + ": from the center text field!");
		b1.setDisable(true);
		b1.setText("pressed");
        /*
		Parent root = FXMLLoader.load(getClass()
                .getResource("/FXML/Myfxml.fxml"));
		 
		 root2.getScene().setRoot(root);
         */
	}
	
	public void b2Method(ActionEvent e) {
		t1.clear();
		t2.clear();
		t2.setText("final string goes here");
		b1.setDisable(false);
		b1.setText("button 1");
        /*
		Parent root = FXMLLoader.load(getClass()
                .getResource("/FXML/Myfxml.fxml"));
		 
		 root2.getScene().setRoot(root);
         */
	}
	
	

}
