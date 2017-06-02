package nsida.kazey.labeler;


import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import nsida.kazey.labeler.view.RootLayoutController;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
				
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Компоновщик этикеток");
		
		initRootLayout();
				
	}

	private void initRootLayout() {

		try {
		
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));		
		
			this.rootLayout = (BorderPane)loader.load();
			
			RootLayoutController controller = loader.getController();
			controller.setMainApp(this);

			Scene scene = new Scene(this.rootLayout);
			this.primaryStage.setScene(scene);
			this.primaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Stage getPrimaryStage() {
        return this.primaryStage;
    }

}
