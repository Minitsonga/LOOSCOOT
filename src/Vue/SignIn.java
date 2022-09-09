package Vue;

import Controllers.LoadLogin;
import Controllers.SignClient;
import Models.Parc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDate;

public class SignIn extends JPanel {

    public SignIn(Parc parc, JFrame frame, LocalDate date) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;


        JLabel title = new JLabel("Inscription");
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

        JLabel lastName = new JLabel("Nom de famille");
        lastName.setFont(new Font("Tahoma", Font.BOLD, 20));

        JTextField lastName_TextField = new JTextField();
        lastName_TextField.setPreferredSize(new Dimension(200, 25));

        panel3.add(lastName, gbc);
        panel3.add(lastName_TextField);


        JPanel panel4 = new JPanel(new FlowLayout());
        JPanel panel5 = new JPanel(new GridLayout(0, 3));
        JLabel birthTitle = new JLabel("Date de naissance");
        birthTitle.setFont(new Font("Tahoma", Font.BOLD, 20));

        //region TextFields Start

        JTextField yearStart = new JTextField("Année");
        yearStart.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (yearStart.getText().equals("Année")) {
                    yearStart.setText("");
                    yearStart.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (yearStart.getText().isEmpty()) {
                    yearStart.setForeground(Color.GRAY);
                    yearStart.setText("Année");
                }
            }
        });
        JTextField monthStart = new JTextField("Mois");
        monthStart.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (monthStart.getText().equals("Mois")) {
                    monthStart.setText("");
                    monthStart.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (monthStart.getText().isEmpty()) {
                    monthStart.setForeground(Color.GRAY);
                    monthStart.setText("Mois");
                }
            }
        });
        JTextField dayStart = new JTextField("Jour");
        dayStart.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (dayStart.getText().equals("Jour")) {
                    dayStart.setText("");
                    dayStart.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (dayStart.getText().isEmpty()) {
                    dayStart.setForeground(Color.GRAY);
                    dayStart.setText("Jour");
                }
            }
        });

        //endregion

        panel4.add(birthTitle, gbc);
        panel5.add(dayStart);
        panel5.add(monthStart);
        panel5.add(yearStart);


        JPanel panel6 = new JPanel(new GridBagLayout());

        JCheckBox permiA = new JCheckBox("Permis A");

        JCheckBox permiA1 = new JCheckBox("Permis A1");

        JCheckBox permiA2 = new JCheckBox("Permis A2");


        panel6.add(permiA2);
        panel6.add(permiA1);
        panel6.add(permiA);


        gbc.weighty = 1;


        JButton signInButton = new JButton("S'inscrire");
        signInButton.setBackground(new Color(59, 89, 182));
        signInButton.setOpaque(true);
        signInButton.setBorderPainted(false);
        signInButton.setForeground(Color.WHITE);
        signInButton.setFocusPainted(false);
        signInButton.setMinimumSize(new Dimension(100, 20));
        signInButton.setPreferredSize(new Dimension(150, 25));
        signInButton.setFont(new Font("Tahoma", Font.PLAIN, 18));

        JLabel errorTxt = new JLabel();
        errorTxt.setForeground(Color.RED);
        errorTxt.setFont(new Font("Tahoma", Font.BOLD, 18));

        SignClient connectClient = new SignClient(parc, firstName_TextField, lastName_TextField,errorTxt, yearStart, monthStart, dayStart, frame, permiA, permiA1, permiA2, date);
        signInButton.addActionListener(connectClient);

        gbc.insets = new Insets(5, 0, 10, 0);
        panelHolder.add(panel2, gbc);
        panelHolder.add(panel3, gbc);
        panelHolder.add(panel4, gbc);
        panelHolder.add(panel5, gbc);
        panelHolder.add(panel6, gbc);
        gbc.insets = new Insets(15, 0, 0, 0);
        panelHolder.add(signInButton, gbc);


        JButton returnButton = new JButton("Se Connecter");
        returnButton.setBackground(new Color(59, 89, 182));
        returnButton.setOpaque(true);
        returnButton.setBorderPainted(false);
        returnButton.setBorderPainted(false);
        returnButton.setForeground(Color.WHITE);
        returnButton.setFocusPainted(true);
        returnButton.setPreferredSize(new Dimension(130, 20));
        returnButton.setFont(new Font("Tahoma", Font.PLAIN, 14));

        LoadLogin login = new LoadLogin(parc, frame);
        returnButton.addActionListener(login);

        panelHolder.add(returnButton, gbc);

        gbc.insets = new Insets(35, 0, 0, 0);
        panelHolder.add(errorTxt, gbc);

        add(panelHolder, gbc);


    }
}
