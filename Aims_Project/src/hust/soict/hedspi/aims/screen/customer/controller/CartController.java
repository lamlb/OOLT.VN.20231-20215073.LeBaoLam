package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartController {

	    @FXML
	    private TableColumn<?, ?> colMediaId;

	    @FXML
	    private Label costLabel;

	    @FXML
	    private TableView<?> tblMedia;

	    @FXML
	    private TableColumn<?, ?> colMediaCost;

	    @FXML
	    private ToggleGroup filterCategory;

	    @FXML
	    private Button btnPlay;

	    @FXML
	    private Button btnRemove;

	    @FXML
	    private TableColumn<?, ?> colMediaTitle;

	    @FXML
	    private TableColumn<?, ?> colMediaCategory;

	    @FXML
	    void btnPlayPressed(ActionEvent event) {

	    }

	    @FXML
	    void btnRemovePressed(ActionEvent event) {

	    }

	    @FXML
	    void btnViewStorePressed(ActionEvent event) {

	    }

	    private Cart cart;
	    public CartController(Cart cart) {
	    	this.cart = cart;
	    }
	    @FXML
	    public void initialize() {
	    	colMediaId.setCellValueFactory(
	    			new PropertyValueFactory<Media, Integer>("id"));
	    	colMediaTitle.setCellValueFactory(
	    			new PropertyValueFactory<Media, String>("title"));
	    	colMediaCategory.setCellValueFactory(
	    			new PropertyValueFactory<Media, String>("category"));
	    	colMediaCost.setCellValueFactory(
	    			new PropertyValueFactory<Media, Float>("cost"));
	    	if(cart.getItemsOrdered() != null)
	    		tblMedia.setItems(cart.getItemsOrdered());
	    }
	}
