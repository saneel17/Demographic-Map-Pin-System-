package application;

import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.InputStreamReader;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathConstants;
import org.w3c.dom.Document;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;
import com.sun.prism.paint.Color;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.SwipeEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

public class AdminLoginController<myBorderPane> implements Initializable
{
	// Menubar Help
	@FXML
    private MenuItem menuItemManual;
	// Menubar Proximity
	@FXML
	private MenuItem menuItemProximity;
	// Menubar Analyze
	@FXML
	private MenuItem menuItemAnalyze;
	//Add Visitor
	@FXML
	private MenuItem menuItemAdd;
	//Menubar Update Visitor
	@FXML
	private MenuItem menuItemEdit;
	//Menubar Home
	@FXML
	private MenuItem menuItemHome;
	//Border pane for the admin 
	@FXML
	private BorderPane myBorderPane;
	//The menu bar 
	@FXML
	private MenuBar myMenuBar;
	
	
	
	@FXML 
	private TextField proximityCity;
	private String inputProximityCity;
	private String distance;
	@FXML
	private Button proximityButton;
	@FXML
	private Button proximityCSVButton;
	@FXML
	private  ComboBox<String> proximityRange;
	
	
	
	
// The virtual box for the interface
	@FXML
	private VBox vBoxForDisplay;
//Submit button for the analysis
	@FXML
	private Button submitAnalysis;
//Button to clear the textfields
	@FXML
	private Button btnTextClear;

	@FXML
	private Button btnTextClear1;

	@FXML
	private TextField txtFieldZip;
	
	@FXML
	private TextField txtFieldVisitorSum;
	
	@FXML
	private    /**TextField*/ComboBox<String> txtFieldState;
	@FXML
	private TextField txtFieldCity;
	@FXML
	private TextField txtFieldCountry;

	@FXML
	private Label addLabel;
	@FXML
	private TextField addZip;
	@FXML
	private TextField addCity;
	@FXML
	private TextField addCountry; ///yaha textfield ko thau ma combox rakhya thiyo
	@FXML
	private TextField addEmail;
	
	
	@FXML
	private ComboBox<String> addHotel;
	@FXML
	private ComboBox<String> addState;
	@FXML
	private ComboBox<String> addpurpose;
	@FXML
	private DatePicker addDate;
	@FXML
	private TextField addDetails;
	@FXML
	private ComboBox<String> addNumofVisitor;
	@FXML
	private Button addButton;

	@FXML
	private Button deleteButton;

	@FXML
	private Button updateButton;

	@FXML
	private /**TextField*/ComboBox<String> purpose;
	@FXML
	private ComboBox<String> txtFieldHotelstay;
	@FXML
	private Label labelDisplay;

	@FXML
	private TextField labelStartDate;

	@FXML 
	private HBox hBoxForDisplay;

	@FXML
	private BarChart<String, Integer> bc;

	@FXML
	private  PieChart chart;

	@FXML
	private NumberAxis yAxis;

	@FXML
	private CategoryAxis xAxis;

	//For Line Chart
	@FXML
	private NumberAxis numYAxisLineChart;

	@FXML
	private LineChart<String,Number> lineChartInHomeMenu;

	@FXML
	private CategoryAxis monthXAxisLineChart;

	@FXML
	private Button submitButton;

	@FXML
	private Button enterButton;

	@FXML
	private Button generateEmailCSVButton;
	@FXML
	private Button importCSVButton;
	
	private int value;

	@FXML
	private DatePicker startDate;

	@FXML
	private DatePicker endDate;

	@FXML
	private ScrollPane scrollPaneForTable;

	DBConnection myDataBase = new DBConnection();

	//For HBox of Pie Chart, Bar, and Line
	@FXML
	private HBox hBoxForPieBarLineChart;
	
	@FXML
	private AnchorPane menuBarContainer;
	
	@FXML
	private TextField textFieldSearch;
	
	//To initializing the variables for getting input
	private String inputZipCode;
	private String inputCity;
	private String inputState;
	private String inputCountry;
	private String inputPurpose;
	private String inputHotel;

	//Variables for addVisitorInfo method
	private String addZipcode;
	private String addCityName;
	private String addStateName;
	private String addCountryName;
	private String addVisitPurpose;
	private String addVisitDetails;
	private String addHotelInfo;
	private String addNumVisitor;
	private String email;

	///TextBox Field for edit methdos
	private TextField editZip;
	private TextField editCity;
	private TextField editCountry;
	private ComboBox<String> editState;
	private ComboBox<String> editVisitType;
	private ComboBox<String> editNumofVisitor;
	private ComboBox<String> editHotelStay;
	private TextField editVisitDetails;
	private TextField editEmail;

	//Variables to set the values in edit visitor text boxes from selected row

	private String selectedZip;
	private String selectedCity;
	private String selectedState;
	private String selectedCountry;
	private String selectedVisitType;
	private String selectedNumofVisitor;
	private String selectedHotelStay;
	private String selectedVisitDetails;
	private String selectedEmail;



	//Variables to initialize the values  from selected row for updatebutton

	private String updateZip;
	private String updateCity;
	private String updateState;
	private String updateCountry;
	private String updateVisitType;
	private String updateNumofVisitor;
	private String updateHotelStay;
	private String updateVisitDetails;
	private String updateEmail;
// The int value of the selected row 
	private int selectedRowNumber;
// The primary key of the selected row
	private int selectedRowPrimaryKey;
// The last primaty key of the database
	private int lastPrimaryKey;


	private ObservableList<Visitors> data;

	@FXML
	private TableView<Visitors> myTable;

	@FXML
	private TableColumn<Visitors, String> hotelStayColumn;
	@FXML
	private TableColumn<Visitors, String> countryColumn;
	@FXML
	private TableColumn<Visitors, String> purposeColumn;

	@FXML
	private TableColumn<Visitors, String> emailIDColumn;

	@FXML
	private TableColumn<Visitors, String> stateColumn;

	@FXML
	private TableColumn<Visitors, String> detailsColumn;

	@FXML
	private TableColumn<Visitors, String> cityColumn;

	@FXML
	private TableColumn<Visitors, String> numOfPeopleColumn;

	@FXML
	private TableColumn<Visitors, String> dateTimeColumn;

	@FXML
	private TableColumn<Visitors, String> serialNumberColumn;

	@FXML
	private TableColumn<Visitors, String> numVisitorColumn;
	@FXML
	private TableColumn<Visitors, String> zipColumn;

	//Method to lauch the home screen
	@FXML
	private MenuItem menuItemLaunchHomeScreen;
	
