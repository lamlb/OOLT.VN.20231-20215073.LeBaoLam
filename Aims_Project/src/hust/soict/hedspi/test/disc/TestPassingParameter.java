package hust.soict.hedspi.test.disc;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {
	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		swap(jungleDVD, cinderellaDVD);
		System.out.println("Jungle DVD title: " + jungleDVD.getTitle());
		System.out.println("Cinderella DVD title: " + cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("Jungle DVD title: " + jungleDVD.getTitle());
	}
	
	public static void swap(Object o1, Object o2) {
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}
	//Please write a swap() method that can correctly swap the two objects.
		public static void newSwap(DigitalVideoDisc Object1, DigitalVideoDisc Object2) {
			//Change title
			String tempString = Object1.getTitle(); 
			Object1.setTitle(Object2.getTitle());    
			Object2.setTitle(tempString);
			
			//Change category
			tempString = Object1.getCategory(); 
			Object1.setCategory(Object2.getCategory());   
			Object2.setCategory(tempString);
			
			//Change directory
			tempString = Object1.getDirector(); 
			Object1.setDirector(Object2.getDirector());   
			Object2.setDirector(tempString);
			
			//Change length
			int temp ;
			temp = Object1.getLength(); 
			Object1.setLength(Object2.getLength());    
			Object2.setLength(temp);
			
			//Change cost
			float tempCost;
			tempCost = Object1.getCost(); 
			Object1.setCost(Object2.getCost());    
			Object2.setCost(tempCost);
			
		}
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
}