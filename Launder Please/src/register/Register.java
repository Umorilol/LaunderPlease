package register;

import java.awt.Color;
import java.awt.Graphics2D;
import java.text.DecimalFormat;
import java.util.ArrayList;

import Main.GamePanel;
import Main.KeyHandler;

public class Register {
	
	GamePanel gp;
	KeyHandler keyH;
	ButtonPlacement buttonP = new ButtonPlacement(gp);
	Receipt receipt;
	
	// CALCULATOR 
	ArrayList <String> input;
	int counter = 0;
	double p1 = 0, p2 = 0;
	public String buttonPressed;
	public int buttonNum = 0;
	boolean calculating = false;
	public String output = "";
	DecimalFormat dFormat = new DecimalFormat("0.00");
	 
	public Register(GamePanel gp, KeyHandler keyH) {		 
		this.gp = gp;
	  	this.keyH = keyH;
	  	input = new ArrayList<String>();
	  	buttonP.buttonPlacement();	 
	}
	 
	public void update() {
		// START THE CALCULATOR
		if(keyH.mouseClicked == true) {
			keyH.mouseClicked = false;
			// CHECK WHAT BUTTON WAS PRESSED
			getButtonPressed();	
		}	
	}
	 
	public void getButtonPressed() {
		// CHECK IF A MOUSE IS INSIDE OF A BUTTON
		// remember to change i < 12 to buttonP.getLength
		for(int i = 0; i < 14; i++) {
			if(buttonP.button[i].getRect().contains(keyH.point)) {
				System.out.println("Button Pressed");
				// SEND BUTTON INFO
				buttonPressed = buttonP.button[i].getValue();
				getValues();
			}
		}	
	}
	
	public void getValues() {
		if(input.size() == 0) {
			String numInput = "";
			input.add(numInput);
		}
			
		switch(buttonPressed) {
		
		case "0":
			input(buttonPressed);
			break;
		
		case "1":
			input(buttonPressed);
			break;
			
		case "2":
			input(buttonPressed);
			break;
			
		case "3":
			input(buttonPressed);
			break;
			
		case "4":
			input(buttonPressed);
			break;
			
		case "5":
			input(buttonPressed);
			break;
			
		case "6":
			input(buttonPressed);
			break;
			
		case "7":
			input(buttonPressed);
			break;
			
		case "8":
			input(buttonPressed);
			break;
			
		case "9":
			input(buttonPressed);
			break;
			
		case ".":
			if(input.get(counter) == "t") {
				break;
			}
			input(buttonPressed);
			break;
			
		case "+":
			if(input.get(counter) == "") {
				break;
			}
			else
				nextInput();
			break;
		
		case "-":
			if(input.get(counter) == "") {
				break;
			}
			else
				nextInput();
			break;
			
		case "Enter":
			if(input.get(counter) == "") {
				output = "No input";
				break;
			}
			try {
				// print all numbers input into array
				for(int i = 0; i < input.size(); i++) {
					System.out.println(input.get(i));
				}
				calculations();
				break; 
				// catch if the user input more than one .
			}catch(NumberFormatException e) {
				input.remove(counter);
				output = "Format Error";
				System.out.println("exception found");
			}
		}
	}
	
	public void input(String buttonPressed) {
		input.set(counter, input.get(counter) + buttonPressed);
		output = input.get(counter);
	}
	
	public void nextInput() {
		counter ++;
		output = "";
		input.add("");
	}
	
	public void calculations() {
		
		// go through the list and add elemints
		for(int i = 0; i < input.size(); i++) {	
			
			// change to double for calculations
			p1 = Double.parseDouble(input.get(i));
			p2 += p1;
			
			// change back to string with format
			output = String.valueOf(dFormat.format(p2));
			receipt = new Receipt(input, gp);
			
			// add the output to your personal bank
			gp.bank.startMoney += p2;
		}
	}
	
	public void draw(Graphics2D g2) {	
		buttonP.draw(g2);
		
		// REGISTER SCREEN
		g2.setColor(Color.black);
		g2.drawString(output, 80 * gp.scale, 42 * gp.scale);
		
		// print receipt
		if(receipt != null) {
			receipt.draw(g2);
		}
	}
}
