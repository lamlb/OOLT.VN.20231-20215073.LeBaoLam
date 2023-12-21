package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hust.soict.hedspi.aims.exception.*;

public class CompactDisc extends Disc implements Playable{
	
	private String artist;
	private int length;
	private List<Track> tracks = new ArrayList<Track>();
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public List<Track> getTracks() {
		return this.tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	public void addTrack(Track track) {
		if (tracks.contains(track)) {
			System.out.println("This track already exsists!");
			return;
		}
		tracks.add(track);
		System.out.println("The track: " + track.getTitle() + " added to list!");
		return;
	}
	
	public void removeTrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
			return;
		}
		System.out.println("The track: " + track + " remove from list");
		return;
	}
	
	public int getLength() {
		return this.length;
	}
	
	public CompactDisc(int id, String title, String category, float cost, int length, String director,
					   String artist, List<Track> track) {
		super(title, category, cost, id, length, director);
		this.artist = artist;
		this.tracks = track;
	}
	
	public CompactDisc(int id, String title, String category, float cost) {
		super(title, category, cost, id);
	}
	
	public CompactDisc(String title) {
		super(title);
	}

	public CompactDisc(String title, String category, String artist, String director, int length, float cost) {
		// TODO Auto-generated constructor stub
		super(title, category, cost, director);
		this.artist = artist;
		this.length = length;
	}

	public String[] play() throws PlayerException {
        if (this.getLength() < 0) {
            throw new PlayerException("ERROR: CD length is non-positive!");
        } else {
            String str = "";
            str+="The total length of the CD to add is: " + getLength();
            str+="/n";
            str+="Playing CD: " + this.getTitle();
            str+="/n";
            str+="CD length: " + getLength();
            Iterator<Track> iter = tracks.iterator();
            Track nextTrack;
            while (iter.hasNext()) {
                nextTrack = (Track) iter.next();
                try {
                    str+="/n";
                    for (String string : nextTrack.play()) {
						str+=string;
						str+="/n";
					}
                } catch (PlayerException e) {
                    throw e;
                }
            }
            return str.split("/n");
        }
    }
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Compact Disc Information:\n");
	    sb.append("Title: ").append(getTitle()).append("\n");
	    sb.append("Category: ").append(getCategory()).append("\n");
	    sb.append("Cost: ").append(getCost()).append("\n");
	    sb.append("Artist: ").append(artist).append("\n");
	    sb.append("Number of Tracks: ").append(tracks.size()).append("\n");
	    sb.append("Total Length: ").append(getLength()).append(" minutes").append("\n");
	    return sb.toString();
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDetails() {
		// TODO Auto-generated method stub
		return null;
	}
}