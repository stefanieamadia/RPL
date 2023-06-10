package pages;

import controller.StockDao;

import javax.swing.*;

public class TambahPage {
    private JLabel titleLabel;
    private JButton submitButton;
    private JSpinner jumlahSpinner;
    private JComboBox<String> comboBox1;
    private JButton menuButton;
    private JPanel tambahPanel;
    private JLabel pilihanLabel;

    public void initialize() {
        JFrame frame = new JFrame();

        frame.setContentPane(tambahPanel);
        frame.setTitle("Tambahkan Stock Page");
        frame.setSize(355, 281);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // -- BIKIN WINDOW PROGRAM DI TENGAH LAYAR

        menuButton.addActionListener(e -> {
            Homepage homePage = new Homepage();
            homePage.initialize();
            frame.dispose();
        });

        // Set the default property for optionComboBox
        String[] options = {"Bubuk Matcha", "Bubuk Red Velvet", "Bubuk Coklat", "Syrup Vanilla"};
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(options);
        comboBox1.setModel(comboBoxModel);

        submitButton.addActionListener(e -> {
            StockDao stockDao = new StockDao();
            String selectedOption = (String) comboBox1.getSelectedItem();
            int jumlahStock = (int) jumlahSpinner.getValue();
            System.out.println("item :" + selectedOption + "int :" + jumlahStock);
            stockDao.addStock(selectedOption, jumlahStock);
            if(jumlahStock < 0 ) {
                JOptionPane.showMessageDialog(frame, "Berhasil mengurangi  " + (jumlahStock * -1) + " gram " + selectedOption + " !");
            } else {
                JOptionPane.showMessageDialog(frame, "Berhasil menambahkan " + jumlahStock + " gram " + selectedOption + " !");
            }
        });
    }
}
