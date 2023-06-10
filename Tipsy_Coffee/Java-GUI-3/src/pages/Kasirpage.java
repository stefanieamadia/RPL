package pages;

import controller.HistoryDao;
import models.History;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Kasirpage {
    private JTable kasirTable;
    private JButton menuButton;
    private JPanel kasirPanel;
    private JLabel titleLabel;
    private JLabel pembelianLabel;

    public void initialize() {
        HistoryDao historyDao = new HistoryDao();

        JFrame frame = new JFrame();

        frame.setContentPane(kasirPanel);
        frame.setTitle("Kasir Page");
        frame.setSize(355, 281);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // -- BIKIN WINDOW PROGRAM DI TENGAH LAYAR

        ArrayList<History> historyList = historyDao.getAllHistory();

        menuButton.addActionListener(e -> {
            Homepage homePage = new Homepage();
            homePage.initialize();
            frame.dispose();
        });

        DefaultTableModel dtm = (DefaultTableModel) kasirTable.getModel();
        dtm.setColumnIdentifiers(new Object[]{"Jam", "Nama Barang", "Jumlah Barang"});

        for (History history : historyList) {
            Object[] rowData = {history.getJam(), history.getNamaBarang(), history.getJumlahBarang()};
            dtm.addRow(rowData);
        }
    }
}
