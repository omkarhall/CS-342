
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MyController implements Initializable {
	
	@FXML
	private BorderPane root;
	
	@FXML
	private VBox box;
	
	@FXML
	private HBox box2;
	
	@FXML
	private BorderPane root2;
    
    @FXML
    private TextField textField;
    
    @FXML
    private TextArea t1;
    
    @FXML
    private TextField t2;
    
    @FXML
    private Button b1;
    
    @FXML
    private Button b2;
    
    @FXML
    private TextField putText;
    
    @FXML
    private Button extraShot, cream, sugar, cinnamon, biscotti;
    
    //static so each instance of controller can access to update 
    private static String textEntered = "";
	
	private Coffee order = new BasicCoffee();

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
		order = new ExtraShot(order);
		extraShot.setDisable(true);
		
        /*
		Parent root = FXMLLoader.load(getClass()
                .getResource("/FXML/Myfxml.fxml"));
		 
		 root2.getScene().setRoot(root);
         */
	}
	
	public void b2Method(ActionEvent e) {
		order = new Cream(order);
		cream.setDisable(true);
        /*
		Parent root = FXMLLoader.load(getClass()
                .getResource("/FXML/Myfxml.fxml"));
		 
		 root2.getScene().setRoot(root);
         */
	}
	
	public void b3Method(ActionEvent e) {
		order = new Sugar(order);
		sugar.setDisable(true);
	}
	
	public void b4Method(ActionEvent e) {
		order = new Cinnamon(order);
		cinnamon.setDisable(true);
	}
	
	public void b5Method(ActionEvent e) {
		order = new Biscotti(order);
		biscotti.setDisable(true);
	}
	
	public void cancelMethod(ActionEvent e) {
		order = new BasicCoffee();
		extraShot.setDisable(false);
		cream.setDisable(false);
		sugar.setDisable(false);
		cinnamon.setDisable(false);
		biscotti.setDisable(false);
	}
	
	public void orderMethod(ActionEvent e) {
		String s = order.makeCoffeeString() + "\nTotal: $" + order.makeCoffee();
		extraShot.setDisable(false);
		cream.setDisable(false);
		sugar.setDisable(false);
		cinnamon.setDisable(false);
		biscotti.setDisable(false);
		t1.setText(s);
		order = new BasicCoffee();
	}
	
	

}
