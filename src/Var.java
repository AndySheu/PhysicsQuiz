
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JFrame;

public class Var {
    public static final String VERSION = "2.1";
    
    public static JFrame frame;
    public static Color backgroundColor = Color.yellow;
    public static ArrayList<ImagePanel> frameElements;
    
    public static Problem problem;
    public static String selectedAnswer;
    public static Listener listener;
    public static QuestionBox questionBox;
    public static AnswerBox answerBox1, answerBox2, answerBox3, answerBox4, answerBox5;
    public static ImagePanel panel;
    public static CorrectAnswerBox correctAnswerBox;
    public static AnswerExplanationBox answerExplanationBox;
    public static CorrectBox correctBox;
    public static IncorrectBox incorrectBox;
    
    public static final int SELECT_ANSWER = 1;
    public static final int CORRECT_ANSWER = 2;
    public static final int INCORRECT_ANSWER = 3;
    public static final int ANSWER_EXPLANATION = 4;
    public static final int INTRO = 0;
    
    public static int mode = INTRO;
    
    public static final int MAX_HEIGHT = 896;
    public static final int MAX_WIDTH = 1440;
    public static final boolean TESTING = true;
}
