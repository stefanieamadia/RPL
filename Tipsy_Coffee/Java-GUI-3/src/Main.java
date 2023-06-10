import pages.Homepage;
import pages.LoginPage;
import pages.TambahPage;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Homepage homepage = new Homepage();
            homepage.initialize();
        });
    }
}