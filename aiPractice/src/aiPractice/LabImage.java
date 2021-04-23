package aiPractice;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class LabImage {
	final int WIDTH = 100;
	final int HEIGHT = 147;
	
	BufferedImage deckImage;
	
	LabImage(){
		
		InputStream stream = getClass().getResourceAsStream("laboratory-equiptment-diagra.png");
		try{
		deckImage = ImageIO.read(stream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	BufferedImage getImage(int row, int column) {
		int x = column * WIDTH;
		int y = row * HEIGHT;
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.createGraphics();
		g.setColor(Color.RED);
		g.fillRect(0,0,40,40);
		g.drawImage(deckImage,0,0,WIDTH, HEIGHT, x, y, x+ WIDTH,y+ HEIGHT, null);
		return image;

}
}
