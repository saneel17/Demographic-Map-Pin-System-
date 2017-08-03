package application;

import javafx.application.Application;
import javafx.concurrent.Worker.State;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;

/*  ww w .jav  a 2  s.  co  m*/
public class MyFirstWebEngine extends Application {
	  public static void main(String[] args) {
	    Application.launch(args);
	  }
	  @Override
	  public void start(Stage primaryStage) {
	    WebEngine webEngine = new WebEngine();
	    webEngine
	        .getLoadWorker()
	        .stateProperty()
	        .addListener(
	            (obs, oldValue, newValue) -> {
	              System.out.println(newValue);
	              if (newValue == State.SUCCEEDED) {
	                System.out.println("finished loading");
	                String html = (String) webEngine
	                    .executeScript("document.documentElement.outerHTML");
	                System.out.println(html);

	              }
	            }); 

	    webEngine.load("http://www.java2s.com");

	    Group root = new Group();
	    Scene scene = new Scene(root, 300, 250);

	    primaryStage.setScene(scene);
	    primaryStage.show();
	  }
	}