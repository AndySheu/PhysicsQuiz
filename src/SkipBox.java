import java.awt.Color;
import java.awt.Graphics;

public class SkipBox extends ImagePanel {
    String text;
    
    public SkipBox() {
	super("./src/SkipBox.png");
    }
    
    @Override
    public void clicked() {
	Main.skipQuestion();
    }
}
