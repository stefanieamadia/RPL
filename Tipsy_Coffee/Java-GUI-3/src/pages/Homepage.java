package pages;

import javax.swing.*;

public class Homepage {
    private JButton kasirButton;
    private JButton stockGudangButton;
    private JButton tambahStockButton;
    private JButton takaranButton;
    private JButton logoutButton;
    private JPanel homepagePanel;

    public void initialize(){
        JFrame frame = new JFrame();

        frame.setContentPane(homepagePanel);
        frame.setTitle("Home Page");
        frame.setSize(388, 281);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // -- BIKIN WINDOW PROGRAM DI TENGAH LAYAR

        logoutButton.addActionListener(e -> {
            LoginPage loginPage = new LoginPage();
            loginPage.initialize();
            frame.dispose();
        });

        takaranButton.addActionListener(e -> {
            Takaranpage takaranPage = new Takaranpage();
            takaranPage.initialize();
            frame.dispose();
        });

        tambahStockButton.addActionListener(e -> {
            TambahPage tambahPage = new TambahPage();
            tambahPage.initialize();
            frame.dispose();
        });

        stockGudangButton.addActionListener(e -> {
            Stockpage stockPage = new Stockpage();
            stockPage.initialize();
            frame.dispose();
        });

        kasirButton.addActionListener(e -> {
            Kasirpage kasirPage = new Kasirpage();
            kasirPage.initialize();
            frame.dispose();
        });
    }
}
