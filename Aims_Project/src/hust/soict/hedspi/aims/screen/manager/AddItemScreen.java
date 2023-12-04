package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hust.soict.hedspi.aims.store.Store;

public abstract class AddItemScreen extends JFrame {

    protected JTextField idField, titleField, categoryField, costField;
    protected Store store;
    protected StoreManagerScreen storeManagerScreen;

    public AddItemScreen(Store store, StoreManagerScreen storeManagerScreen) {
        this.store = store;
        this.storeManagerScreen = storeManagerScreen;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        // Add a "View Store" button
        JButton viewStoreButton = new JButton("View Store");
        viewStoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current screen
                storeManagerScreen.setVisible(true); // Show the StoreManagerScreen
            }
        });

        // Add the "View Store" button to the NORTH of the content pane
        cp.add(viewStoreButton, BorderLayout.NORTH);

        // Set up header and menubar based on the StoreManagerScreen
        cp.add(storeManagerScreen.createNorth(), BorderLayout.NORTH);

        JPanel inputPanel = createInputPanel();
        cp.add(inputPanel, BorderLayout.CENTER);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> addItem());
        cp.add(addButton, BorderLayout.SOUTH);

        setVisible(true);
        setSize(400, 200);
    }

    protected abstract JPanel createInputPanel();

    protected abstract void addItem();

    protected void updateStoreManagerScreen() {
        storeManagerScreen.updateCenterPanel();

        JOptionPane.showMessageDialog(this, "Item added successfully!");
        dispose();
    }
}