package imageprocessing;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class ImageSubroutines {

	public ImageSubroutines() {}
	
	public BufferedImage copyBufferedImage(BufferedImage toCopy) {
		BufferedImage clone = new BufferedImage(toCopy.getWidth(),toCopy.getHeight(), toCopy.getType());
	    
		Graphics2D g2d = clone.createGraphics();
	    g2d.drawImage(toCopy, 0, 0, null);
	    g2d.dispose();
	    
	    return clone;
	}
	
	public BufferedImage scaleBufferedImage(BufferedImage toScale, int newWidth, int newHeight) {
		Image temp = toScale.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		BufferedImage scaled = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D g2d = scaled.createGraphics();
		g2d.drawImage(temp, 0, 0, newWidth, newHeight, null);	
		g2d.dispose();
		
		return scaled;
	}
}
