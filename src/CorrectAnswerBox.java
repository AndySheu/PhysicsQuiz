
public class CorrectAnswerBox extends ImagePanel {
    public CorrectAnswerBox(String s) {
	super(s);
    }
    
    @Override
    public void clicked() {
	System.out.println("Correct Answer Box clicked.");
    }
}
