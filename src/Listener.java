
import java.awt.Component;
import java.awt.event.*;

public class Listener implements MouseListener {


    @Override
    public void mousePressed(MouseEvent e) {
	// Works
	 System.out.println("Mouse Pressed (" + e.getX() + "," + e.getY() + ")");
	 Var.panel.clicked(e);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
//	 System.out.println("Mouse Clicked (" + e.getX() + "," + e.getY() + ")");
	
    }

    @Override
    public void mouseReleased(MouseEvent e) {
	// Does nothing
//	 System.out.println("Mouse Released (" + e.getX() + "," + e.getY() + ")");
	
    }

    @Override
    public void mouseEntered(MouseEvent e) {
	// Works
//	 System.out.println("Mouse Entered (" + e.getX() + "," + e.getY() + ")");
	
    }

    @Override
    public void mouseExited(MouseEvent e) {
	// I dunno what this does
//	 System.out.println("Mouse Exited (" + e.getX() + "," + e.getY() + ")");
	
    }

}
