package nsida.kazey.labeler.view;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputControl;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;

public class RegionsMouseEvents implements EventHandler<MouseEvent> {
	
	private final Region region;
	
	private static final double RESIZE_MARGIN = 5;
	
	private boolean bottomDraging;

	private boolean rightDragging;
	
	public RegionsMouseEvents(Region region) {
		
		this.region = region;
		
	}

	
	@Override
	public void handle(MouseEvent event) {
		
		if (event.getEventType() == MouseEvent.MOUSE_PRESSED)
			mousePressed(event);
		else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED)
			mouseDraged(event);
		else if (event.getEventType() == MouseEvent.MOUSE_MOVED)
			mouseOver(event);
		else if (event.getEventType() == MouseEvent.MOUSE_RELEASED)
			mouseReleased(event);
		else if (event.getEventType() == MouseEvent.MOUSE_CLICKED && event.getClickCount() == 2)
			mouseClicked(event);
	
	}
	

	private void mouseReleased(MouseEvent event) {
		
		bottomDraging = false;
		rightDragging = false;
		
		region.setCursor(null);
		
	}


	private void mouseOver(MouseEvent event) {
		
		if (isBottomDraggableZone(event))
			region.setCursor(Cursor.S_RESIZE);
		else if (isRightDraggableZone(event))
			region.setCursor(Cursor.H_RESIZE);
		else
			region.setCursor(null);
		
	}


	private void mouseDraged(MouseEvent event) {

		if (bottomDraging)
			region.setMinHeight(region.getMinHeight() +  event.getY() - region.getMinHeight());
		else if (rightDragging)
			region.setMinWidth(region.getMinWidth() +  event.getX() - region.getMinWidth());
		
	}


	private void mousePressed(MouseEvent event) {

		if (isBottomDraggableZone(event))
			bottomDraging = true;
		else if (isRightDraggableZone(event)) 
			rightDragging = true;
		
	}


	private void mouseClicked(MouseEvent event) {

		if (region instanceof TextArea)
			((TextInputControl)region).setEditable(true);
		
	}


	private boolean isBottomDraggableZone(MouseEvent event) {

		return event.getY() > region.getHeight() - RESIZE_MARGIN;

	}


	private boolean isRightDraggableZone(MouseEvent event) {
		
		return event.getX() > region.getWidth() - RESIZE_MARGIN;
		
	}

	
}
