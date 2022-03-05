package Main;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import entity.Customer;


public class KeyHandler implements KeyListener, MouseListener{
	GamePanel gp;
	public Point point;
	public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;
	public boolean mouseClicked;

	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {		
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			
			upPressed = true;
		}
		if(code == KeyEvent.VK_S) {
			
			downPressed = true;
		}
		if(code == KeyEvent.VK_A) {
			
			leftPressed = true;
		}
		if(code == KeyEvent.VK_D) {
			
			rightPressed = true;
		}
		if(code == KeyEvent.VK_ENTER) {
			enterPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {		
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			
			upPressed = false;
		}
		if(code == KeyEvent.VK_S) {
			
			downPressed = false;
		}
		if(code == KeyEvent.VK_A) {
			
			leftPressed = false;
		}
		if(code == KeyEvent.VK_D) {
			
			rightPressed = false;
		}           
		if(code == KeyEvent.VK_ENTER) {
			enterPressed = false;
		}
		// spawn customer
		if(code == KeyEvent.VK_L) {
			gp.spawnCustomer();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {		
		point = e.getPoint();
//		System.out.println(point);
		mouseClicked = true;
	}

	@Override
	public void mousePressed(MouseEvent e) {	
	}

	@Override
	public void mouseReleased(MouseEvent e) {	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}
