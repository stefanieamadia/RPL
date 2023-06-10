package pages;

import controller.UserDao;
import models.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame{
    private JFrame frame;
    private JPanel loginPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JCheckBox rememberMeCheckBox;
    private JLabel accountLabel;
    private JButton signUpButton;
    private JLabel passwordLabel;
    private JLabel usernameLabel;
    private JLabel forgotField;
    private JLabel titleField;

    private User user;
    private final UserDao userDao = new UserDao();

    public void initialize() {
        frame = new JFrame();

        frame.setContentPane(loginPanel);
        frame.setTitle("Login Page");
        frame.setSize(355, 281);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // -- BIKIN WINDOW PROGRAM DI TENGAH LAYAR

        signUpButton.addActionListener(e -> {
            RegistrationPage registrationPage = new RegistrationPage();
            registrationPage.initialize();
            frame.dispose();
        });

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            boolean berhasilLogin = false;
            try {
                // -- CEK APAKAH FIELD KOSONG
                if(username.isBlank() || password.isBlank()){
                    throw new Exception("Isi Field Kosong");
                }

                // -- MENGECEK USERNAME DAN PASSWORD USER
                    user = userDao.getUser(username, password);
                    if(user == null){
                        throw new Exception("Username atau Password yang anda masukkan salah!");
                    }else{
                        berhasilLogin = true;
                    }

                // -- JIKA BERHASIL LOGIN
                if (berhasilLogin) {
                     JOptionPane.showMessageDialog(frame, "Login Berhasil!");
                    Homepage user = new Homepage();
                    user.initialize();
                    frame.dispose();
                } else {
                    throw new Exception("Kesalahan Username/Password!");
                }

            } catch (Exception msg) {
                JOptionPane.showMessageDialog(frame, msg.getMessage(), "Alert", JOptionPane.WARNING_MESSAGE);
            }
        });
    };
}
