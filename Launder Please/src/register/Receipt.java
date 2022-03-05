package register;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Main.GamePanel;

public class Receipt {
	ArrayList<String> input;
	BufferedImage image;
	GamePanel gp;
	DecimalFormat dFormat = new DecimalFormat("0.00");

	public Receipt(ArrayList<String> input, GamePanel gp) {
		this.gp = gp;
		this.input = input;
		getImage();
	}
	
	public void getImage() {
		try {
			
			image = ImageIO.read(getClass().getResourceAsStream("/object/receiptV1.png"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		g2.drawImage(image, 400, 40, 200, 400, null);
		// print each number in the list
		int x = 420, y = 80;
		for(int i = 0; i < input.size(); i++) {
			double fixDecimal;
			fixDecimal = Double.parseDouble(input.get(i));
			g2.drawString(String.valueOf(dFormat.format(fixDecimal)), x, y);
			y += 30;
		}
		g2.drawString("Total: " + gp.register.output, x, y);
	}
}
