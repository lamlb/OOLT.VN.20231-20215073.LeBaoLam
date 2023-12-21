package hust.soict.hedspi.aims.screen.customer.controller;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.naming.LimitExceededException;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.*;
import hust.soict.hedspi.aims.media.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {

    private Media media;
    private Cart cart;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    void btnAddToCartClicked(ActionEvent event) throws LimitExceededException {
        System.out.println(cart.getItemsOrdered().size());
        if (cart.getItemsOrdered().contains(media)) {
            JDialog dialog = new JDialog();
            dialog.setTitle("Error adding to cart");
            JPanel panel = new JPanel();
            FlowLayout boxlayout = new FlowLayout(FlowLayout.CENTER, 75, 75);
            panel.setLayout(boxlayout);
            panel.add(new JLabel("The media existed in the list"));
            dialog.add(panel);
            dialog.setSize(200, 200);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
            
        } else {
            cart.addMedia(this.media);
            JDialog dialog = new JDialog();
            dialog.setTitle("Add to cart successfully");
            JPanel panel = new JPanel();
            FlowLayout boxlayout = new FlowLayout(FlowLayout.CENTER, 75, 75);
            panel.setLayout(boxlayout);
            panel.add(new JLabel("The media added to the list"));
            dialog.add(panel);
            dialog.setSize(200, 200);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        }
    }

    @FXML
    void btnPlayClicked(ActionEvent event) throws PlayerException {
        JDialog dialog = new JDialog();
        dialog.setTitle("Play");
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        String[] playList = ((Playable) media).play();
        if (playList != null) {
            for (int i = 0; i < playList.length; i++) {
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.gridx = 0;
                gbc.gridy = i;
                panel.add(new JLabel(playList[i]), gbc);
            }
        } else {
            // Handle the case where playList is null (show an error message, log, etc.)
            
            System.err.println("Playlist is null");
        }
    
        dialog.add(panel);
        dialog.setSize(300, 300);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(this.media.getTitle());
        lblCost.setText(this.media.getCost() + " $");
        if (this.media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 112.5));
        }
    }

    public ItemController(Cart cart) {
        this.cart = cart;
    }

}