	FilteredList<Visitors> filteredDataFromSearch; // = new FilteredList<>(data, p -> true);
	
	
	/* The method to initialize the home screen .
	 * (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		topStates(); 
		pieChartInHome();
		numberOfPeopleInLastTwelveMOnthsLineChart();
		String query="SELECT city, state, zipCode, country, visitType, visitDetails, numOfVisitors, placeOfStay, email_ID, timestamp "
				+ "FROM VisitorInformation ORDER BY SN DESC";
		importDataFromDBToHomeTable(query);
		myTable.setOnMouseClicked(null);
		searchInformationInTable();

	}
	//Method to load  pdf version of manual. 
		 @FXML
		    private void loadManualForHelp(ActionEvent event) {
			 Desktop desktop = Desktop.getDesktop();
			  
			  if (Desktop.isDesktopSupported()) {
				    try {
				        File myFile = new File("Manual.pdf");
				      
				        Desktop.getDesktop().open(myFile);
				    } catch (IOException ex) {
				        // no application registered for PDFs
				    }
				}
		    }
		 
		 /*
		  * A method to search the entered text from the table view
		  */

private void searchInformationInTable() 
{
try{
	filteredDataFromSearch = new FilteredList<>(data, p -> true); 
	
	textFieldSearch.setOnKeyPressed(e -> {
		textFieldSearch.textProperty().addListener((observableValue,oldValue, newValue) -> {
			
			filteredDataFromSearch.setPredicate((java.util.function.Predicate<? super Visitors>) visitors-> {

				if (newValue == null  || newValue.isEmpty())
				{
					return true;
				}

				String changeToLowerCaseMyFilter = newValue.toLowerCase();
				

				int newValueIsDigit = 0;

				if(checkIfSearchFieldISDigit(newValue) == true)
				{
					newValueIsDigit = Integer.parseInt(newValue);
					if ((visitors.getSerialNumber())==newValueIsDigit)
					{
						return true;
					}

					else if (visitors.getZipCode()!=null){

						if ( visitors.getZipCode().contains(newValue)){
							return true;}
					}

					else if (visitors.getNumOfVisitors()!= null)
					{
						if (visitors.getNumOfVisitors().contains(changeToLowerCaseMyFilter))
						{
							return true;
						}
					}
				}	
				
				else if (visitors.getCity()!= null)
				{
					if (visitors.getCity().toLowerCase().contains(changeToLowerCaseMyFilter))
					{
						return true;
					}
				}

				else if (visitors.getStateName() != null)
				{

					if (visitors.getStateName().toLowerCase().contains(changeToLowerCaseMyFilter))
					{
						return true;
					}
				}
				else if (visitors.getCountry()!= null)
				{  
					if (visitors.getCountry().toLowerCase().contains(changeToLowerCaseMyFilter))
					{
						return true;
					}
				}

				else if (visitors.getVisitDetails()!= null)
				{
					if (visitors.getVisitDetails().toLowerCase().contains(changeToLowerCaseMyFilter))
					{
						return true;
					}
				}


				else if (visitors.getPlaceOfStay()!= null)
				{
					if (visitors.getPlaceOfStay().toLowerCase().contains(changeToLowerCaseMyFilter))
					{
						return true;
					}
				}

				else if (visitors.getTimestamp()!= null){
					if (visitors.getTimestamp().contains(newValue))
					{						
						return true;
					}
				}

				else if(visitors.getEmail_ID()!= null) 
				{
					if (visitors.getEmail_ID().toLowerCase().matches(newValue))
					{
						return true;
					}

				}

				return false;


			}); 

		});

		SortedList<Visitors> newSortedData = new SortedList<>(filteredDataFromSearch);

		////////////////////////////
		newSortedData.comparatorProperty().bind(myTable.comparatorProperty());


		myTable.setItems(newSortedData);
		

	});
}
catch (Exception e)
{
	e.printStackTrace();
}

}

private boolean checkIfSearchFieldISDigit(String searchText)
{
for(int i = 0; i < searchText.length();i++){
	char c =  searchText.charAt(i);
	if (Character.isDigit(c) == false){
		return false;
	}
}
return true;
}
	/**
	 * Method to laucnch the home screen again
	 */

