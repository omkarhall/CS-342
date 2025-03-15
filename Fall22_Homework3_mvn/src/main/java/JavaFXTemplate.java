import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;


public class JavaFXTemplate extends Application {
	
	private Button b1, b2;
	private TextField t1, t2;
	private BorderPane p1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Omkarnath Halleppanawar Homework 3");

		b1 = new Button("button 1");
		b2 = new Button("button 2");
	
		t1 = new TextField();
		t1.setPromptText("enter text here then press button 1");
	
		t2 = new TextField("final string goes here");
		t2.setEditable(false);
		
		p1 = new BorderPane();
		p1.setLeft(new VBox(b1, b2));
		p1.setCenter(t1);
		p1.setRight(t2);
		
		b1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				t2.setText(t1.getText() + ": from the center text field!");
				b1.setDisable(true);
				b1.setText("pressed");
			}
		});
		
		b2.setOnAction(e-> {
			t1.clear();
			t2.clear();
			t2.setText("final string goes here");
			b1.setDisable(false);
			b1.setText("button 1");
		});
	
		b1.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		b2.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		t1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		t2.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		p1.setPadding(new Insets(25, 25, 25, 25));
		p1.setBackground(new Background(new BackgroundFill(Color.BLANCHEDALMOND, 
				CornerRadii.EMPTY, Insets.EMPTY)));
		
		Scene scene = new Scene(p1, 700, 700);
		scene.getRoot().setStyle("-fx-font-family: 'serif'");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
