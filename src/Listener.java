
import java.awt.Component;
import java.awt.event.*;

public class Listener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
	 System.out.println("Mouse Clicked (" + e.getX() + "," + e.getY() + ")");
	
    }

    @Override
    public void mousePressed(MouseEvent e) {
	// Works
	 System.out.println("Mouse Pressed (" + e.getX() + "," + e.getY() + ")");
	
    }

    @Override
    public void mouseReleased(MouseEvent e) {
	 System.out.println("Mouse Released (" + e.getX() + "," + e.getY() + ")");
	
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

//    @Override
//    // Shows things like if shift is pressed
//    public void keyTyped(KeyEvent e) {
//	if (Var.PRINT_KEYTYPE) {
//	    System.out.print("KEY TYPED: ");
//	    printKeytype(e);
//	}
//
//	for(Component c : Var.frameElements) {
//	    if(c instanceof ImagePanel) {
//		ImagePanel panel = (ImagePanel)c;
//		panel.keyTyped(e);
//	    }
//	}
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//	if (Var.PRINT_KEYSTROKE) {
//	    System.out.print("KEY PRESSED: ");
//	    printKeystroke(e);
//	}
//
//	for(Component c : Var.frameElements) {
//	    if(c instanceof ImagePanel) {
//		ImagePanel panel = (ImagePanel)c;
//		panel.keyPressed(e);
//	    }
//	}
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//	if (Var.PRINT_KEYSTROKE) {
//	    System.out.print("KEY RELEASED: ");
//	    printKeystroke(e);
//	}
//
//	for(Component c : Var.frameElements) {
//	    if(c instanceof ImagePanel) {
//		ImagePanel panel = (ImagePanel)c;
//		panel.keyReleased(e);
//	    }
//	}
//    }
//
//    public void printKeystroke(KeyEvent e) {
//	if (Var.PRINT_KEYSTROKE) {
//	    System.out.println(KeyEvent.getKeyText(e.getKeyCode()));
//	}
//    }
//
//    public void printKeytype(KeyEvent e) {
//	if (Var.PRINT_KEYTYPE) {
//	    System.out.println(e.getKeyChar());
//	}
//    }
}