	public void reLaunchHomeScreen()
	{
		try
		{
			vBoxForDisplay.getChildren().clear();
			vBoxForDisplay.getChildren().add(hBoxForPieBarLineChart);
			
			String query="SELECT city, state, zipCode, country, visitType, visitDetails, numOfVisitors, placeOfStay, email_ID, timestamp "
					+ "FROM VisitorInformation ORDER BY SN DESC";
			importDataFromDBToHomeTable(query);
			myTable.setOnMouseClicked(null);

		}

		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	java.util.Date dt = new java.util.Date();
	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
	private String currentDate = sdf.format(dt);;

/**
 * Method to display the line bar chart
 */
	
	@FXML
	private void numberOfPeopleInLastTwelveMOnthsLineChart()
	{          

		try (Connection connection = myDataBase.getConnection())
		{
			String timeStampQuery = "SELECT timestamp FROM VisitorInformation ORDER BY SN DESC LIMIT 1";
			Statement stmt = connection.createStatement();

			ResultSet mostRecentTimeOfVisitorRS = stmt.executeQuery(timeStampQuery);
			int presentMonth = 0;
			int presentYear = 0;

			while (mostRecentTimeOfVisitorRS.next())
			{
				Timestamp myStartTime = mostRecentTimeOfVisitorRS.getTimestamp(1);
				presentMonth = myStartTime.getMonth() + 1;
				presentYear = myStartTime.getYear() +1900;
			}

			int[] totalVisitorsForLastTwelveMonths = new int[12]; 
			String[] lastTwelveMonths = new String[12];
			HashMap<Integer, String> listOfMonths = new HashMap<Integer, String>() { //Declard Hashmap to map the month in numbers to the alphabetical months
				{
					put(1,"Jan"); put(2,"Feb");	put(3,"Mar"); put(4,"Apr");	put(5,"May" ); put(6,"Jun"); 
					put(7,"Jul"); put(8,"Aug");put(9,"Sep"); put(10,"Oct"); put(11,"Nov"); put(12, "Dec");
				}
			};

			XYChart.Series series = new XYChart.Series();

			Timestamp startTimeStampForDBQuery;
			Timestamp endTimeStampForDBQuery;
			for (int i = 11; i >=0; i--)
			{
				String startOfMonth = presentYear + "-" + presentMonth + "-01 00:00:00";
				String endOfMonth = presentYear + "-" + presentMonth + "-31 00:00:00";

				String numberOfVisitorsInEachMonth = "SELECT sum(numOfVisitors) FROM VisitorInformation WHERE timestamp > '"+startOfMonth+"'  AND timestamp < '"+endOfMonth+"'";
				ResultSet numOfVisitorsResultSet = stmt.executeQuery(numberOfVisitorsInEachMonth);
				while (numOfVisitorsResultSet.next())
				{
					int totalVisitorsFromDB = numOfVisitorsResultSet.getInt(1);
					totalVisitorsForLastTwelveMonths[i] = totalVisitorsFromDB;

					if (presentMonth == 1) //Checks if the month is Jan, so the the Dec of last month can be found
					{
						String monthYearForLineChart = "Jan " + presentYear; 
						lastTwelveMonths[i]= monthYearForLineChart;
						presentMonth = 12;
						presentYear--;
					}

					else
					{
						if (i==0)  // Find both the date and the month of the first data in line chart
						{
							lastTwelveMonths[i] = listOfMonths.get(presentMonth) + " " + presentYear;	
						}

						else
						{
							lastTwelveMonths[i] = listOfMonths.get(presentMonth);
							presentMonth--;
						}
					}
				}
			}

			//This loop is adding data to Line Chart from two declared array
			for (int i = 0;i <12;i++)
			{
				series.getData().add(new XYChart.Data(lastTwelveMonths[i],totalVisitorsForLastTwelveMonths[i]));

			}
			lineChartInHomeMenu.getData().add(series);
		}

		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

/*
 * Method for the bar chart displaying the top ten states
 */
	public void topStates(){
		ArrayList<String> stateName = new ArrayList<String>();
		ArrayList<Integer> visitorNum = new ArrayList<Integer>();
		int arraylistSize=0;

		try (Connection connection = myDataBase.getConnection())
		{

			String loadQuery = "SELECT state, SUM(numOfVisitors) FROM VisitorInformation GROUP BY state ORDER BY SUM(numOfVisitors) DESC LIMIT 10 ;";

			Statement stmt = connection.createStatement();


			ResultSet rstate3 ;
			rstate3=(ResultSet) stmt.executeQuery(loadQuery);
			while (rstate3.next()){
				stateName.add(rstate3.getString(1));
				visitorNum.add(rstate3.getInt(2));
			}

			arraylistSize=stateName.size();


		}

		catch (Exception e)
		{
			e.printStackTrace();
		}
		xAxis.setLabel("State");       
		yAxis.setLabel("Number of Visitors");

		XYChart.Series series1 = new XYChart.Series();
		series1.setName("2017");
		for (int j=0;j<arraylistSize;j++){
			if (stateName.get(j).equals(null)){
				break;
			}
			series1.getData().add(new XYChart.Data(stateName.get(j), visitorNum.get(j)));
		}
		bc.getData().addAll(series1);

	}
	
	
	/*
	 * Method to display the piechart
	 */
	public void pieChartInHome(){

		int p=0;
		int b=0;
		int c=0;
		int o=0;

		try (Connection connection = myDataBase.getConnection())
		{
			String query1= "SELECT SUM(numOfVisitors) FROM VisitorInformation WHERE visitType = \"Business\"";
			String query2= "SELECT SUM(numOfVisitors) FROM VisitorInformation WHERE visitType = \"Pleasure\"";
			String query3= "SELECT SUM(numOfVisitors) FROM VisitorInformation WHERE visitType = \"Convention\"";
			String query4= "SELECT SUM(numOfVisitors) FROM VisitorInformation WHERE visitType = \"Other\" OR (visitType<>\"Business\" AND visitType<>\"Pleasure\" AND visitType<>\"Convention\")";

			Statement stmt = connection.createStatement();

			ResultSet rs1= stmt.executeQuery(query1);
			while (rs1.next()){

				b=rs1.getInt(1);	
			}
			ResultSet rs2= stmt.executeQuery(query2);
			while (rs2.next()){

				p=rs2.getInt(1);	
			}
			ResultSet rs3= stmt.executeQuery(query3);
			while (rs3.next()){

				c=rs3.getInt(1);	
			}
			ResultSet rs4= stmt.executeQuery(query4);
			while (rs4.next()){

				o=rs4.getInt(1);	
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		ObservableList<PieChart.Data> pieChartData =
				FXCollections.observableArrayList(
						new PieChart.Data("Business", b),
						new PieChart.Data("Convention",c),
						new PieChart.Data("Other", o),
						new PieChart.Data("Pleasure",p));

		chart.setData(pieChartData);
		chart.setTitle("Visit Type");

	}
/*
 * Method to build the add visitor interface
 */

	@FXML
	public void addVisitor(ActionEvent event) 
	{
		vBoxForDisplay.getChildren().clear();
		vBoxForDisplay.setSpacing(15);

		addState= new ComboBox<String>();
		addState.getStyleClass().add("addTextField");
		addState.getItems().addAll("AL","AK","AZ","AR","CA","CO","CT","DE","FL","GA","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MI","MN","MS","MO","MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA","RI","SC","SD","TN","TX","UT","VT","VA","WA","WV","WI","WY");
		addState.setPromptText("Select the State");
		addState.setValue("");
		addState.setEditable(true);
		
		addEmail=new TextField();
		
		addEmail.setPrefWidth(420);
		addEmail.setPrefHeight(40);
		addEmail.setPromptText("Enter E-mail address");
		addEmail.setFocusTraversable(false);

		addCity = new TextField();
		addCity.getStyleClass().add("addTextField");
		addCity.setPromptText("Enter the City");
		addCity.setFocusTraversable(false);

		addZip = new TextField();
		addZip.getStyleClass().add("addTextField");
		//addZip.setPrefWidth(200);
		//addZip.setPrefHeight(40);
		addZip.setPromptText("Enter the ZipCode");
		addZip.setFocusTraversable(false);

		addCountry = new TextField();
		addCountry.getStyleClass().add("addTextField");
		//addCountry.setPrefWidth(200);
		//addCountry.setPrefHeight(40);
		addCountry.setPromptText("Enter the Country");
		addCountry.setFocusTraversable(false);

		addpurpose= new ComboBox<String>();
		addpurpose.getStyleClass().add("addTextField");
		addpurpose.getItems().addAll("Business", "Pleasure","Convention","Other");
		addpurpose.setPromptText("Purpose Of Visit");
		addpurpose.setValue("");
		addpurpose.setEditable(true);

		addNumofVisitor=new ComboBox<String>();
		addNumofVisitor.getStyleClass().add("addTextField");
		addNumofVisitor.getItems().addAll("1","2","3","4","5","6","7","8","9","10");
		addNumofVisitor.setPromptText("Number Of Visitor");
		addNumofVisitor.setValue("");
		addNumofVisitor.setEditable(true);
		addNumofVisitor.setPadding(new Insets(0,0,0,0));


		addHotel = new ComboBox<String>();
		addHotel.getStyleClass().add("addTextField");
		addHotel.getItems().addAll("Yes","No");
		addHotel.setPromptText("Staying in Hotel");
		addHotel.setValue("");
		addHotel.setEditable(true);

		addDetails = new TextField();
		addDetails.setPrefWidth(420);
		addDetails.setPrefHeight(40);
		addDetails.setPromptText("Visit Details");
		addDetails.setFocusTraversable(false);

		addButton = new Button("Add");
		addButton.setId("btnAddVisitor");

		addLabel=new Label("Please fill the visitor information.");
		addLabel.getStyleClass().add("instructionLabel");
		

		addDate = new DatePicker();
		addDate.setPromptText("Date MM/dd/yyyy");
		addDate.getStyleClass().add("addTextField");


		HBox hb1 = new HBox();
		HBox hb2 = new HBox();
		HBox hb3 =new HBox();
		hb1.getChildren().addAll(addCity,addState);
		
		hb2.getChildren().addAll(addZip, addCountry);
		hb3.getChildren().addAll(addHotel, addpurpose);
		hb1.setSpacing(15);
		hb2.setSpacing(15);
		hb3.setSpacing(15);
		hb1.setPadding(new Insets(0,0,0,0));

		vBoxForDisplay.getChildren().addAll(addLabel,hb1,hb2,hb3,addNumofVisitor,addEmail,addDetails, addDate, addButton);


		addButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				addVisitorInfo();
				addVisitor(e);
				
			}
		});

		String query="SELECT city, state, zipCode, country, visitType, visitDetails, numOfVisitors, placeOfStay, email_ID, timestamp "
				+ "FROM VisitorInformation ORDER BY SN DESC";
		importDataFromDBToHomeTable(query);


	}
	
	/*
	 * Method to add the visitor
	 */
	
	private void addVisitorInfo(){

		addZipcode=addZip.getText();
		addCityName=addCity.getText();
		addStateName=addState.getValue();
		addCountryName=addCountry.getText(); // changed to getValue
		addVisitPurpose=addpurpose.getValue();
		addVisitDetails=addDetails.getText();
		addHotelInfo=addHotel.getValue();
		email=addEmail.getText();
		addNumVisitor=addNumofVisitor.getValue();

		

		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDate = sdf.format(dt);;


		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		//convert String to LocalDate
		LocalDate localDate = LocalDate.parse(currentDate, formatter);
		
		if (addZipcode.equals("") && addCityName.equals("") && addCountryName.equals("") && addStateName.equals("") && addVisitPurpose.equals("") && addVisitDetails.equals("") && addHotelInfo.equals("") && email.equals("") && addNumVisitor.equals(""))
		{
			Alert a2 = new Alert(AlertType.ERROR);
	        a2.setTitle("Missing Visitor Information");
	        a2.initStyle(StageStyle.UNDECORATED);
	        a2.setContentText("Please enter the visitor information!");
	        a2.showAndWait();
			
		}
		else
		{
			if(addNumVisitor.equals("") )
			{
				addNumVisitor="1";
			}


		try{
			LocalDate DateValue = addDate.getValue();
			if (DateValue==null)
			{
				DateValue= localDate;
			}

			Connection conn = DBConnection.connect();

			String addQuery="INSERT INTO VisitorInformation (zipCode,city,state,country,visitType,visitDetails,numOfVisitors,placeOfStay,email_ID,timestamp) VALUES ('"+addZipcode+"','"+addCityName+"','"+addStateName+"','"+addCountryName+"','"+addVisitPurpose+"','"+addVisitDetails+"','"+addNumVisitor+"','"+addHotelInfo+"','"+email+"','"+DateValue+"')";


			Statement stmt = conn.createStatement();
			stmt.executeUpdate(addQuery);
			
			Alert a = new Alert(AlertType.INFORMATION);
	        a.setTitle("Successful");
	        a.initStyle(StageStyle.UNDECORATED);
	        a.setContentText("The record was successfully added to the database.");
	        a.showAndWait();

			
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		



	}


/*
 * Method to create the interface for Analyze interface
 */

	private void createTextBox()
	{
		vBoxForDisplay.getChildren().clear();
		vBoxForDisplay.setSpacing(15);
		


		hBoxForDisplay = new HBox();

		StackPane paneCity = new StackPane();
		StackPane paneCity1 = new StackPane();

		btnTextClear = new Button("X");
		btnTextClear.setShape(new Circle(0.3));
		btnTextClear.setStyle("-fx-background-color: #00FF80; -fx-margin: 15px; -fx-margin: 15px;");
		btnTextClear.setBackground(null);

		btnTextClear1 = new Button("X");
		btnTextClear1.setShape(new Circle(0.3));
		btnTextClear1.setStyle("-fx-background-color: #00FF80; -fx-margin: 15px; -fx-margin: 15px;");
		btnTextClear1.setBackground(null);

		//Create a TextField to ask admin to enter city
		txtFieldZip = new TextField();
		txtFieldZip.setPrefWidth(300);
		txtFieldZip.setPrefHeight(40);
		txtFieldZip.setPromptText("Enter the ZipCode");
		txtFieldZip.setFocusTraversable(false);
		
		txtFieldVisitorSum= new TextField();
		txtFieldVisitorSum.setPrefWidth(100);
		txtFieldVisitorSum.setPrefHeight(40);
		txtFieldVisitorSum.setFocusTraversable(false);
		
		Label visitorSumLabel =new Label("The total number of visitor is: ");
		
	
		
		
		addLabel=new Label("Please fill any of the visitor information to analyze the records.");
		addLabel.getStyleClass().add("instructionLabel");


		txtFieldCity = new TextField();
		txtFieldCity.setPrefWidth(300);
		txtFieldCity.setPrefHeight(40);
		txtFieldCity.setPromptText("Enter the City");
		txtFieldCity.setFocusTraversable(false);


		txtFieldState= new ComboBox<String>(); //TextField();
		txtFieldState.getItems().addAll("AL","AK","AZ","AR","CA","CO","CT","DE","FL","GA","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MI","MN","MS","MO","MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA","RI","SC","SD","TN","TX","UT","VT","VA","WA","WV","WI","WY");
		txtFieldState.setPromptText("Select the State");
		txtFieldState.setValue("");
		txtFieldState.setEditable(true);
	
		txtFieldCountry = new TextField();
		txtFieldCountry.setPrefWidth(300);
		txtFieldCountry.setPrefHeight(40);
		txtFieldCountry.setPromptText("Enter the Country");
		txtFieldCountry.setFocusTraversable(false);


		purpose= new ComboBox<String>();
		purpose.getItems().addAll("Business", "Pleasure","Convention","Other");
		purpose.setPromptText("Purpose Of Visit");
		purpose.setValue("");
		purpose.setEditable(true);
		
		txtFieldHotelstay = new ComboBox<String>();
		txtFieldHotelstay.getItems().addAll("Yes","No");
		txtFieldHotelstay.setPromptText("Staying in Hotel");
		txtFieldHotelstay.setValue("");
		txtFieldHotelstay.setEditable(true);

		paneCity.getChildren().addAll(txtFieldZip,btnTextClear);
		btnTextClear.visibleProperty().bind( txtFieldZip.textProperty().isEmpty().not() );
		paneCity.setAlignment(btnTextClear,Pos.CENTER_RIGHT);
		paneCity.setMargin(btnTextClear, new Insets(5, 5, 5, 5));

		/** 	paneCity1.getChildren().addAll(txtFieldCountry,btnTextClear);
    	btnTextClear1.visibleProperty().bind( txtFieldCountry.textProperty().isEmpty().not() );
    	paneCity1.setAlignment(btnTextClear,Pos.CENTER_RIGHT);
    	paneCity1.setMargin(btnTextClear, new Insets(5, 5, 5, 5));
		 */
		
		


		labelStartDate = new TextField("Enter the start date");
		hBoxForDisplay.getChildren().add(paneCity);


		startDate = new DatePicker();
		startDate.setPromptText("Start Date MM/dd/yyyy");

		endDate = new DatePicker();
		endDate.setPromptText("End Date  MM/dd/yyyy");

		submitButton = new Button("Submit");
		submitButton.setId("btnSubmitVisitor");
		
		importCSVButton = new Button("Generate CSV");
		importCSVButton.setId("btnCsvVisitor");
		
		HBox hb1 = new HBox();
		hb1.getChildren().addAll(submitButton, importCSVButton);
		hb1.setSpacing(35);
		
		HBox hb= new HBox();
		hb.getChildren().addAll(visitorSumLabel,txtFieldVisitorSum);

		vBoxForDisplay.getChildren().addAll(addLabel,hBoxForDisplay,txtFieldCity, txtFieldState,txtFieldCountry,txtFieldHotelstay,purpose, startDate,endDate,hb1,hb);

		btnTextClear.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				txtFieldZip.setText("");
				txtFieldZip.requestFocus();
			}
		});	

	}

