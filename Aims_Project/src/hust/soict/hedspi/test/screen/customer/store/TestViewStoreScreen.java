package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
	private static Store store;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		ViewStoreController viewStoreController = new ViewStoreController(store);
		fxmlLoader.setController(viewStoreController);
		Parent root = fxmlLoader.load();
		
		primaryStage.setTitle("Store");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		store = new Store();
		
        Media media1 = new DigitalVideoDisc(1,"Harry Potter and Chamber of Secret", "Harry Potter", "T", 120, 3.0f);
		Media media2 = new CompactDisc(55,"CD2","Ffssa",12);
		Media media3 = new CompactDisc(9,"CD3","fs",77);
		Media media4 = new CompactDisc(5,"CD4","f",5);
		Media media5 = new Book(3,"Doraemon");
		Media media6 = new Book(8,"Giai tich 3");
		Media media7 = new DigitalVideoDisc("DVD 3");
		
		store.addMedia(media1);
		store.addMedia(media2);
		store.addMedia(media3);
		store.addMedia(media4);
		store.addMedia(media5);
		store.addMedia(media6);
		store.addMedia(media7);
		launch(args);
	}
}
