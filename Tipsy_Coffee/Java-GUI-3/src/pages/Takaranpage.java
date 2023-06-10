package pages;

import controller.RecipeDao;
import models.Recipe;
import models.Stock;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;

public class Takaranpage {
    private JTable recipeTable;
    private JButton menuButton;
    private JLabel titleLabel;
    private JLabel pageLabel;
    private JPanel takaranPanel;
    private JButton submitButton;

    public void initialize() {
        RecipeDao recipeDao = new RecipeDao();

        JFrame frame = new JFrame();

        frame.setContentPane(takaranPanel);
        frame.setTitle("Takaran Resep Page");
        frame.setSize(600, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // -- BIKIN WINDOW PROGRAM DI TENGAH LAYAR

        menuButton.addActionListener(e -> {
            Homepage homePage = new Homepage();
            homePage.initialize();
            frame.dispose();
        });

        ArrayList<Recipe> recipeList = recipeDao.getAllRecipe();

        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(new Object[]{"Nama Menu", "Resep Menu"});
        recipeTable.setModel(dtm);

        for (Recipe recipe : recipeList) {
            Object[] rowData = {recipe.getNamaMenu(), recipe.getResepMenu()};
            dtm.addRow(rowData);
        }

        TableColumn namaMenuColumn = recipeTable.getColumnModel().getColumn(0);
        namaMenuColumn.setPreferredWidth(100); // Adjust the width as desired

        TableColumn resepMenuColumn = recipeTable.getColumnModel().getColumn(1);
        resepMenuColumn.setPreferredWidth(500); // Adjust the width as desired

        submitButton.addActionListener(e -> {
            int rowCount = recipeTable.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                String namaMenu = (String) recipeTable.getValueAt(i, 0);
                String resepMenu = (String) recipeTable.getValueAt(i, 1);
                // Assuming you have a unique identifier for each row, such as an id column
                int id = recipeList.get(i).getId(); // Get the id from the corresponding Recipe object

                System.out.println("id adalah " + id);
                // Update the recipe in the database
                recipeDao.updateRecipe(id, namaMenu, resepMenu);
            }
        });

    }
}