	//This method will edit the visitor information. First, a row will be selected from table
	//the information will be loaded to the forms including text field and other.
	//Will hit the Update button, and a dialog box will appear to ask admin if they want to change
	//Will update the information of the visitor in the database
	@FXML
	public void editVisitorSelectedInTable(ActionEvent event) 
	{
		vBoxForDisplay.getChildren().clear();
		
		editInterface();
		myTable.setOnMousePressed(new EventHandler<MouseEvent>() 
		{
			@Override public void handle(MouseEvent e) 
			{
				mouseClickedUpdateInformation();
				myTable.setOnMouseClicked(null);
			}
		});
		
		String query="SELECT city, state, zipCode, country, visitType, visitDetails, numOfVisitors, placeOfStay, email_ID, timestamp "
				+ "FROM VisitorInformation ORDER BY SN DESC";
		importDataFromDBToHomeTable(query);

	}
//Method to get the values of the variables from the selected row
	@FXML
	private void mouseClickedUpdateInformation()
	{

		Visitors selected =myTable.getSelectionModel().getSelectedItem();
		
		

		selectedZip=selected.getZipCode();
		selectedCity=selected.getCity();
		selectedState=selected.getStateName();
		selectedCountry=selected.getCountry();
		selectedVisitType=selected.getVisitType();
		selectedNumofVisitor=selected.getNumOfVisitors();
		selectedHotelStay=selected.getPlaceOfStay();
		selectedVisitDetails=selected.getVisitDetails();
		selectedEmail=selected.getEmail_ID();

		selectedRowNumber = selected.getSerialNumber();
		findLastPrimarykey();
		selectedRowPrimaryKey=lastPrimaryKey-selectedRowNumber+1;



		editZip.setText(selectedZip);
		editCity.setText(selectedCity);
		editState.setValue(selectedState);
		editCountry.setText(selectedCountry);
		editVisitType.setValue(selectedVisitType);
		editVisitDetails.setText(selectedVisitDetails);
		editEmail.setText(selectedEmail);
		editNumofVisitor.setValue(selectedNumofVisitor);
		editHotelStay.setValue(selectedHotelStay);
		
	}	
//Method to find the primary key of the selected row in the edit Interface
	private void findLastPrimarykey(){

		try{


			Connection conn = DBConnection.connect();

			String pkQuery="SELECT SN FROM VisitorInformation ORDER BY SN DESC LIMIT 1";


			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery(pkQuery);
			while (rs.next()){

				lastPrimaryKey=rs.getInt(1);	
			}


		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	
	/*
	 * Method for the edit interface
	 */
	public void editInterface(){
		
		
		
		Label mainLabel = new Label("Please select a record in the table to edit or delete.");
		mainLabel.getStyleClass().add("instructionLabel");
		
		Label label1 = new Label("Zipcode:    ");
		editZip = new TextField ();
		editZip.getStyleClass().add("addTextField");
		
		Label label2 = new Label("City:           ");
		editCity = new TextField ();
		editCity.getStyleClass().add("addTextField");

		Label label3 = new Label("State:    ");
		editState = new ComboBox<String>();
		editState.getItems().addAll("AL","AK","AZ","AR","CA","CO","CT","DE","FL","GA","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MI","MN","MS","MO","MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA","RI","SC","SD","TN","TX","UT","VT","VA","WA","WV","WI","WY");
		editState.setEditable(true);
		editState.getStyleClass().add("addTextField");

		Label label4 = new Label ("Country:");
		editCountry = new TextField();
		editCountry.getStyleClass().add("addTextField");

		
		Label label5 = new Label ("Visit Type:  ");
		editVisitType = new ComboBox<String>();
		editVisitType.getItems().addAll("Business", "Pleasure","Convention","Other");
		editVisitType.setEditable(true);
		editVisitType.getStyleClass().add("addTextField");

		Label label6 = new Label ("Number of Visitors:   ");
		editNumofVisitor = new ComboBox<String>();
		editNumofVisitor.getItems().addAll("1","2","3","4","5","6","7","8","9","10");
		editNumofVisitor.setEditable(true);
		editNumofVisitor.setPrefWidth(130);
		editNumofVisitor.setPrefHeight(40);
		
		//editNumofVisitor.getStyleClass().add("addTextField");

		Label label7 = new Label ("  Staying in Hotel:");
		editHotelStay = new ComboBox<String>();
		editHotelStay.getItems().addAll("Yes","No");
		editHotelStay.setEditable(true);
		editHotelStay.setPrefWidth(130);
		editHotelStay.setPrefHeight(40);
		//editHotelStay.getStyleClass().add("addTextField");

		Label label8 = new Label ("VisitDetails:");
		editVisitDetails = new TextField();
		editVisitDetails.setPrefWidth(200);
		editVisitDetails.setPrefHeight(40);

		Label label9 = new Label ("E-mail Address:");
		editEmail =new TextField();
		editEmail.setPrefWidth(300);
		editEmail.setPrefHeight(40);



		deleteButton = new Button("Delete");
		deleteButton.setId("btnDeleteVisitor");


		updateButton = new Button("Update");
		updateButton.setId("btnUpdateVisitor");
		
		HBox hb1 = new HBox();
		HBox hb2 =new HBox();
		HBox hb3 = new HBox();
		HBox hb4 = new HBox();
		HBox hb5 =new HBox();
		HBox hb6 =new HBox();
		HBox hb7 = new HBox();
		hb1.getChildren().addAll(label2,editCity,label3,editState);
		hb2.getChildren().addAll(label1,editZip,label4,editCountry);
		hb3.getChildren().addAll(label6, editNumofVisitor,label7,editHotelStay);
		hb5.getChildren().addAll(label5,editVisitType);
		hb6.getChildren().addAll(label8,editVisitDetails);
		hb4.getChildren().addAll(updateButton,deleteButton);
		hb7.getChildren().addAll(label9,editEmail);
		

		VBox hb = new VBox();
		hb.getChildren().addAll(mainLabel,hb1,hb2,hb5,hb6, hb3,hb7,hb4 );
		hb.setSpacing(15);
		hb1.setSpacing(15);
		hb2.setSpacing(15);
		hb3.setSpacing(15);
		hb4.setSpacing(25);
		hb4.setAlignment(Pos.BOTTOM_CENTER);
		hb4.setPadding(new Insets(0,45,0,0));
		hb5.setSpacing(15);
		hb6.setSpacing(15);
		hb7.setSpacing(15);

		vBoxForDisplay.getChildren().add(hb);
		
		updateButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				

				updateZip=editZip.getText();
				updateCity=editCity.getText();
				updateState=editState.getValue();
				updateCountry=editCountry.getText();
				updateVisitType=editVisitType.getValue();
				updateNumofVisitor=editNumofVisitor.getValue();
				updateHotelStay=editHotelStay.getValue();
				updateVisitDetails=editVisitDetails.getText();
				updateEmail=editEmail.getText();
			
			
				
				if(selectedRowNumber==0){
					    Alert a = new Alert(AlertType.ERROR);
				        a.setTitle("Missing Selection");
				        a.initStyle(StageStyle.UNDECORATED);
				        a.setContentText("Please select a record from the table.");
				        a.showAndWait();
				}
				else{
				try{

					
					Connection conn = DBConnection.connect();

					String updateQuery="UPDATE VisitorInformation SET zipCode= '"+updateZip+"' , city='"+updateCity+"',state='"+updateState+"', country='"+updateCountry+"',visitType='"+updateVisitType+"',numOfVisitors='"+updateNumofVisitor+"',visitDetails='"+updateVisitDetails+"',placeOfStay='"+updateHotelStay+"',email_ID='"+updateEmail+"' WHERE SN='"+selectedRowPrimaryKey+"'";

					Statement stmt = conn.createStatement();
					stmt.executeUpdate(updateQuery);
					
					
					editVisitorSelectedInTable(e);
					
					 Alert a1 = new Alert(AlertType.INFORMATION);
				        a1.setTitle("Record Updated");
				        a1.initStyle(StageStyle.UNDECORATED);
				        a1.setContentText("The selected record was updated!");
				        a1.showAndWait();
					
					
					selectedRowNumber=0;
}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				
			}
		});


		deleteButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				

		if(selectedRowNumber==0){			
			    Alert a = new Alert(AlertType.ERROR);
		        a.setTitle("Missing Selection");
		        a.initStyle(StageStyle.UNDECORATED);
		        a.setContentText("Please select a record from the table.");
		        a.showAndWait();
				}
else {
	Alert alert =new Alert (AlertType.CONFIRMATION);
	alert.setTitle("Confirmation Dialog");
	alert.setHeaderText(null);
	alert.setResizable(false);
	alert.initStyle(StageStyle.UNDECORATED);
    alert.setHeight(150);
	alert.setWidth(300);
	
	alert.setContentText("Are you sure you want delete the selected record?");
	Optional <ButtonType> action =alert.showAndWait();
	
	
	
	if (action.get() ==ButtonType.OK)
	{
		try{


					Connection conn = DBConnection.connect();

					String deleteQuery="DELETE FROM VisitorInformation WHERE SN='"+selectedRowPrimaryKey+"'";
					PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(deleteQuery);
					//preparedStmt.setInt(1,selectedRowPrimaryKey );
					preparedStmt.execute();

					String dropPKQuery="ALTER TABLE LoginInformation.VisitorInformation DROP SN";
					String reinitializePKQuery="ALTER TABLE LoginInformation.VisitorInformation ADD SN MediumINT NOT NULL AUTO_INCREMENT Primary key First;";
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(dropPKQuery);
					stmt.executeUpdate(reinitializePKQuery);

					editVisitorSelectedInTable(e);
					
					 Alert b = new Alert(AlertType.INFORMATION);
				        b.setTitle("Successfully Deleted");
				        b.initStyle(StageStyle.UNDECORATED);
				        b.setContentText("The selected record was successfully deleted.");
				        b.showAndWait();
					
					
					
					selectedRowNumber=0;
		}

				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

	}
	}
			}
		});


