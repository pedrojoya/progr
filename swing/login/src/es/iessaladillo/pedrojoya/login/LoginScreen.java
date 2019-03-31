package es.iessaladillo.pedrojoya.login;

import es.iessaladillo.pedrojoya.login.base.BaseScreen;
import es.iessaladillo.pedrojoya.login.utils.JFrameUtils;
import es.iessaladillo.pedrojoya.login.utils.JTextFieldUtils;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

public class MainScreen extends BaseScreen {

    private JPanel mainPanel;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnReset;
    private JButton btnLogin;

    private MainScreen() {
        setContentPane(mainPanel);
        setTitle("Login");
        setupViews();
        // Initial check.
        checkLoginButtonEnabledState();
    }

    private void setupViews() {
        btnLogin.addActionListener(e -> login());
        btnReset.addActionListener(e -> reset());

        JTextFieldUtils.addOnTextChangedListener(txtUsername, e -> checkLoginButtonEnabledState());
        JTextFieldUtils.addOnTextChangedListener(txtPassword, e -> checkLoginButtonEnabledState());
    }

    private void checkLoginButtonEnabledState() {
        btnLogin.setEnabled(isValidForm());
    }

    private void login() {
        if (isValidLogin()) {
            navigateToSecondaryScreen();

        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta", "Login",  JOptionPane.ERROR_MESSAGE);
        }
    }

    private void navigateToSecondaryScreen() {
        SecondaryScreen.startScreen();
    }

    private void reset() {
        txtUsername.setText("");
        txtPassword.setText("");
    }

    private boolean isValidForm() {
        return !txtUsername.getText().isEmpty() && !String.valueOf(txtPassword.getPassword()).isEmpty();
    }

    private boolean isValidLogin() {
        return "baldomero".equalsIgnoreCase(txtUsername.getText()) && "llegateligero".equals(String.valueOf(txtPassword.getPassword()));
    }

    public static void main(String[] args) {
        new MainScreen().setVisible(true);
    }

}
