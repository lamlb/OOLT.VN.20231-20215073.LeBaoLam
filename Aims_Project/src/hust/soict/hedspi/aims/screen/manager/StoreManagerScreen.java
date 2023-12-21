package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;
public class StoreManagerScreen extends JFrame {
    private Store store;

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openAddBookScreen();
            }
        });
        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openAddCompactDiscToStoreScreen();
            }
        });
        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openAddDigitalVideoDiscToStoreScreen();
            }
        });
        // Add other update options similarly...

        smUpdateStore.add(addBookItem);
        smUpdateStore.add(addDVDItem);
        smUpdateStore.add(addCDItem);
        

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenterPanel() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();

        for (int i = 0; i < Math.min(9, mediaInStore.size()); i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }

    public StoreManagerScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenterPanel(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 728);
    }

    // Open the AddBookScreen and pass the reference to StoreManagerScreen
    private void openAddBookScreen() {
        new AddBookScreen(store, this);
    }

    // Open the AddDigitalVideoDiscToStoreScreen and pass the reference to StoreManagerScreen
    private void openAddDigitalVideoDiscToStoreScreen() {
        new AddDigitalVideoDiscToStoreScreen(store, this);
    }
    // Open the AddCompactDiscToStoreScreen and pass the reference to StoreManagerScreen
    private void openAddCompactDiscToStoreScreen() {
        new AddCompactDiscToStoreScreen(store, this);
    }

    public void updateCenterPanel() {
        // Clear the existing components in the center panel
        getContentPane().removeAll();

        // Re-add the components
        getContentPane().add(createNorth(), BorderLayout.NORTH);
        getContentPane().add(createCenterPanel(), BorderLayout.CENTER);

        // Repaint the frame
        revalidate();
        repaint();
    }
    public static void main(String[] args) {
        Store store = new Store();
        Media media1 = new DigitalVideoDisc("Harry Potter and Chamber of Secret", "Harry Potter", "T", 120, 3.0f);
		Media media2 = new CompactDisc(55,"CD2","Ffssa",12);
		Media media3 = new CompactDisc(9,"CD3","fs",77);
		Media media4 = new CompactDisc(5,"CD4","f",5);
		Media media5 = new DigitalVideoDisc("DVD 3");
		
		store.addMedia(media1);
		store.addMedia(media2);
		store.addMedia(media3);
		store.addMedia(media4);
		store.addMedia(media5);
        StoreManagerScreen storeManagerScreen = new StoreManagerScreen(store);
    }
}