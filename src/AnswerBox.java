
public class AnswerBox extends ImagePanel {
    int num;
    public AnswerBox(int answerNumber) {
	super("./src/AnswerBox.png");
	num = answerNumber;
    }
    
    @Override
    public void clicked() {
	System.out.println("Answer " + num + " clicked.");
    }
}
