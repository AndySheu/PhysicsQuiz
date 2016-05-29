
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
	runInit();
	// while (true) {
	// runLoop();
	//// wait(1000);
	// }
    }
    
    private static void runInit() {
	Var.frame = new JFrame("Physics Version " + Var.VERSION);
	Var.frame.setBackground(Var.backgroundColor);
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
	
	Var.questionBox = new QuestionBox();
	Var.questionBox.setLoc(125, -25);
	Var.frameElements.add(Var.questionBox);
	
	Var.answerBox1 = new AnswerBox(1);
	Var.answerBox1.setLoc(200, 250);
	Var.frameElements.add(Var.answerBox1);
	
	Var.answerBox2 = new AnswerBox(2);
	Var.answerBox2.setLoc(750, 250);
	Var.frameElements.add(Var.answerBox2);
	
	Var.answerBox3 = new AnswerBox(3);
	Var.answerBox3.setLoc(200, 450);
	Var.frameElements.add(Var.answerBox3);
	
	Var.answerBox4 = new AnswerBox(4);
	Var.answerBox4.setLoc(750, 450);
	Var.frameElements.add(Var.answerBox4);
	
	Var.answerBox5 = new AnswerBox(5);
	Var.answerBox5.setLoc(475, 650);
	Var.frameElements.add(Var.answerBox5);
	
	Var.correctAnswerBox = new CorrectAnswerBox();
	Var.correctAnswerBox.setLoc(225, 250);
	Var.frameElements.add(Var.correctAnswerBox);

	Var.correctBox = new CorrectBox();
	Var.correctBox.setLoc(475, 250);
	Var.frameElements.add(Var.correctBox);

	Var.incorrectBox = new IncorrectBox();
	Var.incorrectBox.setLoc(400, 250);
	Var.frameElements.add(Var.incorrectBox);
	
	Var.answerExplanationBox = new AnswerExplanationBox();
	Var.answerExplanationBox.setLoc(225, 450);
	Var.frameElements.add(Var.answerExplanationBox);
	
	// Necessary to get the last element entered to work pre-loop
	// The following code doesn't add anything though
	Var.panel = new ImagePanel();
	Var.frameElements.add(Var.panel);
	
	for (Component c : Var.frameElements) {
	    Var.frame.add(c);
	}
	
	Var.frame.repaint();
	Var.frame.setVisible(true);
	
	Var.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	runLoop(); // Does it once.
	updateScreen();
    }
    
    private static void runLoop() {
	for (ImagePanel c : Var.frameElements) {
	    c.setLocation(c.x, c.y);
	    // c.repaint();
	}
    }
    
    private static void wait(int millis) {
	long start = System.currentTimeMillis();
	while (System.currentTimeMillis() - start < millis) {
	
	}
    }
    
    public static void mousePressed(int x, int y) {
	switch (Var.mode) {
	    case Var.SELECT_ANSWER:
		for (ImagePanel c : Var.frameElements) {
		    if (c.isVisible() && c.checkClicked(x, y)) { // visible and clicked
			if (c instanceof AnswerBox) {
			    nextMode();
			}
		    }
		}
		break;
	    case Var.CORRECT_ANSWER:
		nextMode();
		break;
	    case Var.INCORRECT_ANSWER:
		nextMode();
		break;
	}
	updateScreen();
    }
    
    public static void nextMode() {
	switch (Var.mode) {
	    case Var.SELECT_ANSWER:
		if (checkAnswer()) {
		    Var.mode = Var.CORRECT_ANSWER;
		} else {
		    Var.mode = Var.INCORRECT_ANSWER;
		}
		break;
	    case Var.CORRECT_ANSWER:
		Var.mode = Var.SELECT_ANSWER;
		break;
	    case Var.INCORRECT_ANSWER:
		Var.mode = Var.SELECT_ANSWER;
		break;
	    default:
		System.out.println("Oh, no! Defaulting on switch statement! Var.mode");
		break;
	}
    }
    
    public static void updateScreen() {
	Var.frame.setBackground(Var.backgroundColor);
	switch (Var.mode) {
	    case Var.SELECT_ANSWER:
		answerSelectionVisible(true);
		answerExplanationVisible(false);
		correctVisible(false);
		incorrectVisible(false);
		break;
	    case Var.CORRECT_ANSWER:
		answerSelectionVisible(false);
		answerExplanationVisible(false);
		correctVisible(true);
		incorrectVisible(false);
		break;
	    case Var.INCORRECT_ANSWER:
		answerSelectionVisible(false);
		answerExplanationVisible(false);
		correctVisible(false);
		incorrectVisible(true);
		break;
	    case Var.ANSWER_EXPLANATION:
		answerSelectionVisible(false);
		answerExplanationVisible(true);
		correctVisible(false);
		incorrectVisible(true);
	    default:
		System.out.println("Oh, no! Defaulting on switch statement! Var.mode");
		break;
	}
    }
    
    private static void answerSelectionVisible(boolean flag) {
	for (ImagePanel c : Var.frameElements) {
	    if (c instanceof AnswerBox) {
		c.setVisible(flag);
	    }
	}
    }
    
    private static void answerExplanationVisible(boolean flag) {
	for (ImagePanel c : Var.frameElements) {
	    if (c instanceof CorrectAnswerBox || c instanceof AnswerExplanationBox) {
		c.setVisible(flag);
	    }
	}
    }
    
    private static void correctVisible(boolean flag) {
	for (ImagePanel c : Var.frameElements) {
	    if (c instanceof CorrectBox) {
		c.setVisible(flag);
	    }
	}
    }
    
    private static void incorrectVisible(boolean flag) {
	for (ImagePanel c : Var.frameElements) {
	    if (c instanceof IncorrectBox) {
		c.setVisible(flag);
	    }
	}
    }
    
    public static boolean checkAnswer() {
	return Math.random() > .5;
    }
}
