import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu {
    
    public static void init() {
	
	JMenuBar menubar = new JMenuBar();
	
	JMenu file = new JMenu("File");
	file.setMnemonic(KeyEvent.VK_F);
	JMenu stats = new JMenu("Stats");
	stats.setMnemonic(KeyEvent.VK_T);
	
	JMenuItem eMenuItem = new JMenuItem("Exit");
	eMenuItem.setMnemonic(KeyEvent.VK_E);
	eMenuItem.setToolTipText("Exit application");
	eMenuItem.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent event) {
		System.exit(0);
	    }
	});
	
	file.add(eMenuItem);
	
	eMenuItem = new JMenuItem("Number Correct");
	eMenuItem.setMnemonic(KeyEvent.VK_C);
	eMenuItem.setToolTipText("Number correct out of the total");
	eMenuItem.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent event) {
		JOptionPane.showMessageDialog(Var.frame, Var.correct + "/" + (Var.incorrect + Var.correct));
	    }
	});
	
	stats.add(eMenuItem);
	
	eMenuItem = new JMenuItem("Percentage");
	eMenuItem.setMnemonic(KeyEvent.VK_P);
	eMenuItem.setToolTipText("Percentage Correct");
	eMenuItem.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent event) {
		double percent;
		if ((Var.correct + Var.incorrect) > 0) {percent = (100 * Var.correct / (Var.correct + Var.incorrect));} else {percent = 0;}
		JOptionPane.showMessageDialog(Var.frame, percent + "% correct!");
	    }
	});
	
	stats.add(eMenuItem);
	
	eMenuItem = new JMenuItem("Streak");
	eMenuItem.setMnemonic(KeyEvent.VK_S);
	eMenuItem.setToolTipText("Number Correct in a row");
	eMenuItem.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent event) {
		JOptionPane.showMessageDialog(Var.frame, Var.streak);
	    }
	});
	
	stats.add(eMenuItem);
	
	menubar.add(file);
	menubar.add(stats);
	
	Var.frame.setJMenuBar(menubar);
    }
}