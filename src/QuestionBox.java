
public class QuestionBox extends ImagePanel {
    public QuestionBox(String s) {
	super(s);
    }
    
    @Override
    public void clicked() {
	System.out.println("Question clicked.");
    }
}
