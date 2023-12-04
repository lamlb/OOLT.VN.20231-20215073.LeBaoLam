package hust.soict.hedspi.aims.screen.manager;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;


public class AddCompactDiscToStoreScreen extends AddItemScreen {

    public AddCompactDiscToStoreScreen(Store store, StoreManagerScreen storeManagerScreen) {
        super(store, storeManagerScreen);
        setTitle("Add CD");
        setSize(1024, 728);
    }

    @Override
    protected JPanel createInputPanel() {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));

        JLabel idLabel = new JLabel("ID:");
        JLabel titleLabel = new JLabel("Title:");
        JLabel categoryLabel = new JLabel("Category:");
        JLabel costLabel = new JLabel("Cost:");

        idField = new JTextField();
        titleField = new JTextField();
        categoryField = new JTextField();
        costField = new JTextField();

        inputPanel.add(idLabel);
        inputPanel.add(idField);
        inputPanel.add(titleLabel);
        inputPanel.add(titleField);
        inputPanel.add(categoryLabel);
        inputPanel.add(categoryField);
        inputPanel.add(costLabel);
        inputPanel.add(costField);

        return inputPanel;
    }

    @Override
    protected void addItem() {
        try {
            int id = Integer.parseInt(idField.getText());
            String title = titleField.getText();
            String category = categoryField.getText();
            float cost = Float.parseFloat(costField.getText());

            CompactDisc newCD = new CompactDisc(id, title, category, cost);
            store.addMedia(newCD);

            updateStoreManagerScreen();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers.");
        }
    }
}
