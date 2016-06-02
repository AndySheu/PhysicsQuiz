
import java.util.ArrayList;
import java.awt.Color;
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
	Var.frame = new JFrame("Physics Version " + Var.VERSION + " -- By Andy Sheu and Dhruv Jhamb (Period 5)");
	Var.frame.setBackground(Var.backgroundColor);
	Var.frameElements = new ArrayList<ImagePanel>();
	
	Menu.init();
	
	System.out.println("Loading...");
	
	Var.frame.setSize(140, 70);
	JLabel text = new JLabel("<html><h1>Loading...</h1></html>");
	text.setForeground(Color.red);
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
	Var.answerBox1.setLoc(200, 240);
	Var.frameElements.add(Var.answerBox1);
	
	Var.answerBox2 = new AnswerBox(2);
	Var.answerBox2.setLoc(750, 240);
	Var.frameElements.add(Var.answerBox2);
	
	Var.answerBox3 = new AnswerBox(3);
	Var.answerBox3.setLoc(200, 435);
	Var.frameElements.add(Var.answerBox3);
	
	Var.answerBox4 = new AnswerBox(4);
	Var.answerBox4.setLoc(750, 435);
	Var.frameElements.add(Var.answerBox4);
	
	Var.answerBox5 = new AnswerBox(5);
	Var.answerBox5.setLoc(475, 630);
	Var.frameElements.add(Var.answerBox5);
	
	Var.correctAnswerBox = new CorrectAnswerBox();
	Var.correctAnswerBox.setLoc(225, 240);
	Var.frameElements.add(Var.correctAnswerBox);
	
	Var.correctBox = new CorrectBox();
	Var.correctBox.setLoc(475, 250);
	Var.frameElements.add(Var.correctBox);
	
	Var.incorrectBox = new IncorrectBox();
	Var.incorrectBox.setLoc(400, 250);
	Var.frameElements.add(Var.incorrectBox);
	
	Var.answerExplanationBox = new AnswerExplanationBox();
	Var.answerExplanationBox.setLoc(225, 440);
	Var.frameElements.add(Var.answerExplanationBox);
	
	Var.ironClaw = new IronClaw();
	Var.ironClaw.setLoc(10, 640);
	JLabel txt = new JLabel("<html><br /><br /><br /><h1>Stats</h1></html>");
	txt.setForeground(Color.white);
	Var.ironClaw.add(txt);
	Var.frameElements.add(Var.ironClaw);
	
	Var.skipBox = new SkipBox();
	Var.skipBox.setLoc(1200, 700);
	Var.frameElements.add(Var.skipBox);
	
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
//	nextMode();
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
	Var.ironClaw.setVisible(false);
	Var.skipBox.setVisible(false);
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
	    case Var.INTRO:
		nextMode();
		break;
	    case Var.SELECT_ANSWER:
		for (ImagePanel c : Var.frameElements) {
		    if (c.isVisible() && c.checkClicked(x, y)) { // visible and
								 // clicked
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
    
    public static void skipQuestion() {
	Var.mode = Var.CORRECT_ANSWER;
	nextMode();
	nextMode();
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
		Var.ironClaw.setVisible(false);
		Var.skipBox.setVisible(false);
		Var.frame.setBackground(Var.backgroundColor);
		break;
	    case Var.SELECT_ANSWER:
		questionVisible(true);
		answerSelectionVisible(true);
		answerExplanationVisible(false);
		correctVisible(false);
		incorrectVisible(false);
		Var.ironClaw.setVisible(true);
		Var.skipBox.setVisible(true);
		break;
	    case Var.CORRECT_ANSWER:
		questionVisible(true);
		answerSelectionVisible(false);
		answerExplanationVisible(false);
		correctVisible(true);
		incorrectVisible(false);
		break;
	    case Var.INCORRECT_ANSWER:
		questionVisible(true);
		answerSelectionVisible(false);
		answerExplanationVisible(false);
		correctVisible(false);
		incorrectVisible(true);
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
	String question = Var.problem.getQuestion();
	while (!question.equals(question.replace(". ", ".<br /> "))) {
	    question = question.replace(". ", ".<br /> ");
	}
	while (!question.equals(question.replace("*", "<br />"))) {
	    question = question.replace("*", "<br />");
	}
	if (Var.TESTING) {
	    question += "<br />(" + ProblemManagement.getLineNumber() + ")";
	}
	text = new JLabel("<html><br /><br /><br /><br /><h1>" + question + "</h1></html>");
	text.setForeground(Color.yellow);
	Var.questionBox.add(text);
    }
    
    private static void answerText() {
	Var.answerBox1.removeAll();
	Var.answerBox2.removeAll();
	Var.answerBox3.removeAll();
	Var.answerBox4.removeAll();
	Var.answerBox5.removeAll();
	JLabel text;
	String a = Var.problem.getA();
	while (!a.equals(a.replace(". ", "<br /> "))) {
	    a = a.replace(". ", "<br /> ");
	}
	text = new JLabel("<html><br /><br /><br /><h1>" + a + "</h1></html>");
	Var.answerBox1.add(text);
	String b = Var.problem.getB();
	while (!b.equals(b.replace(". ", "<br /> "))) {
	    b = b.replace(". ", "<br /> ");
	}
	text = new JLabel("<html><br /><br /><br /><h1>" + b + "</h1></html>");
	Var.answerBox2.add(text);
	String c = Var.problem.getC();
	while (!c.equals(c.replace(". ", "<br /> "))) {
	    c = c.replace(". ", "<br /> ");
	}
	text = new JLabel("<html><br /><br /><br /><h1>" + c + "</h1></html>");
	Var.answerBox3.add(text);
	String d = Var.problem.getD();
	while (!d.equals(d.replace(". ", "<br /> "))) {
	    d = d.replace(". ", "<br /> ");
	}
	text = new JLabel("<html><br /><br /><br /><h1>" + d + "</h1></html>");
	Var.answerBox4.add(text);
	String e = Var.problem.getE();
	while (!e.equals(e.replace(". ", "<br /> "))) {
	    e = e.replace(". ", "<br /> ");
	}
	text = new JLabel("<html><br /><br /><br /><h1>" + e + "</h1></html>");
	Var.answerBox5.add(text);
    }
    
    private static void correctAnswerText() {
	Var.correctAnswerBox.removeAll();
	JLabel text;
	String correctAnswer = Var.problem.getCorrectAnswer();
	while (!correctAnswer.equals(correctAnswer.replace(". ", ".<br /> "))) {
	    correctAnswer = correctAnswer.replace(". ", ".<br /> ");
	}
	text = new JLabel("<html><br /><br /><br /><br /><h1>" + correctAnswer + "</h1></html>");
	Var.correctAnswerBox.add(text);
    }
    
    private static void answerExplanationText() {
	Var.answerExplanationBox.removeAll();
	JLabel text;
	String explanation = Var.problem.getExplanation();
	while (!explanation.equals(explanation.replace(". ", ".<br /> "))) {
	    explanation = explanation.replace(". ", ".<br /> ");
	}
	text = new JLabel("<html><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><h1>" + explanation
		+ "</h1></html>");
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
    }
    
    private static void answerExplanationVisible(boolean flag) {
	for (ImagePanel c : Var.frameElements) {
	    if (c instanceof CorrectAnswerBox || c instanceof AnswerExplanationBox) {
		c.setVisible(flag);
		if (flag && c instanceof CorrectAnswerBox) {
		    correctAnswerText();
		}
		if (flag && c instanceof AnswerExplanationBox) {
		    answerExplanationText();
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
	    if (Var.DIALOGUE) {
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
	    }
	} else {
	    Var.incorrect++;
	    if (Var.streak > 0) {
		Var.streak = -1;
	    } else {
		Var.streak--;
	    }
	    if (Var.DIALOGUE) {
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
	    }
	}
	return correct;
    }
}
