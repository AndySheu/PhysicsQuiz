
public class CorrectAnswerBox extends ImagePanel {
    public CorrectAnswerBox() {
	super("./src/CorrectAnswerBox.png");
    }
    
    @Override
    public void clicked() {
	System.out.println("Correct Answer Box clicked.");
    }
}
