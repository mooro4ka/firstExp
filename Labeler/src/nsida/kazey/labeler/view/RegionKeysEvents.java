package nsida.kazey.labeler.view;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

public class RegionKeysEvents implements EventHandler<KeyEvent> {

	
	Region region;
	
	Pane currentPane;
	
	
	public RegionKeysEvents(Region region, Pane currentPane) {

		this.region = region;
		this.currentPane = currentPane;
		
	}
	
	
	@Override
	public void handle(KeyEvent event) {
		
		switch (event.getCode().getName()) {
			
			case "Left":
				region.setLayoutX(region.getLayoutX() - 2);
				break;
				
			case "Right":
				region.setLayoutX(region.getLayoutX() + 2);
				break;

			case "Up":
				region.setLayoutY(region.getLayoutY() - 2);
				break;

			case "Down":
				region.setLayoutY(region.getLayoutY() + 2);
				break;
				
			case "Delete":
				currentPane.getChildren().remove(region);
				currentPane.requestFocus();
				break;

		}
		
	}
	

}
