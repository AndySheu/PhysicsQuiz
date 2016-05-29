
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;

public class ImagePanel extends JPanel {
    private Image img;
    public int x, y, width, height;

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

    public void setLoc(int x, int y) {
	this.x = x;
	this.y = y;
    }
    
    public void setImage(Image img) {
	this.img = img;

	Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	setPreferredSize(size);
	setMaximumSize(size);
	setMinimumSize(size);
	setSize(size);

	this.width = (int)size.getWidth();
	this.height = (int)size.getHeight();

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
    
    public void checkClicked(int cx, int cy) {
	if (cx > x && cx < (x + width) && cy > y && cy < (y + height)) {
	    clicked();
	}
    }
    
    public void clicked() {
	// You should override this if you want something to be clicked.
    }

}
