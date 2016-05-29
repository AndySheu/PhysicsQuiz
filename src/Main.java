
import java.util.ArrayList;
import java.awt.Component;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
	runInit();
	while (true) {
	    runLoop();
//	    wait(1000);
	}
    }
    
    private static void runInit() {
	Var.frame = new JFrame("Physics Version " + Var.VERSION);
	Var.frameElements = new ArrayList<ImagePanel>();
	
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
	Var.panel.setLoc(-600, -100);
	Var.frameElements.add(Var.panel);
	
	Var.questionBox = new ImagePanel("./src/QuestionBox.png");
	Var.questionBox.addMouseListener(Var.listener);
	Var.questionBox.setLoc(125,-25);
	Var.frameElements.add(Var.questionBox);
	
	Var.answerBox1 = new ImagePanel("./src/AnswerBox.png");
	Var.answerBox1.addMouseListener(Var.listener);
	Var.answerBox1.setLoc(200,250);
	Var.frameElements.add(Var.answerBox1);
	
	Var.answerBox2 = new ImagePanel("./src/AnswerBox.png");
	Var.answerBox2.addMouseListener(Var.listener);
	Var.answerBox2.setLoc(750,250);
	Var.frameElements.add(Var.answerBox2);
	
	Var.answerBox3 = new ImagePanel("./src/AnswerBox.png");
	Var.answerBox3.addMouseListener(Var.listener);
	Var.answerBox3.setLoc(200,450);
	Var.frameElements.add(Var.answerBox3);
	
	Var.answerBox4 = new ImagePanel("./src/AnswerBox.png");
	Var.answerBox4.addMouseListener(Var.listener);
	Var.answerBox4.setLoc(750,450);
	Var.frameElements.add(Var.answerBox4);
	
	Var.answerBox5 = new ImagePanel("./src/AnswerBox.png");
	Var.answerBox5.addMouseListener(Var.listener);
	Var.answerBox5.setLoc(475,650);
	Var.frameElements.add(Var.answerBox5);
	
	for (Component c : Var.frameElements) {
	    Var.frame.add(c);
	}
	
	Var.frame.repaint();
	Var.frame.setVisible(true);
	
	Var.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private static void runLoop() {
	for (ImagePanel c : Var.frameElements) {
	    c.setLocation(c.x, c.y);
//	    c.repaint();
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
