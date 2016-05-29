
import java.util.ArrayList;
import java.awt.Component;
import javax.swing.JFrame;

public class Var {
    public static final String VERSION = "0.5";
    
    public static JFrame frame;
    public static ArrayList<ImagePanel> frameElements;
    
    public static Listener listener;
//    public static ImagePanel panel;
    public static QuestionBox questionBox;
    public static AnswerBox answerBox1, answerBox2, answerBox3, answerBox4, answerBox5;
    
    public static final int MAX_HEIGHT = 896;
    public static final int MAX_WIDTH = 1440;
    public static final boolean TESTING = true;
}
