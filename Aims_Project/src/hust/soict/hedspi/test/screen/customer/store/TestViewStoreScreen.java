package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
    private static Store store;
	private Cart cart;

    public void start(Stage primaryStage) throws Exception {
        if (this.cart == null) {
            this.cart = new Cart();
        }
        final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController storeController = new ViewStoreController(store, this.cart);
        fxmlLoader.setController(storeController);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
		// cart = new Cart();

		// Create Media
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.9f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Game of life", "Science Fiction", "Me", 87, 240.95f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Atlas", "Animation", 18.99f);

		CompactDisc cd1 = new CompactDisc("Punch", "AB", "WE", "Dataa", 20, 69.4f);
        Book book1 = new Book("Harry Potter", "Fantasy", 64, 30.00f);
        Book book2 = new Book("Harry Potter 3", "Fantasy", 45, 30.9f);
        CompactDisc cd2 = new CompactDisc("Allstars 2", "Yes", "Smash Mouth", "Dunno", 23, 69.420f);
       
        // Try adding Media
		store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvd4);
        store.addMedia(dvd5);
        store.addMedia(dvd6);
        store.addMedia(cd1);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(cd2);
        

        launch(args);
    }

}