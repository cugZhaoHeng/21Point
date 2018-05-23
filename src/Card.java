import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.JPanel;

public class Card {
	public String value;
	public String color;
	public int number;
	Image img;
	public Card(String value, String color, Image img) {
		
		this.value = value;
		this.color = color;
		this.img = img;
		if(this.value == "A") {
			this.number = 1;
		}
		else if(this.value == "J"||this.value == "Q"||this.value == "K") {
			this.number = 10;
		} else  {
			this.number = Integer.parseInt(value);
		}
		
	}
	
}
