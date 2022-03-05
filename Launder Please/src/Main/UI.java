package Main;

import java.awt.Graphics2D;

public class UI {
	GamePanel gp;
	
	public UI(GamePanel gp) {
		this.gp = gp;
	}
	
	public void draw(Graphics2D g2) {
		g2.drawString("Bank: " + String.valueOf(gp.bank.startMoney), 900, 30);
	}
}
