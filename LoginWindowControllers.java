package application;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class LoginWindowControllers 
{
	/*private String updateUserName;
	private String updateUserPassword;
	private int numberOfEmployeeUsers;
	private String updateAdminName;
	private String updateAdminPassword;
	
	
	public LoginWindowControllers(String updateUserName, String updateUserPassword, int numberOfEmployeeUsers)
	{
		this.updateUserName = updateUserName;
		this.updateUserPassword = updateUserPassword;
		this.numberOfEmployeeUsers = numberOfEmployeeUsers;
	}
	
	public LoginWindowControllers(String updateAdminName, String updateAdminPassword)
	{
		this.updateAdminName = updateAdminName;
		this.updateAdminPassword = updateAdminPassword;
	}*/
	
	@FXML
    private TextField userName;

	@FXML
    private PasswordField passWord;

    @FXML
    private Button submitLoginButton;

    @FXML
    private Button resetButoon;
    
    @FXML
    private RadioButton userRadioButton;

    @FXML
    private RadioButton adminRadioButton;

    @FXML
    private ToggleGroup loginMode;
    
    @FXML
    private Label forgotUserNameOrPassword;

    @FXML
    private Label labelWindow;
    
    @FXML
    private Label loginFailureMessage;
    
    Stage googleMapStage = new Stage();
    
    WebApp googleMapAppLoad = new WebApp();


    
	@FXML
	public void loginIsSelected(ActionEvent event) 
	{		
		if(userRadioButton.isSelected())
		{
			if(userName.getText().equals("") || passWord.getText().equals(""))
			{
				loginFailureMessage.setText("Please enter both Username and PassWord.");
			}
			
			else if(userName.getText().equals("User") && passWord.getText().equals("Password"))
			{
				
				Stage stage = (Stage) submitLoginButton.getScene().getWindow();
			    stage.close();
				googleMapAppLoad.start(googleMapStage);
			}
			
			else 
			{
				loginFailureMessage.setText("The combination of Username and Password" + "\ndoes not match for User Mode." 
											+"\n\nPlease try again !!!");
			}	
		}
		
		if(adminRadioButton.isSelected())
		{
			if(userName.getText().equals("") || passWord.getText().equals(""))
			{
				loginFailureMessage.setText("Please enter both Username and PassWord.");
			}
			
			else if(userName.getText().equals("Admin") && passWord.getText().equals("Password"))
			{
				try 
				{
					//Trying to add Children
					AdminLoginController loadBarChart = new AdminLoginController<>();
					
					Stage stage = (Stage) submitLoginButton.getScene().getWindow();
				    stage.close();                      //Closes the Login Window once Submit button is clicked
				     
				    /*This is just added to see how it behaves
				     * 
				     * Group root = new Group();
				       Scene scene = new Scene(root, 500, 500, Color.BLACK);
				 
				       Rectangle r = new Rectangle(25,25,250,250);
				       r.setFill(Color.BLUE);
				       root.getChildren().add(r);
				 
				       stage.setTitle("JavaFX Scene Graph Demo");
				       stage.setScene(scene);
				       stage.show();*/
				    
					Group myGroup = new Group();
					Parent root = FXMLLoader.load(getClass().getResource("/application/AdminLoginWindow.fxml")); //Added this code to load the Scene Builder
					
					//Scene scene = new Scene(myGroup,1000,800);
					Scene scene = new Scene(root,1200,1000);
					
					scene.getStylesheets().add(getClass().getResource("adminApplication.css").toExternalForm());
					Stage primaryStage = new Stage();
					primaryStage.setScene(scene);
					//primaryStage.setAlwaysOnTop(true);
					//primaryStage.toFront();
					primaryStage.setFullScreen(true);
					
					//loadBarChart.makeBarChart();
				
					primaryStage.show();
					
				}
				catch(Exception e) 
				{
					e.printStackTrace();
				}
			}
			
			else 
			{
				loginFailureMessage.setText("The combination of Username and Password" + "\ndoes not match for Admin Mode."
											+ "\n\nPlease try again !!!");
			}
			
		}
				
	}
	
	@FXML
    public void resetIsClicked(ActionEvent event) 
	{
		userName.setText("");
		passWord.setText("");
		loginFailureMessage.setText("");
    }
}
