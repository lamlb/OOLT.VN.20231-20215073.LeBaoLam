package hust.soict.hedspi.aims.media;
import hust.soict.hedspi.aims.exception.*;

import java.awt.*;
import javax.swing.*;



public class DigitalVideoDisc extends Disc {
	private int length;

	public String getType() {
		return "DVD";
	}
	public int getLength() {
		return length;
	}

	public String getDetails() {
		return ("Product ID: " + String.valueOf(this.getId())
				+ "\n" + "\t" + "Title: " + this.getTitle()
				+ "\n" + "\t" + "Category: " + this.getCategory()
				+ "\n" + "\t" + "Director: " + this.getDirector()
				+ "\n" + "\t" + "Length: " + String.valueOf(this.getLength()) + " minutes"
				+ "\n" + "\t" + "Price: $" + String.valueOf(this.getCost()));
	}

	public String[] play() throws PlayerException {
        if (this.getLength() < 0) {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        } else {
			String str = "";
			str+="The total length of the DVD to add is: " + getLength();
			str+="/n";
			str+="Playing DVD: " + this.getTitle();
			str+="/n";
			str+="DVD length: " + getLength();
			return str.split("/n");
        }
	}

	public DigitalVideoDisc(String title) {
		super(title);
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, cost, director);
		this.length = length;
	}
}