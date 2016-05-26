
import java.util.ArrayList;
import java.awt.Component;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
	runInit();
	while (true) {
	    runLoop();
	    wait(1000 / Var.FPS); // Seconds per frame
	}
    }
    
    private static void runInit() {
	Var.frame = new JFrame("Physics Version " + Var.VERSION);
	Var.frameElements = new ArrayList<Component>();
	
	Var.listener = new Listener();
	Var.frame.setSize(Var.MAX_WIDTH, Var.MAX_HEIGHT);
	
	if (Var.TESTING) {
	    Var.frame.setResizable(true);
	    Var.frame.setAlwaysOnTop(false);
	} else {	
	    Var.frame.setResizable(false);
	    Var.frame.setAlwaysOnTop(true);
	}
	
	Var.panel = new ImagePanel("./src/GitHub-Mark.png");
	
	Var.panel.addMouseListener(Var.listener);
	Var.frameElements.add(Var.panel);
	
	for (Component c : Var.frameElements) {
	    Var.frame.add(c);
	}
	
	Var.frame.repaint();
	Var.frame.setVisible(true);
	
	Var.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private static void runLoop() {
	for (Component c : Var.frameElements) {
	    c.repaint();
	}
    }
    
    private static void wait(int millis) {
	for (Component c : Var.frameElements) {
	    Var.frame.add(c);
	}
	
	long start = System.currentTimeMillis();
	while (System.currentTimeMillis() - start < millis) {
	
	}
    }
}
