package register;

import java.awt.Graphics2D;
import java.util.Random;

import entity.Customer;

public class Scale {
	Random r;
	int weight;
		
	public void useScale() {
		weight = r.nextInt(4);
	}
	
	public void draw(Graphics2D g2) {
		g2.drawString(String.valueOf(weight), 100, 200);
	}
}
