package master;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;

public class Airspace extends Application{
	static Group root = new Group();
	static double width = 700;
	static double height = 700;
	static boolean species = false;

	public static void main(String[] args) {launch();}
	
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Airspace control");
		
		primaryStage.setOnCloseRequest(event0 -> {
			System.exit(0);
		});
		
		primaryStage.widthProperty().addListener(event1 -> {
			width = primaryStage.getWidth();
		});
		primaryStage.heightProperty().addListener(event2 -> {
			height = primaryStage.getHeight();
		});
		
		//Ugly but useful toolBar
		ToolBar settings = new ToolBar();		
		Label current = new Label("Current mode: one species");
		
		Button mode = new Button("Switch mode");
		
		mode.setOnAction(event3 -> {
			if(species) {
				current.setText("Current mode: one species");
			}else {
				current.setText("Current mode: many species");
			}
			species = !species;
		});
		
		settings.getItems().addAll(mode,current);
		root.getChildren().add(settings);

		//start of the flock
		Flock f = new Flock();
		f.draw(root);
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask(){
			public void run(){
		        f.update(species);
			};
		};
		
		//task runs at 30 tps (ticks per second)
		timer.scheduleAtFixedRate(task, 0, 33l);
		
		Scene s = new Scene(root,width,height);
		primaryStage.setScene(s);
		primaryStage.show();
	}

}
