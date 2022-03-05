package services;

import Main.GamePanel;

public class Services extends SuperService{
	GamePanel gp;
	
	public Services(GamePanel gp) {
		this.gp = gp;
	}
	public void setServices() {
		gp.services[0] = new FluffandFold();
		gp.services[1] = new DryCleaning();
	}	
}
