import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class JavaFXhw4 extends Application {

	SedanBuilder sedan;
	SUVBuilder suv;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
		
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Homework 4");
		sedan = new SedanBuilder();
		suv = new SUVBuilder();
		
		Label l1 = new Label("Enter the type of car you would like to build below (type Sedan or SUV)"
				+ "\nInvalid responses will be set to Sedan by default");
		TextField f1 = new TextField();
		ListView<String> v1 = new ListView<String>();
		ObservableList<String> list = FXCollections.observableArrayList();
		
		f1.setPromptText("Click enter to submit");
		f1.setOnKeyPressed(e -> {
			if(e.getCode().equals(KeyCode.ENTER)){
				if (f1.getText().equals("SUV") || f1.getText().equals("suv")) {
					suv.buildCar();
					list.clear();
					list.add("Car Built!");
					list.add("Car type: SUV");
					list.add("Car wheel size: " + suv.wheelSize + " inches");
					list.add("Car frame size: " + suv.frameSize);
					list.add("Number of seats: " + suv.numSeats);
					list.add("Engine type: " + suv.engineType);
				} 
				else {
					sedan.buildCar();
					list.clear();
					list.add("Car Built!");
					list.add("Car type: Sedan");
					list.add("Car wheel size: " + sedan.wheelSize + " inches");
					list.add("Car frame size: " + sedan.frameSize);
					list.add("Number of seats: " + sedan.numSeats);
					list.add("Engine type: " + sedan.engineType);
				}
				v1.setItems(list);
			}
		});
		l1.setLabelFor(f1);
		
		VBox box1 = new VBox(l1, f1);
		box1.setPadding(new Insets(20, 10, 0, 10));
		box1.setSpacing(10);
		
	    BorderPane root = new BorderPane();
	    root.setCenter(box1);
	    root.setRight(v1);
	    root.setStyle("-fx-background-color: blanchedalmond;" + "-fx-font-family: timesnewroman;");
		Scene scene = new Scene(root, 700,700);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
