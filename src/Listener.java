
import java.awt.Component;
import java.awt.event.*;

public class Listener implements MouseListener {
    
    @Override
    public void mousePressed(MouseEvent e) {
	System.out.println("Mouse Pressed (" + e.getX() + "," + e.getY() + ")");

    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
