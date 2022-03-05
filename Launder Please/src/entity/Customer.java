package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import Main.GamePanel;
import services.SuperService;

public class Customer extends Entity{ 
	int purchaseNum;
	SuperService customerService;
	
	public Customer(GamePanel gp) {
		super(gp);
		name = "Billy";
	}
	
	public void setAction() {
		Random r = new Random();
		purchaseNum = r.nextInt(2);
		System.out.println(purchaseNum);
		customerService = gp.services[purchaseNum];
		System.out.println(customerService.name);
		
	}
	
	public void draw(Graphics2D g2) {
		g2.setColor(Color.black);
		g2.fillRect(600, 216, 128, 128);
		g2.drawString(customerService.name + " please", 690, 210);
		
		// Draw the weight on the scale
		if(customerService.name == "Fluff and Fold") {
			g2.drawString("Weight", 888, 366);
		}
	}
}

