
import java.util.ArrayList;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
	runInit();
	// while (true) {
	// runLoop();
	//// wait(1000);
	// }
    }
    
    private static void runInit() {
	long time = System.currentTimeMillis();
	Var.frame = new JFrame("Physics Version " + Var.VERSION);
	Var.frame.setBackground(Var.backgroundColor);
	Var.frameElements = new ArrayList<ImagePanel>();
	
	System.out.println("Loading...");
	
	Var.frame.setSize(140, 60);
	JLabel text = new JLabel("<html><h1>Loading...</h1></html>");
	Var.frame.add(text);
	
	Var.frame.repaint();
	Var.frame.setVisible(true);
	
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
	
	Var.ironClaw = new ImagePanel("./src/IronClaw.png");
	Var.ironClaw.setLoc(25, 670);
	Var.frameElements.add(Var.ironClaw);
	
	// Necessary to get the last element entered to work pre-loop
	// The following code doesn't add anything though
	Var.panel = new ImagePanel();
	Var.frameElements.add(Var.panel);
	
	for (Component c : Var.frameElements) {
	    Var.frame.add(c);
	}
	
	hide();
	ProblemManagement.init();
	
	Var.frame.repaint();
	Var.frame.setVisible(true);
	
	Var.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	runLoop(); // Does it once.
	nextMode();
	System.out.println("Ready in " + (System.currentTimeMillis() - time) + " milliseconds...");
	
	Var.frame.remove(text);
	
	Var.frame.setSize(Var.MAX_WIDTH, Var.MAX_HEIGHT);
    }
    
    private static void hide() {
	questionVisible(false);
	answerSelectionVisible(false);
	answerExplanationVisible(false);
	correctVisible(false);
	incorrectVisible(false);
	Var.frame.setBackground(Var.backgroundColor);
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
	    // case Var.INTRO:
	    // nextMode();
	    case Var.SELECT_ANSWER:
		for (ImagePanel c : Var.frameElements) {
		    if (c.isVisible() && c.checkClicked(x, y)) { // visible and
								 // clicked
			if (c instanceof AnswerBox) {
			    nextMode();
			} else {
			}
		    } else {
		    }
		}
		break;
	    case Var.CORRECT_ANSWER:
		nextMode();
		break;
	    case Var.INCORRECT_ANSWER:
		nextMode();
		break;
	    case Var.ANSWER_EXPLANATION:
		nextMode();
		break;
	    default:
		return;
	}
    }
    
    public static void nextMode() {
	switch (Var.mode) {
	    case Var.INTRO:
		Var.mode = Var.SELECT_ANSWER;
		Var.problem = ProblemManagement.getProblem();
		break;
	    case Var.SELECT_ANSWER:
		if (checkAnswer()) {
		    Var.mode = Var.CORRECT_ANSWER;
		} else {
		    Var.mode = Var.INCORRECT_ANSWER;
		}
		break;
	    case Var.CORRECT_ANSWER:
		Var.mode = Var.ANSWER_EXPLANATION;
		break;
	    case Var.INCORRECT_ANSWER:
		Var.mode = Var.ANSWER_EXPLANATION;
		break;
	    case Var.ANSWER_EXPLANATION:
		Var.mode = Var.SELECT_ANSWER;
		Var.problem = ProblemManagement.getProblem();
		break;
	    default:
		System.out.println("Oh, no! Defaulting on switch statement! Var.mode = " + Var.mode);
		break;
	}
	updateScreen();
    }
    
    public static void updateScreen() {
	Var.frame.setBackground(Var.backgroundColor);
	switch (Var.mode) {
	    case Var.INTRO:
		questionVisible(false);
		answerSelectionVisible(false);
		answerExplanationVisible(false);
		correctVisible(false);
		incorrectVisible(false);
		Var.frame.setBackground(Var.backgroundColor);
		break;
	    case Var.SELECT_ANSWER:
		questionVisible(true);
		answerSelectionVisible(true);
		answerExplanationVisible(false);
		correctVisible(false);
		incorrectVisible(false);
		break;
	    case Var.CORRECT_ANSWER:
		questionVisible(true);
		answerSelectionVisible(false);
		answerExplanationVisible(false);
		correctVisible(true);
		incorrectVisible(false);
		if (Var.streak == 3) {
		    JOptionPane.showMessageDialog(Var.frame, "3 in a row!");
		} else if (Var.streak == 5) {
		    JOptionPane.showMessageDialog(Var.frame, "5 straight!");
		} else if (Var.streak == 10) {
		    
		    JOptionPane.showMessageDialog(Var.frame, "10 in a row!");
		} else if (Var.streak == 75) {
		    JOptionPane.showMessageDialog(Var.frame,
			    "If this was the test, you would have aced it! 75 correct answers in a row!");
		} else {
		    JOptionPane.showMessageDialog(Var.frame, "Correct!");
		}
		break;
	    case Var.INCORRECT_ANSWER:
		questionVisible(true);
		answerSelectionVisible(false);
		answerExplanationVisible(false);
		correctVisible(false);
		incorrectVisible(true);
		JOptionPane.showMessageDialog(Var.frame, "Incorrect!");
		if (Var.streak == -4) {
		    JOptionPane.showMessageDialog(Var.frame, "Uh-oh! You'd be better off guessing...");
		} else if (Var.streak == -7) {
		    JOptionPane.showMessageDialog(Var.frame,
			    "That's 5 wrong. Maybe think a little longer or review some more?");
		} else if (Var.streak == -75) {
		    JOptionPane.showMessageDialog(Var.frame,
			    "You know what you're doing! You have just missed an entire test's worth of questions!");
		} else {
		    JOptionPane.showMessageDialog(Var.frame, "Incorrect!");
		}
		break;
	    case Var.ANSWER_EXPLANATION:
		questionVisible(true);
		answerSelectionVisible(false);
		answerExplanationVisible(true);
		correctVisible(false);
		incorrectVisible(false);
		break;
	    default:
		System.out.println("Oh, no! Defaulting on switch statement! Var.mode = " + Var.mode);
		break;
	}
	Var.frame.repaint();
	
    }
    
    private static void questionText() {
	JLabel text;
	Var.questionBox.removeAll();
	text = new JLabel(
		"<html><br /><br /><br /><br /><br /><br /><h1>" + Var.problem.getQuestion() + "</h1></html>");
	Var.questionBox.add(text);
    }
    
    private static void answerText() {
	Var.answerBox1.removeAll();
	Var.answerBox2.removeAll();
	Var.answerBox3.removeAll();
	Var.answerBox4.removeAll();
	Var.answerBox5.removeAll();
	JLabel text;
	text = new JLabel("<html><br /><br /><br /><br /><h1>" + Var.problem.getA() + "</h1></html>");
	Var.answerBox1.add(text);
	text = new JLabel("<html><br /><br /><br /><br /><h1>" + Var.problem.getB() + "</h1></html>");
	Var.answerBox2.add(text);
	text = new JLabel("<html><br /><br /><br /><br /><h1>" + Var.problem.getC() + "</h1></html>");
	Var.answerBox3.add(text);
	text = new JLabel("<html><br /><br /><br /><br /><h1>" + Var.problem.getD() + "</h1></html>");
	Var.answerBox4.add(text);
	text = new JLabel("<html><br /><br /><br /><br /><h1>" + Var.problem.getE() + "</h1></html>");
	Var.answerBox5.add(text);
    }
    
    private static void correctAnswerText() {
	Var.correctAnswerBox.removeAll();
	JLabel text;
	text = new JLabel("<html><br /><br /><br /><br /><h1>" + Var.problem.getCorrectAnswer() + "</h1></html>");
	Var.correctAnswerBox.add(text);
    }
    
    private static void answerExlpanationText() {
	Var.answerExplanationBox.removeAll();
	JLabel text;
	text = new JLabel("<html><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><h1>"
		+ Var.problem.getExplanation() + "</h1></html>");
	Var.answerExplanationBox.add(text);
    }
    
    private static void questionVisible(boolean flag) {
	for (ImagePanel c : Var.frameElements) {
	    if (c instanceof QuestionBox) {
		c.setVisible(flag);
		if (flag) {
		    questionText();
		}
	    }
	}
    }
    
    private static void answerSelectionVisible(boolean flag) {
	for (ImagePanel c : Var.frameElements) {
	    if (c instanceof AnswerBox) {
		c.setVisible(flag);
		if (flag) {
		    answerText();
		}
	    }
	}
	Var.ironClaw.setVisible(flag);
	Var.correctAnswerBox.add(new JLabel("<html><h1>Stats</h1></html>"));
    }
    
    private static void answerExplanationVisible(boolean flag) {
	for (ImagePanel c : Var.frameElements) {
	    if (c instanceof CorrectAnswerBox || c instanceof AnswerExplanationBox) {
		c.setVisible(flag);
		if (flag && c instanceof CorrectAnswerBox) {
		    correctAnswerText();
		}
		if (flag && c instanceof AnswerExplanationBox) {
		    answerExlpanationText();
		}
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
	boolean correct = Var.selectedAnswer.equals(Var.problem.getCorrectAnswer());
	if (correct) {
	    Var.correct++;
	    if (Var.streak < 0) {
		Var.streak = 1;
	    } else {
		Var.streak++;
	    }
	} else {
	    Var.incorrect++;
	    if (Var.streak > 0) {
		Var.streak = -1;
	    } else {
		Var.streak--;
	    }
	}
	return correct;
    }
}
