package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.GamePanel;
import Main.KeyHandler;

public class Player extends Entity{
	
	KeyHandler keyH;
	BufferedImage forward;
	public int money;
	
	public Player(GamePanel gp, KeyHandler keyH) {		
		super(gp);
		this.keyH = keyH;
		
		setDefaultValues();
		getPlayerImage();	
	}
	
	public void setDefaultValues() {		
		x = 100;
		y = 100;
		speed = 3;		
		money = 1000;
	}
	
	public void getPlayerImage() {		
		try {
		
		forward = ImageIO.read(getClass().getResourceAsStream("/player/player.png"));
		
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// This handles getting key input for player 
	public void update() {		
		if(keyH.upPressed == true || keyH.downPressed == true || 
				keyH.leftPressed == true || keyH.rightPressed == true) {
			
			if(keyH.upPressed == true) {	
				y -= speed;
			}
			
			else if(keyH.downPressed == true) {				
				y += speed;
			}
			
			else if(keyH.leftPressed == true) {			
				x -= speed;
			}
			
			else if(keyH.rightPressed == true) {				
				x += speed;
			}
		}
	}
	
	public void draw(Graphics2D g2) {		
		g2.drawImage(forward, x, y, 192, 270, null);	
	}
}
