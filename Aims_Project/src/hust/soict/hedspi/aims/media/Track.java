package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.*;

public class Track implements Playable {
	private String title;
	private int length;
	
	public boolean equals(Object track) {
		if (track instanceof Track) {
			Track that = (Track) track;
			if ((this.length == that.length) && (this.title.toLowerCase().equals(that.getTitle().toLowerCase()))) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public String[] play() throws PlayerException {
		if (this.getLength() <= 0) {
			throw new PlayerException("ERROR: Track length is non-positive!");
		} else {
			String str = "";
			str += "Playing Track: " + this.getTitle() + "\n";
			str += "Track length: " + this.getLength();
			return str.split("\n");
		}
	}
	
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	public Track(String title) {
		super();
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	
}