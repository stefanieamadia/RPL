package pages;

import models.Stock;
import controller.StockDao;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ComponentAdapter;
import java.util.ArrayList;

public class Stockpage {
    private JTable stockTable;
    private JButton menuButton;
    private JLabel stockLabel;
    private JPanel stockPanel;

    public void initialize() {
        StockDao stockDao = new StockDao();

        JFrame frame = new JFrame();

        frame.setContentPane(stockPanel);
        frame.setTitle("Stock Page");
        frame.setSize(355, 281);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // -- BIKIN WINDOW PROGRAM DI TENGAH LAYAR

        menuButton.addActionListener(e -> {
            Homepage homePage = new Homepage();
            homePage.initialize();
            frame.dispose();
        });

        ArrayList<Stock> stockList = stockDao.getAllStock();

        // Set column names in the table model
        DefaultTableModel dtm = (DefaultTableModel) stockTable.getModel();
        dtm.setColumnIdentifiers(new Object[]{"Bahan Baku", "Sisa Stock"});

        // Add rows to the table model
        for (Stock stock : stockList) {
            Object[] rowData = {stock.getBahanBaku(), stock.getSisaStock() + " gram"};
            dtm.addRow(rowData);
        }

    }

}
