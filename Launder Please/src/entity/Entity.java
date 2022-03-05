package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import Main.GamePanel;

public class Entity {
	GamePanel gp;
	String name;
	int x, y;
	int speed;
	
	public Entity(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setAction() { }
	
	public void update() {
	}
	
	public void draw(Graphics2D g2) {
		g2.setColor(Color.black);
		g2.fillRect(600, 216, 128, 128);
	}
}
