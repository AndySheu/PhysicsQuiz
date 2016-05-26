
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;

public class ImagePanel extends JPanel {
    private Image img;
    private double x, y, width, height;

    public ImagePanel() {
	
    }
    
    public ImagePanel(String imgLoc) {
	this(new ImageIcon(imgLoc).getImage());
    }

    public ImagePanel(Image img) {
	this.img = img;

	setImage(img);
	setFocusable(true);
	setDoubleBuffered(true);
    }

    public void setImage(Image img) {
	this.img = img;

	Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	setPreferredSize(size);
	setMaximumSize(size);
	setMinimumSize(size);
	setSize(size);

	this.width = size.getWidth();
	this.height = size.getHeight();

	repaint();
    }

    public void paintComponent(Graphics g) {
	g.drawImage(img, 0, 0, null);
    }

    public boolean isOutOfBounds(double x, double y) {
	this.x = super.getX();
	this.y = super.getY();
	return (x + width > Var.MAX_WIDTH) || (x < 0) || (y + height > Var.MAX_HEIGHT) || (y < 0);
    }

    public Dimension getMaximumBound() {
	return new Dimension(Var.MAX_WIDTH - (int) width, Var.MAX_HEIGHT - (int) height);
    }

    public Image getImage() {
	return img;
    }
    
    public void clicked(MouseEvent e) {
	if (e.getX() > x && e.getX() < (x + width) && e.getY() > y && e.getY() < (y + height)) {
	    System.out.println("CLICKED!");
	}
    }

}
