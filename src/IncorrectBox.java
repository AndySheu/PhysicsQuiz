
public class IncorrectBox extends ImagePanel {
    public IncorrectBox() {
	super("./src/Incorrect.png");
    }
    
    @Override
    public void clicked() {
	System.out.println("Incorrect Box clicked.");
    }
}
