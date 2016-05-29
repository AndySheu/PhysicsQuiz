
public class AnswerExplanationBox extends ImagePanel {
    public AnswerExplanationBox() {
	super("./src/AnswerExplanationBox.png");
    }
    
    @Override
    public void clicked() {
	System.out.println("Answer Explanation Box clicked.");
    }
}
