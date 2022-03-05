package map;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.GamePanel;

public class Map {

	GamePanel gp;
	BufferedImage image;
	
	public Map(GamePanel gp) {
		
		this.gp = gp;
		
		loadMap("/register/registerV3.png");
	}

	public void loadMap(String filePath) {
		
		try {
	
		image = ImageIO.read(getClass().getResourceAsStream(filePath));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void draw(Graphics g) {
		
		g.drawImage(image,	0, 0, gp.screenWidth, gp.screenHeight, null);
		
	}
}
