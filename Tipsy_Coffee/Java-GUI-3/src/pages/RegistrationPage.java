package pages;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.UserDao;
import models.User;

public class RegistrationPage extends JFrame {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registrationButton;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JPanel registrationPanel;
    private JLabel registrationTitle;
    private JButton signInButton;
    private static User user;
    private final UserDao userDao = new UserDao();

    public void initialize(){
        frame = new JFrame();

        frame.setContentPane(registrationPanel);
        frame.setTitle("Login Page");
        frame.setSize(355, 281);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // -- BIKIN WINDOW PROGRAM DI TENGAH LAYAR

        signInButton.addActionListener(e -> {
            LoginPage loginPage = new LoginPage();
            loginPage.initialize();
            frame.dispose();
        });

        registrationButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            boolean textFieldKosong = false;
            try {
                // -- MENGECEK APAKAH TEXT FIELD KOSONG
                if((username.isEmpty()) || (password.isEmpty())) {
                    textFieldKosong = true;
                }

                if(!textFieldKosong) {
                    // ---MENGECEK USERNAME YANG SAMA
                    if(userDao.isUserExist(username,password)){
                        JOptionPane.showMessageDialog(frame, "Username Telah Digunakan!", "Alert", JOptionPane.WARNING_MESSAGE);
                        usernameField.setText("");
                        passwordField.setText("");
                    }else{
                        user = new User(username, password);
                        System.out.println(user);
                        userDao.addUser(user);
                        JOptionPane.showMessageDialog(frame, "Registrasi Berhasil!");
                    }
                } else {
                    // -- JIKA TEXT FIELD KOSONG
                    JOptionPane.showMessageDialog(frame, "Username/Password tidak boleh kosong!","Alert", JOptionPane.WARNING_MESSAGE);
                    usernameField.setText("");
                    passwordField.setText("");
                }
            } catch(Exception exception) {
                System.out.println(exception.getMessage());
            }
        });
    };
}
