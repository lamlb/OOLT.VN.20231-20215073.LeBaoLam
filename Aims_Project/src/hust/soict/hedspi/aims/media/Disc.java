package hust.soict.hedspi.aims.media;

public abstract class Disc extends Media implements Playable{
	
	private int length;
	private String director;
	

	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}


	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}

	public Disc(String title, String category, float cost, int id, int length, String director) {
		super(title, category, cost, id);
		this.length = length;
		this.director = director;
	}
	
	public Disc(String title, String category, float cost, int id) {
		super(title, category, cost, id);
	}
	
	public Disc(String title) {
		super(title);
	}
	
	public Disc(String title, String director) {
		super(title);
		this.director = director;
	}
	
	public Disc(String title, String director, int length) {
		super(title);
		this.director = director;
		this.length = length;
	}
	
	public Disc(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public Disc(String title, String category, float cost, String director) {
		super(title, category, cost);
		this.director = director;
	}
	
	public Disc(String title, String category, float cost, String director, int length, int id) {
		super(title, category, cost, id);
		this.director = director;
		this.length = length;
	}
}
