
public class CorrectBox extends ImagePanel {
    public CorrectBox() {
	super("./src/Correct.png");
    }
    
    @Override
    public void clicked() {
	System.out.println("Correct Box clicked.");
    }
}
