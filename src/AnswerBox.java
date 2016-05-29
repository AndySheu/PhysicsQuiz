
public class AnswerBox extends ImagePanel {
    int num;
    public AnswerBox(String s, int answerNumber) {
	super(s);
	num = answerNumber;
    }
    
    @Override
    public void clicked() {
	System.out.println("Answer " + num + " clicked.");
    }
}
