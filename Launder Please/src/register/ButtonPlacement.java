package register;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.StringWriter;

import Main.GamePanel;

public class ButtonPlacement {
	
	Button[] button;
	GamePanel gp;
	private int width = 28, height = 40;
	int opWidth = 32, opHeight = 40;
					
	public ButtonPlacement(GamePanel gp) {
		this.gp = gp;
		button = new Button[50];		
	}
	
	public void buttonPlacement() {		
		// CREATE BUTTON OBJECTS
		button[0] = new Button();
		button[0].setValue("0");
		
		button[1] = new Button();
		button[1].setValue("1");
		
		button[2] = new Button();
		button[2].setValue("2");		
		
		button[3] = new Button();
		button[3].setValue("3");
		
		button[4] = new Button();
		button[4].setValue("4");
		
		button[5] = new Button();
		button[5].setValue("5");
		
		button[6] = new Button();
		button[6].setValue("6");

		button[7] = new Button();
		button[7].setValue("7");
		
		button[8] = new Button();
		button[8].setValue("8");
		
		button[9] = new Button();
		button[9].setValue("9");
		
		button[10] = new Button();
		button[10].setValue(".");
		
		button[11] = new Button();
		button[11].setValue("+");
		
		button[12] = new Button();
		button[12].setValue("-");
		
		button[13] = new Button();
		button[13].setValue("Enter");
		
		button[14] = new Button();
		button[14].setValue("f&f");
		
		button[15] = new Button();
		button[15].setValue("DC");
		
		// PLACE NUMBER BUTTONS ON REGISTER	
		int numWidth = 28, numHeight = 40;
		int startX = 86 * 4;
		int startY = 89 * 4;
		int x = startX;
		int y = startY;
						
		for(int i = 0; i < 10; i++) {
			
			button[i].setRect(new Rectangle(x, y, numWidth, numHeight));
			x += width;
			
			if(i % 3 == 0) {
				y -= height;
				x = startX;
			} 
		}
		// ALL OTHER BUTTONS
		button[10].setRect(new Rectangle(400, startY, width, height));
		button[11].setRect(new Rectangle(310, y += height, opWidth, opHeight));
		button[12].setRect(new Rectangle(100, 200, width, height));
		button[13].setRect(new Rectangle(122, 316, width * 2, height));
		button[14].setRect(new Rectangle(150, 100, width, height));
		button[15].setRect(new Rectangle(150, 100, width, height));
	}
	
	public void draw(Graphics2D g2) {
		// DRAW OUTLINE ON BUTTONS
		g2.setColor(Color.white);
		for(int i = 0; i < 12; i++) {
			g2.draw(button[i].getRect());
		}
		g2.setColor(Color.cyan);
		g2.draw(button[13].getRect());
	}
}
