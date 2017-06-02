package nsida.kazey.labeler.view;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import nsida.kazey.labeler.MainApp;


public class RootLayoutController {
	
	private Pane currentLabel;

	public Pane getCurrentLabel() {
		return currentLabel;
	}

	
	private Region newRegion;
	
	public Region getNewField() {
		return this.newRegion;
	}
	
	public void setNewField(Region newRegion){
		this.newRegion = newRegion;
	}
		
	
	@SuppressWarnings("unused")
	private MainApp mainApp;

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	
	public RootLayoutController() {
		
	}
	
	
	@FXML
	private Button newLabel;
	@FXML
	private Button newTitle1;
	@FXML
	private AnchorPane workSpace;
	@FXML
	private BorderPane rootLayout;

	public BorderPane getRootLayout() {
		return rootLayout;
	}
	
	
	@FXML
	private void initialize() {
		
	}

	
	@FXML 
	private void handleNewLabel() {
		
		currentLabel = new Pane();
		
		currentLabel.setStyle("-fx-background-color: papayawhip");
		currentLabel.setPrefHeight(300.00);
		currentLabel.setPrefWidth(300.00);
		currentLabel.addEventHandler(MouseEvent.ANY, new CurrentLabelEvents(this));
		
		workSpace.getChildren().clear();
		workSpace.getChildren().add(currentLabel);
		
		AnchorPane.setTopAnchor(currentLabel, 50.00);
		AnchorPane.setLeftAnchor(currentLabel, 50.00);
		
		getRootLayout().setCursor(null);
		
	}
	
	
	@FXML 
	void handleNewTitle1() {
		
		if (currentLabel != null) {

			newRegion = new TextField("Наименование 1");
			
			newRegion.addEventHandler(MouseEvent.ANY, new RegionsMouseEvents(newRegion));
			newRegion.setOnKeyPressed(new RegionKeysEvents(newRegion, currentLabel));
			
			((TextInputControl)newRegion).setEditable(false);
						
			getRootLayout().setCursor(Cursor.CLOSED_HAND);
			
		}
		
	}
	
	
	@FXML 
	void handleNewTitle2() {
	
		if (currentLabel != null) {

			newRegion = new TextField("Наименование 2");
			
			newRegion.addEventHandler(MouseEvent.ANY, new RegionsMouseEvents(newRegion));
			newRegion.setOnKeyPressed(new RegionKeysEvents(newRegion, currentLabel));
			
			((TextInputControl)newRegion).setEditable(false);
						
			getRootLayout().setCursor(Cursor.CLOSED_HAND);
			
		}
		
	}
	
	
	@FXML 
	void handleNewInfo() {
	
		if (currentLabel != null) {

			newRegion = new TextArea();
			
			newRegion.addEventHandler(MouseEvent.ANY, new RegionsMouseEvents(newRegion));
			newRegion.setOnKeyPressed(new RegionKeysEvents(newRegion, currentLabel));
			newRegion.setPrefHeight(10);
			newRegion.setPrefWidth(50);
			
			((TextInputControl)newRegion).setPromptText("Введите любой текст");
			((TextInputControl)newRegion).setEditable(false);
			
			((TextArea)newRegion).setWrapText(true);
			
			getRootLayout().setCursor(Cursor.CLOSED_HAND);
			
		}
		
	}


	@FXML 
	void handleNewBarcode() {

		if (currentLabel != null) {

			newRegion = new TextField("Штрихкод");
			
			newRegion.addEventHandler(MouseEvent.ANY, new RegionsMouseEvents(newRegion));
			newRegion.setOnKeyPressed(new RegionKeysEvents(newRegion, currentLabel));
			
			((TextInputControl)newRegion).setEditable(false);
						
			getRootLayout().setCursor(Cursor.CLOSED_HAND);
			
		}
		
	}
	
	
	@FXML 
	void handleNewDateOfPacking() {
	
		if (currentLabel != null) {

			newRegion = new TextField("ДД-ММ-ГГ");
			
			newRegion.addEventHandler(MouseEvent.ANY, new RegionsMouseEvents(newRegion));
			newRegion.setOnKeyPressed(new RegionKeysEvents(newRegion, currentLabel));
			
			((TextInputControl)newRegion).setEditable(false);
						
			getRootLayout().setCursor(Cursor.CLOSED_HAND);
			
		}
		
	}
	
	
}
