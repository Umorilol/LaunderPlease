package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Systems.PersonalBank;
import entity.Customer;
import entity.Entity;
import entity.Player;
import map.Map;
import register.Register;
import services.Services;
import services.SuperService;

public class GamePanel extends JPanel implements Runnable { 
	
	final int originalTileSize = 16;
	public final int scale = 4;
	
	final public int tileSize = originalTileSize * scale;
	final int maxScreenCol = 16;
	final int maxScreenRow = 9;
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screenHeight = tileSize * maxScreenRow;
	final int FPS = 60;
	
	Thread gameThread;
	KeyHandler keyH = new KeyHandler(this);
	
	// Systems
	UI ui = new UI(this);
	
	// Services
	public SuperService services[] = new SuperService[3];
	Services service = new Services(this);
	
	// Entity
	Player player = new Player(this, keyH);
	public PersonalBank bank = new PersonalBank();
	Entity customer[] = new Entity[5];
	
	// Register
	public Register register = new Register(this, keyH);
	Map map = new Map(this);
	
	// GameState
	public int gameState;
	public final int titleState = 1;
	public final int registerState = 2;
	
	public GamePanel() {	
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.addMouseListener(keyH);
		this.setFocusable(true);		
	}
	
	public void startGameThread() {		
		gameThread = new Thread(this);
		gameThread.start();		
	}
	
	public void setupGame() {
		service.setServices();
		gameState = registerState;
	}

	@Override
	public void run() {		
		// game loop
		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		while(gameThread != null) {
			
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			
			lastTime = currentTime;
		
			if(delta >= 1) {
				
			update();
			repaint();
			delta--;			
			}
		}
	}
	
	public void update() {	
		
		// Cash Register Screen
		if(gameState == registerState) {
			register.update();
			// check if customer is spawned if yes update
			for(int i = 0; i < customer.length; i++) {
				if(customer[i] != null) {
					customer[i].update();
				}
			}
//			player.update();	
		}
		// Main menu
		if(gameState == titleState) {
			
		}
	}
	
	public void paintComponent(Graphics g) {		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		// title screen
		if(gameState == titleState) {
			
		}
		
		else {			
			// draw the map
			map.draw(g);
			// draw register button outlines
			register.draw(g2);
			// draw customer
			for(int i = 0; i < customer.length; i++) {
				if(customer[i] != null) {
					customer[i].draw(g2);
				}
			}
			// Draw UI
			ui.draw(g2);
		}
		// draw player
//		player.draw(g2);
		
		g2.dispose();	
	}
	
	public void spawnCustomer() {
		customer[0] = new Customer(this);
		customer[0].setAction();
	}
}
