package aiPractice;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ItemImage {
	
	final int WIDTH = 61;
	final int HEIGHT = 61;
	
	BufferedImage itemImage;
	
	ItemImage(){
		
		InputStream stream = getClass().getResourceAsStream("itemImages.png");
		try{
			itemImage = ImageIO.read(stream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	BufferedImage getImage(int row, int column) {
		int x = 3 + (column - 1) * (WIDTH + 14); // 78,8
		int y = 8 + (row - 1) * (HEIGHT + 40);
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.createGraphics();
		g.setColor(Color.RED);
		g.fillRect(0,0,40,40);
		g.drawImage(itemImage,0,0,WIDTH, HEIGHT, x, y, x+ WIDTH,y+ HEIGHT, null);
		return image;
	}

}
