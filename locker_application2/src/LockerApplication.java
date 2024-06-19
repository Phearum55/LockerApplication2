import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LockerApplication extends JFrame implements ActionListener {
    private JPasswordField passwordField;
    private JButton enterButton, clearButton;
    private JLabel statusLabel;
    private String savedPassword = null;

    public LockerApplication() {
        setTitle("Lock Class");
        setLayout(new FlowLayout());
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        passwordField = new JPasswordField(20);
        enterButton = new JButton("Enter");
        clearButton = new JButton("Clear");
        statusLabel = new JLabel("Enter Password");

        add(passwordField);
        add(enterButton);
        add(clearButton);
        add(statusLabel);

        enterButton.addActionListener(this);
        clearButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enterButton) {
            String inputPassword = new String(passwordField.getPassword());
            if (savedPassword == null) {
                savedPassword = inputPassword;
                statusLabel.setText("Password Set");
            } else {
                if (savedPassword.equals(inputPassword)) {
                    statusLabel.setText("Correct Password");
                } else {
                    statusLabel.setText("Incorrect Password");
                }
            }
        } else if (e.getSource() == clearButton) {
            passwordField.setText("");
            statusLabel.setText("Enter Password");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LockerApplication().setVisible(true);
        });
    }
}