/*
 * Method for the analyze button
 */

	}
	@FXML
	public void analyzeGeneral(ActionEvent event) 
	{
		createTextBox();


		importCSVButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				int check=0;
				queryAnalysis(check);
				Alert a = new Alert(AlertType.INFORMATION);
		        a.setTitle("Successful");
		        a.initStyle(StageStyle.UNDECORATED);
		        a.setContentText("Report successfully created");
		        a.showAndWait();
				//analyzeGeneral(e);


			}
		});

		submitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				int check=1;
				queryAnalysis(check);
				
			}
		});
	}

	
	/*
	 * Method to analyze the queries
	 */

	private void queryAnalysis(int check) {


		inputZipCode = txtFieldZip.getText();
		inputCity=txtFieldCity.getText();

		inputState=txtFieldState.getValue();
		inputCountry=txtFieldCountry.getText();

		inputPurpose=purpose.getValue();

		inputHotel=txtFieldHotelstay.getValue();



		try {

			LocalDate startDateValue = startDate.getValue();


			LocalDate endDateValue = endDate.getValue();



			Connection conn = myDataBase.connect();
			data = FXCollections.observableArrayList();
			

			//Query to run for analysis
			String analyzeQuery = "";
					// Execute query and store result in a resultset with matching input conditions
			if (startDateValue==null || endDateValue==null){

				analyzeQuery = "SELECT city, state,zipCode, country, visitType, visitDetails, numOfVisitors, placeOfStay, email_ID, timestamp FROM VisitorInformation WHERE ";

				if (!inputZipCode.equals(""))
				{
					analyzeQuery += "zipCode =  '"+inputZipCode+"' ";

				}

				if (!inputCity.equals(""))
				{
					if (inputZipCode.equals(""))
					{
						analyzeQuery += "city = '"+inputCity+"' ";
					}
					else if (!inputZipCode.equals(""))
					{
						analyzeQuery += "AND city = '"+inputCity+"' ";
					}
				}

				if (!inputState.equals(""))
				{
					if (inputZipCode.equals("") && inputCity.equals("")){
						analyzeQuery += "state = '"+inputState+"' ";
					}
					else if (!inputZipCode.equals("") || !inputCity.equals(""))
					{
						analyzeQuery += "AND state = '"+inputState+"' ";
					}

				}

				if (!inputCountry.equals(""))
				{
					if (inputZipCode.equals("") && inputCity.equals("") && inputState.equals(""))
					{
						analyzeQuery += "country ='"+inputCountry+"' ";
					}
					else if (!inputZipCode.equals("") || !inputCity.equals("") || !inputState.equals(""))
					{
						analyzeQuery += "AND country = '"+inputCountry+"' ";
					}

				}

				if(!inputPurpose.equals(""))
				{
					if (inputZipCode.equals("") && inputCity.equals("") && inputState.equals("") && inputCountry.equals(""))
					{
						analyzeQuery += "visitType = '"+inputPurpose+"' ";
					}
					else if (!inputZipCode.equals("") || !inputCity.equals("") || !inputState.equals("") || !inputCountry.equals(""))
					{
						analyzeQuery += " AND visitType = '"+inputPurpose+"' ";
					}
				}

				if(!inputHotel.equals(""))
				{
					if (inputZipCode.equals("") && inputCity.equals("") && inputState.equals("") && inputCountry.equals("") && inputPurpose.equals(""))
					{
						analyzeQuery +="placeOfStay = '"+inputHotel+"' ";
					}
					else if (!inputZipCode.equals("") || !inputCity.equals("") || !inputState.equals("") || !inputCountry.equals(""))
					{
						analyzeQuery += " AND placeOfStay = '"+inputHotel+"' ";
					}
				}


			}



			else if (!startDate.equals("") && !endDate.equals(""))
			{
				analyzeQuery ="SELECT city, state,zipCode, country, visitType, visitDetails, numOfVisitors, placeOfStay, email_ID, timestamp FROM VisitorInformation WHERE timestamp >= '"+startDateValue+"' AND timestamp <= '"+endDateValue+"'" ;

				if (!inputZipCode.equals(""))
				{
					analyzeQuery += " AND zipCode =  '"+inputZipCode+"' ";
				}

				if (!inputCity.equals(""))
				{

					analyzeQuery += " AND city = '"+inputCity+"' ";
				}

				if (!inputState.equals(""))
				{

					analyzeQuery += " AND state = '"+inputState+"' ";

				}

				if (!inputCountry.equals(""))
				{

					analyzeQuery += " AND country = '"+inputCountry+"' ";

				}

				if (!inputPurpose.equals(""))
				{

					analyzeQuery += " AND visitType = '"+inputPurpose+"' ";

				}
				if (!inputHotel.equals(""))
				{

					analyzeQuery += " AND placeOfStay = '"+inputHotel+"' ";

				}

			}
			
			String sumVisitor="SELECT SUM(numOfVisitors) AS VISTORSUM FROM ("+analyzeQuery+") AS T";
			Statement stmt = conn.createStatement();
			ResultSet rs = (ResultSet)stmt.executeQuery(sumVisitor);
			int k = 0;
			while(rs.next()){
				 k=rs.getInt(1);
			}
			txtFieldVisitorSum.setText(Integer.toString(k));
		
			importDataFromDBToHomeTable(analyzeQuery);
			
			if (check==0){
				exportAsCSV(analyzeQuery);
			}


conn.close();
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	} 
/*
 * Method to display the records from tableview
 */
	private void importDataFromDBToHomeTable(String dbQuery)
	{
		try (Connection connection = myDataBase.getConnection())
		{
			Connection conn = myDataBase.connect();
			data = FXCollections.observableArrayList();
			ResultSet rs = null;
			// Execute query and store result in a resultset

			rs = conn.createStatement().executeQuery(dbQuery);

			int serialNumber = 1;
			myTable.setItems(null);
			while (rs.next()) 
			{
				//get string from db,whichever way 
				data.add(new Visitors(serialNumber, rs.getString(1),rs.getString(2),  rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),
						rs.getString(8),rs.getString(9),rs.getString(10)));


				serialNumberColumn.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
				cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
				stateColumn.setCellValueFactory(new PropertyValueFactory<>("stateName"));
				zipColumn.setCellValueFactory(new PropertyValueFactory<>("zipCode"));
				countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
				purposeColumn.setCellValueFactory(new PropertyValueFactory<>("visitType"));
				detailsColumn.setCellValueFactory(new PropertyValueFactory<>("visitDetails"));
				numVisitorColumn.setCellValueFactory(new PropertyValueFactory<>("numOfVisitors"));
				hotelStayColumn.setCellValueFactory(new PropertyValueFactory<>("placeOfStay"));
				emailIDColumn.setCellValueFactory(new PropertyValueFactory<>("email_ID"));
				dateTimeColumn.setCellValueFactory(new PropertyValueFactory<>("timestamp"));


				myTable.setItems(data);
				serialNumber++;
			}
			conn.close();
		}

		catch (Exception e)
		{
			e.printStackTrace();
		}

	}





	public void exportAsCSV(String read){
		String filename=currentDate+" Report.csv";

		try (Connection connection = DBConnection.getConnection())
		{
			FileWriter fw = new FileWriter(filename);	

			Statement stmt = connection.createStatement();
			ResultSet rstate2 ;
			rstate2=(ResultSet) stmt.executeQuery(read);

			fw.append("City");
			fw.append(',');
			fw.append("State");
			fw.append(',');
			fw.append("Zip Code");
			fw.append(',');
			fw.append("Country");
			fw.append(',');
			fw.append("Type of Visit");
			fw.append(',');
			fw.append("Visit Details");
			fw.append(',');
			fw.append("Number of Visitors");
			fw.append(',');
			fw.append("Staying in Hotel");
			fw.append(',');
			fw.append("Email");
			fw.append(',');
			fw.append("Date & Time");
			fw.append('\n');

			while (rstate2.next()){

				fw.append(rstate2.getString(1));
				fw.append(',');
				fw.append(rstate2.getString(2));
				fw.append(',');
				fw.append(rstate2.getString(3));
				fw.append(',');
				fw.append(rstate2.getString(4));
				fw.append(',');
				fw.append(rstate2.getString(5));
				fw.append(',');
				fw.append(rstate2.getString(6));
				fw.append(',');
				fw.append(rstate2.getString(7));
				fw.append(',');
				fw.append(rstate2.getString(8));
				fw.append(',');
				fw.append(rstate2.getString(9));
				fw.append(',');
				fw.append(rstate2.getString(10));

				fw.append('\n');
			}
			fw.flush();
			fw.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}


	}
	private String inputLatitude;
	private String inputLongitude;
	
	@FXML
	public void analyzeProximity(ActionEvent event)
	{
		vBoxForDisplay.getChildren().clear();
		vBoxForDisplay.setSpacing(15);
		
		Label action = new Label("Please enter the City and select range in miles.");
		action.getStyleClass().add("instructionLabel");
		
		proximityCity = new TextField();
		proximityCity.setPromptText("Enter City, State");
		
	    
		proximityRange = new ComboBox<String>();
		proximityRange.setPromptText("Select range in miles");
		proximityRange.getItems().addAll("100","200","300","400","500");
		proximityRange.setEditable(true);
		
		Label visitorSumLabel =new Label("The total number of visitor is: ");
		
		txtFieldVisitorSum= new TextField();
		txtFieldVisitorSum.setPrefWidth(100);
		txtFieldVisitorSum.setPrefHeight(40);
		txtFieldVisitorSum.setFocusTraversable(false);
		
		HBox hb = new HBox();
		hb.getChildren().addAll(visitorSumLabel,txtFieldVisitorSum);
		
		
		
		proximityButton = new Button("Submit");
		proximityButton.setId("proximityButtonId");
		
		proximityCSVButton = new Button("GenerateCSV");
		proximityCSVButton.setId("btnCSV");
		
		
		
		vBoxForDisplay.getChildren().addAll(action,proximityCity,proximityRange,proximityButton,proximityCSVButton,hb);
		
		proximityButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				
				inputProximityCity= proximityCity.getText();
				distance=proximityRange.getValue();
				
				if (inputProximityCity.equals(null) || distance.equals(null))
				 {
				Alert a = new Alert(AlertType.ERROR);
		        a.setTitle("Missing Input");
		        a.initStyle(StageStyle.UNDECORATED);
		        a.setContentText("Please enter city name and the range in miles");
		        a.showAndWait();
				 }
				 try {
					// System.out.println(inputProximityCity);
					 String latLongs[] = getLatLongPositions(inputProximityCity);
					
					 inputLatitude=latLongs[0];
						inputLongitude=latLongs[1];
						
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				 String query= "SELECT city, state,zipCode, country, visitType, visitDetails, numOfVisitors, placeOfStay, email_ID, timestamp FROM ( SELECT *,(((acos(sin(('"+inputLatitude+"'*(22/7)/180)) * sin((latitude*(22/7)/180))+cos(('"+inputLatitude+"'*(22/7)/180)) * cos((latitude*(22/7)/180)) * cos((('"+inputLongitude+"' - longitude)*(22/7)/180))))*180/(22/7))*60*1.1515) AS D FROM VisitorInformation) t WHERE D < '"+distance+"'";
				 
				 
				 try {

						

						Connection conn = myDataBase.connect();
				 String sumVisitor="SELECT SUM(numOfVisitors) AS VISTORSUM FROM ("+query+") AS T";
					Statement stmt = conn.createStatement();
					ResultSet rs = (ResultSet)stmt.executeQuery(sumVisitor);
					int k = 0;
					while(rs.next()){
						 k=rs.getInt(1);
					}
					txtFieldVisitorSum.setText(Integer.toString(k));
				 }
				 catch (Exception pr)
					{
						pr.printStackTrace();
					}
				 
				 importDataFromDBToHomeTable(query); 
				
				
				


			}
		});
		
		proximityCSVButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				
				inputProximityCity= proximityCity.getText();
				distance=proximityRange.getValue();
				
				if (inputProximityCity.equals(null) || distance.equals(null))
				 {
				Alert a = new Alert(AlertType.ERROR);
		        a.setTitle("Missing Input");
		        a.initStyle(StageStyle.UNDECORATED);
		        a.setContentText("Please enter city name and the range in miles");
		        a.showAndWait();
				 }
				 try {
					// System.out.println(inputProximityCity);
					 String latLongs[] = getLatLongPositions(inputProximityCity);
					
					 inputLatitude=latLongs[0];
						inputLongitude=latLongs[1];
						
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				 String query= "SELECT city, state,zipCode, country, visitType, visitDetails, numOfVisitors, placeOfStay, email_ID, timestamp FROM ( SELECT *,(((acos(sin(('"+inputLatitude+"'*(22/7)/180)) * sin((latitude*(22/7)/180))+cos(('"+inputLatitude+"'*(22/7)/180)) * cos((latitude*(22/7)/180)) * cos((('"+inputLongitude+"' - longitude)*(22/7)/180))))*180/(22/7))*60*1.1515) AS D FROM VisitorInformation) t WHERE D < '"+distance+"'";
				 
				 try {

						

						Connection conn = myDataBase.connect();
				 String sumVisitor="SELECT SUM(numOfVisitors) AS VISTORSUM FROM ("+query+") AS T";
					Statement stmt = conn.createStatement();
					ResultSet rs = (ResultSet)stmt.executeQuery(sumVisitor);
					int k = 0;
					while(rs.next()){
						 k=rs.getInt(1);
					}
					txtFieldVisitorSum.setText(Integer.toString(k));
				 }
				 catch (Exception pr)
					{
						pr.printStackTrace();
					}
				 importDataFromDBToHomeTable(query); 
				 exportAsCSV(query);
				
				
				


			}
		});
	}
	
	
	
		
	 public static String[] getLatLongPositions(String inputProximityCity) throws Exception
		  {
			  int responseCode = 0;
			    String api = "http://maps.googleapis.com/maps/api/geocode/xml?address=" + URLEncoder.encode(inputProximityCity, "UTF-8") + "&sensor=true";
			    URL url = new URL(api);
			    HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
			    httpConnection.connect();
			    responseCode = httpConnection.getResponseCode();
			    if(responseCode == 200)
			    {
			      DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();;
			      Document document = builder.parse(httpConnection.getInputStream());
			      XPathFactory xPathfactory = XPathFactory.newInstance();
			      XPath xpath = xPathfactory.newXPath();
			      XPathExpression expr = xpath.compile("/GeocodeResponse/status");
			      String status = (String)expr.evaluate(document, XPathConstants.STRING);
			      if(status.equals("OK"))
			      {
			         expr = xpath.compile("//geometry/location/lat");
			         String latitude = (String)expr.evaluate(document, XPathConstants.STRING);
			         expr = xpath.compile("//geometry/location/lng");
			         String longitude = (String)expr.evaluate(document, XPathConstants.STRING);
			         return new String[] {latitude, longitude};
			      }
			      else
			      {
			         throw new Exception("Error from the API - response status: "+status);
			      }
			    }
			    return null;
		    }


	@FXML
	public void analyzeEmail(ActionEvent event) 
	{
		vBoxForDisplay.getChildren().clear();
		vBoxForDisplay.setSpacing(15);
		
		Label action = new Label("Please select a range of date.");
		action.getStyleClass().add("instructionLabel");

		startDate = new DatePicker();
		startDate.setPromptText("Start Date MM/dd/yyyy");

		endDate = new DatePicker();
		endDate.setPromptText("End Date  MM/dd/yyyy");

		enterButton = new Button("Submit");
		enterButton.setId("btnEnterVisitor");
		
		generateEmailCSVButton = new Button ("Generate CSV");
		generateEmailCSVButton.setId("btnGenerateVisitor");

		vBoxForDisplay.getChildren().addAll(action, startDate, endDate, enterButton,generateEmailCSVButton);


		enterButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				
				if (startDate.getValue()==null && endDate.getValue()==null){
				Alert a2 = new Alert(AlertType.ERROR);
		        a2.setTitle("Missing Date Range");
		        a2.initStyle(StageStyle.UNDECORATED);
		        a2.setContentText("Please enter the date range!");
		        a2.showAndWait();
				}
				value=0;
				exportEmail(value);   
			}
		});
		generateEmailCSVButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				if (startDate.getValue()==null && endDate.getValue()==null){
					Alert a2 = new Alert(AlertType.ERROR);
			        a2.setTitle("Missing Date Range");
			        a2.initStyle(StageStyle.UNDECORATED);
			        a2.setContentText("Please enter the date range!");
			        a2.showAndWait();
					}
				else {
				value=1;
				exportEmail(value); 
				Alert a = new Alert(AlertType.INFORMATION);
		        a.setTitle("Successful");
		        a.initStyle(StageStyle.UNDECORATED);
		        a.setContentText("Report successfully created");
		        a.showAndWait();
				}
				
			}
		});

	}

	private void exportEmail(int value) {
		String filename = currentDate+" Email List.csv";
		try {

			LocalDate startDateValue = startDate.getValue();
			LocalDate endDateValue = endDate.getValue();


			FileWriter fw = new FileWriter(filename);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/logininformation", "root", "root");
			if (value==1){
			String query = "select distinct email_ID from VisitorInformation WHERE timestamp >= '"+startDateValue+"' AND timestamp <= '"+endDateValue+"'" ;
			Statement stmt = conn.createStatement();
			ResultSet rs = (ResultSet)stmt.executeQuery(query);
			fw.append("Email list");
			fw.append('\n');
			while (rs.next()) {

				fw.append(rs.getString(1));
				fw.append('\n');
			}
			fw.flush();
			fw.close();
}
			String emailQuery ="SELECT city, state,zipCode, country, visitType, visitDetails, numOfVisitors, placeOfStay, email_ID, timestamp FROM VisitorInformation WHERE timestamp >= '"+startDateValue+"' AND timestamp <= '"+endDateValue+"' AND SN IN (SELECT MIN(SN) FROM VisitorInformation GROUP BY email_ID)";

			importDataFromDBToHomeTable(emailQuery);


			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
