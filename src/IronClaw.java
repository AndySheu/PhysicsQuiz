import javax.swing.JOptionPane;

public class IronClaw extends ImagePanel {
    String text;
    
    public IronClaw() {
	super("./src/IronClaw.png");
    }
    
    @Override
    public void clicked() {
	double percent;
	if ((Var.correct + Var.incorrect) > 0) {
	    percent = (100 * Var.correct / (Var.correct + Var.incorrect));
	} else {
	    percent = 0;
	}
	
	JOptionPane.showMessageDialog(Var.frame, Var.correct + "/" + (Var.incorrect + Var.correct) + " -- Streak: "
		+ Var.streak + " -- " + percent + "%");
    }
}
