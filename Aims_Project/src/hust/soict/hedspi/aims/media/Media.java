package hust.soict.hedspi.aims.media;
import java.time.LocalDate;
import java.util.Comparator;


public abstract class Media {
	private String title;
	private String category;
	private float cost;
	private LocalDate dateAdded;
	private int id;
	private static int nbMedia = 1;
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	public boolean equals(Object obj) throws ClassCastException {
        if (obj instanceof Media) {
            try {
                Media obj2 = (Media) obj;
                if (obj2.getTitle() == this.title) {
                    return true;
                }
            } catch (ClassCastException e) {
                throw e;
            }
        }
        return false;
    }
	
	public int compareTo(Media obj) throws NullPointerException {
        try {
            for (int i = 0; i < this.title.length() && i < obj.getTitle().length(); i++) {
                if ((int) this.title.charAt(i) == (int) obj.getTitle().charAt(i)) {
                    continue;
                } else {
                    return ((int) this.title.charAt(i) - (int) obj.getTitle().charAt(i));
                }
            }
            if (!(this.title.length() == obj.getTitle().length())) {
                return (this.title.length() - obj.getTitle().length());
            }
            for (int i = 0; i < this.category.length() && i < obj.getCategory().length(); i++) {
                if ((int) this.category.charAt(i) == (int) obj.getCategory().charAt(i)) {
                    continue;
                } else {
                    return ((int) this.category.charAt(i) - (int) obj.getTitle().charAt(i));
                }
            }
            if (!(this.category.length() == obj.getCategory().length())) {
                return (this.category.length() - obj.getCategory().length());
            }
            return 0;
        } catch (NullPointerException e) {
            throw e;
        }
    }
	
	public boolean search(String title) {
		return this.title.toLowerCase().contains(title.toLowerCase());
	}


	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = nbMedia;
		nbMedia += 1;
	}


	public Media(String title, String category) {
		super();
		this.title = title;
		this.category = category;
		this.id = nbMedia;
		nbMedia += 1;
	}


	public Media(String title) {
		super();
		this.title = title;
		this.id = nbMedia;
		nbMedia += 1;
	}


	public Media(String title, String category, float cost, int id) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = id;
		nbMedia += 1;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}


	public String getCategory() {
		return category;
	}


	public float getCost() {
		return cost;
	}


	public LocalDate getDateAdded() {
		return dateAdded;
	}
	
	public void setDateAdded(LocalDate date) {
		this.dateAdded = date;
	}
	
	public abstract String getType();
	
	public abstract String getDetails();
	
	public String toString() {
		return this.getDetails();
	}

}