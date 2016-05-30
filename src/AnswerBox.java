
public class AnswerBox extends ImagePanel {
    int num;
    String text;
    
    public AnswerBox(int answerNumber) {
	super("./src/AnswerBox.png");
	num = answerNumber;
    }
    
    @Override
    public void clicked() {
	// System.out.println("Answer " + num + " clicked.");
	switch (num) {
	    case 1:
		text = Var.problem.getA();
		break;
	    case 2:
		text = Var.problem.getB();
		break;
	    case 3:
		text = Var.problem.getC();
		break;
	    case 4:
		text = Var.problem.getD();
		break;
	    case 5:
		text = Var.problem.getE();
		break;
	    default:
		text = "";
		break;
	}
	Var.selectedAnswer = text;
    }
}
