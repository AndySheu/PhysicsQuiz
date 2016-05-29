
import java.util.ArrayList;
import java.awt.Component;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
	runInit();
//	while (true) {
//	    runLoop();
////	    wait(1000);
//	}
    }
    
    private static void runInit() {
	Var.frame = new JFrame("Physics Version " + Var.VERSION);
	Var.frameElements = new ArrayList<ImagePanel>();
	
	Var.frame.setSize(Var.MAX_WIDTH, Var.MAX_HEIGHT);
	
	if (Var.TESTING) {
	    Var.frame.setResizable(true);
	    Var.frame.setAlwaysOnTop(false);
	} else {	
	    Var.frame.setResizable(false);
	    Var.frame.setAlwaysOnTop(true);
	}
	
	Var.listener = new Listener();
	Var.frame.addMouseListener(Var.listener);
	
	Var.questionBox = new QuestionBox("./src/QuestionBox.png");
	Var.questionBox.setLoc(125,-25);
	Var.frameElements.add(Var.questionBox);
	
	Var.answerBox1 = new AnswerBox("./src/AnswerBox.png", 1);
	Var.answerBox1.setLoc(200,250);
	Var.frameElements.add(Var.answerBox1);
	
	Var.answerBox2 = new AnswerBox("./src/AnswerBox.png", 2);
	Var.answerBox2.setLoc(750,250);
	Var.frameElements.add(Var.answerBox2);
	
	Var.answerBox3 = new AnswerBox("./src/AnswerBox.png", 3);
	Var.answerBox3.setLoc(200,450);
	Var.frameElements.add(Var.answerBox3);
	
	Var.answerBox4 = new AnswerBox("./src/AnswerBox.png", 4);
	Var.answerBox4.setLoc(750,450);
	Var.frameElements.add(Var.answerBox4);
	
	Var.answerBox5 = new AnswerBox("./src/AnswerBox.png", 5);
	Var.answerBox5.setLoc(475,650);
	Var.frameElements.add(Var.answerBox5);
	
	// Necessary to get box #5 to work pre-loop
	Var.panel = new ImagePanel();
	Var.frameElements.add(Var.panel);
//	Var.answerBox6.setVisible(true);
	
	for (Component c : Var.frameElements) {
	    Var.frame.add(c);
	}
	
	Var.frame.repaint();
	Var.frame.setVisible(true);
	
	Var.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	runLoop(); // Does it once.
    }
    
    private static void runLoop() {
	for (ImagePanel c : Var.frameElements) {
	    c.setLocation(c.x, c.y);
//	    c.repaint();
	}
    }
    
    private static void wait(int millis) {
	long start = System.currentTimeMillis();
	while (System.currentTimeMillis() - start < millis) {
	
	}
    }
    
    public static void mousePressed(int x, int y) {
	for (ImagePanel c : Var.frameElements) {
	    if(c.checkClicked(x, y)) {
		nextMode();
	    }
	}
    }
    
    public static void nextMode() {
	switch(Var.mode) {
	    case Var.SELECT_ANSWER:
		if (checkAnswer()) {
		    Var.mode = Var.ANSWER_CORRECT;
		} else {
		    Var.mode = Var.ANSWER_INCORRECT;
		}
		answerVisible(false);
		break;
	    case Var.ANSWER_CORRECT:
		Var.mode = Var.SELECT_ANSWER;
		answerVisible(true);
		break;
	    case Var.ANSWER_INCORRECT:
		Var.mode = Var.SELECT_ANSWER;
		answerVisible(true);
		break;
	    default:
		System.out.println("Oh, no! Defaulting on switch statement! Var.mode");
		break;
	}
    }
    
    private static void answerVisible(boolean flag) {
	for (ImagePanel c : Var.frameElements) {
	    if (c instanceof AnswerBox) {
	    	c.setVisible(flag);
	    }
	}
    }
    
    public static boolean checkAnswer() {
	return false;
    }
}
