public class Aims {
    public static void main(String[] args) {
		Cart anOrder = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The lion King",
				"Animation","Roger Allder", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction","Geogre Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation","Roger Allder", 87, 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		//Overloading by differing types of parameter
				DigitalVideoDisc[] dvdList = new DigitalVideoDisc[] { dvd1, dvd2, dvd3 };
				anOrder.addDigitalVideoDisc(dvdList);

		
				//Cart Display DVD Details
				System.out.println();
		        anOrder.displayCart();
				
		        //Calculate total Cost
		        System.out.printf("     Total Cost: %14.2f \n", anOrder.totalCost());
		        
		        // Remove DVD from cart
		        System.out.println();
		        anOrder.removeDigitalVideoDisc(dvd1);
		        anOrder.displayCart();

		        //Calculate total Cost
		        System.out.printf("     Total Cost: %14.2f \n", anOrder.totalCost());
		        
		      //Overloading by differing the number of parameters
				System.out.println();
				anOrder.addDigitalVideoDisc(dvd2, dvd3);
				anOrder.displayCart();
				
		        //Calculate total Cost
		        System.out.printf("     Total Cost: %14.2f \n", anOrder.totalCost());
    }
}
