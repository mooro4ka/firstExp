package nsida.kazey.labeler.view;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.TextInputControl;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;


public class CurrentLabelEvents implements EventHandler<MouseEvent>{


	private final RootLayoutController controller;
	
	@Override
	public void handle(MouseEvent event) {

		if (event.getEventType() == MouseEvent.MOUSE_CLICKED && event.getButton() == MouseButton.PRIMARY) {
			
			if (controller.getRootLayout().getCursor() == Cursor.CLOSED_HAND && controller.getNewField() != null) {
				
				controller.getNewField().setLayoutX(event.getX());
				controller.getNewField().setLayoutY(event.getY());
				
				controller.getCurrentLabel().getChildren().add(controller.getNewField());
							
			}
			else {
				
				for (Node currentElement : controller.getCurrentLabel().getChildren())
					((TextInputControl)currentElement).setEditable(false);
				
			}
			
			controller.getRootLayout().setCursor(null);
			controller.getRootLayout().requestFocus();
			controller.setNewField(null);
			
		}
		
	}
	
	
	public CurrentLabelEvents(RootLayoutController controller) {

		this.controller = controller;
		
	}

}
