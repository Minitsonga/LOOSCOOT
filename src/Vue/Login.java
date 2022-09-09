package Vue;

import Controllers.ConnectClient;
import Controllers.LoadSignIn;
import Models.Parc;

import javax.swing.*;
import java.awt.*;

public class Login extends JPanel {

    public Login(Parc parc, JFrame frame) {

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;


        JLabel title = new JLabel("Connection");
        title.setFont(new Font("Tahoma", Font.BOLD, 36));
        gbc.insets = new Insets(20, 0, 35, 0);
        add(title, gbc);

        JPanel panel2 = new JPanel(new GridBagLayout());
        JPanel panelHolder = new JPanel(new GridBagLayout());


        JLabel firstName = new JLabel("Prénom");
        firstName.setFont(new Font("Tahoma", Font.BOLD, 20));

        JTextField firstName_TextField = new JTextField();
        firstName_TextField.setPreferredSize(new Dimension(200, 25));

        gbc.insets = new Insets(0, 0, 5, 0);
        panel2.add(firstName, gbc);
        panel2.add(firstName_TextField);

        JPanel panel3 = new JPanel(new GridBagLayout());

        JLabel lastName = new JLabel("Nom de Famille");
        lastName.setFont(new Font("Tahoma", Font.BOLD, 20));

        JTextField lastName_TextField = new JTextField();
        lastName_TextField.setPreferredSize(new Dimension(200, 25));

        panel3.add(lastName, gbc);
        panel3.add(lastName_TextField);

        JButton connectionButton = new JButton("Se connecter");
        connectionButton.setBackground(new Color(59, 89, 182));
        connectionButton.setOpaque(true);
        connectionButton.setBorderPainted(false);
        connectionButton.setForeground(Color.WHITE);
        connectionButton.setFocusPainted(false);
        connectionButton.setPreferredSize(new Dimension(150, 25));
        connectionButton.setFont(new Font("Tahoma", Font.PLAIN, 18));

        JLabel errorTxt = new JLabel();
        errorTxt.setForeground(Color.RED);
        errorTxt.setFont(new Font("Tahoma", Font.BOLD, 18));

        ConnectClient connectClient = new ConnectClient(parc, firstName_TextField, lastName_TextField, errorTxt, frame);
        connectionButton.addActionListener(connectClient);

        gbc.insets = new Insets(5, 0, 10, 0);
        panelHolder.add(panel2, gbc);
        panelHolder.add(panel3, gbc);
        gbc.insets = new Insets(15, 0, 0, 0);

        panelHolder.add(connectionButton, gbc);

        JButton signInButton = new JButton("S'inscrire");
        signInButton.setBackground(new Color(59, 89, 182));
        signInButton.setOpaque(true);
        signInButton.setBorderPainted(false);
        signInButton.setForeground(Color.WHITE);
        signInButton.setFocusPainted(false);
        signInButton.setPreferredSize(new Dimension(120, 20));
        signInButton.setFont(new Font("Tahoma", Font.PLAIN, 16));

        LoadSignIn login = new LoadSignIn(parc, frame);
        signInButton.addActionListener(login);

        panelHolder.add(signInButton, gbc);

        gbc.insets = new Insets(50, 0, 0, 0);
        panelHolder.add(errorTxt, gbc);

        gbc.weighty = 1;
        add(panelHolder, gbc);

    }
}
