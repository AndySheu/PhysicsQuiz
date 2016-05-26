
import java.util.ArrayList;
import java.awt.Component;
import javax.swing.JFrame;

public class Var {
    public static final String VERSION = "0.1";
    
    public static JFrame frame;
    public static ArrayList<Component> frameElements;
    
    public static Listener listener;
    public static ImagePanel panel;
    
    public static final int MAX_HEIGHT = 896;
    public static final int MAX_WIDTH = 1440;
    public static final int FPS = 100;
    
    public static final boolean TESTING = true;
    
    public static final boolean PRINT_LOCATION = false;
    public static final boolean PRINT_OUT_OF_BOUNDS = false;
    public static final boolean PRINT_KEYSTROKE = false;
    public static final boolean PRINT_KEYTYPE = false;
}
