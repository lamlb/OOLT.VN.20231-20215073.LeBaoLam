package hust.soict.hedspi.aims.cart;
import java.util.ArrayList;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDER = 20;
	
	ArrayList<DigitalVideoDisc> itemsOrder = new ArrayList<DigitalVideoDisc>();
	
	private int qtyOrdered;
	
	public int getQtyOrder() {
        return qtyOrdered;
    }
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDER){
            itemsOrder.add(disc);
            qtyOrdered++;
            System.out.printf("The disc %s has been added\n", disc.getTitle());
        } else {
            System.out.println("The cart is almost full");
        }
	}
	
	public double totalCost() {
		double total = 0;
		for (DigitalVideoDisc disc : itemsOrder){
			total += (double) disc.getCost();
		}
		return total;
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered > 0) {
			if (itemsOrder.contains(disc)) {
				itemsOrder.remove(disc);
				qtyOrdered--;
				System.out.printf("The disc %s has been removed\n",disc.getTitle());
			} else System.out.println("Not found");
		} else System.out.println("Empty cart");
		
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		int n = dvdList.length;
		if(n == 0 || (n + this.getQtyOrder()) >= 20) {
			System.out.println("The cart is almost full");
			return;
		}
		else {
			for(int i = 0; i < n; i++) {
				addDigitalVideoDisc(dvdList[i]);
			}
			System.out.println("The disc has been added");
		}
	}

	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		this.addDigitalVideoDisc(dvd1);
		this.addDigitalVideoDisc(dvd2);
	}
	public void displayCart() {
		
		System.out.println("***********************CART***********************");
        for (DigitalVideoDisc disc : itemsOrder){
            System.out.printf(disc.toString());
        }
		System.out.printf("Total cost: %5.2f\n", this.totalCost());
		System.out.println("***************************************************");
	}
	public void searchById(int id) {
		for (DigitalVideoDisc disc : itemsOrder){
			if (disc.isMatch(id)) {
				System.out.printf(disc.toString());
				return;
			}
        }
		System.out.println("Not found");
	}

	public void searchByTitle(String title) {
		for (DigitalVideoDisc disc : itemsOrder) {
			if (disc.isMatch(title)) {
				System.out.printf(disc.toString());
				return;
			}
		}
		System.out.println("Not found");
	}	
}