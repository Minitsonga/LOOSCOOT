package Vue;

import Controllers.ListScooterDynamic;
import Models.Client;
import Models.Parc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Locate_Return_PageChoice extends JPanel {

    public Locate_Return_PageChoice(Parc parc, Client client, JFrame frame) {

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;


        JLabel title = new JLabel("Remplissez les informations suivantes :");
        title.setFont(new Font("Tahoma", Font.BOLD, 25));
        gbc.insets = new Insets(20, 0, 20, 0);
        add(title, gbc);

        JPanel mainHolder = new JPanel(new GridBagLayout());


        JPanel START_panelDateHolder = new JPanel(new GridBagLayout());


        JLabel debLabel = new JLabel("Date de debut de reservation : ");
        debLabel.setFont(new Font("Tahoma", Font.BOLD, 12));


        JPanel panelTextField = new JPanel(new GridLayout(0, 3));
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

        gbc.insets = new Insets(0, 0, 0, 10);
        panelTextField.add(dayStart, gbc);
        panelTextField.add(monthStart, gbc);
        panelTextField.add(yearStart, gbc);

        gbc.insets = new Insets(0, 0, 10, 0);
        START_panelDateHolder.add(debLabel, gbc);
        START_panelDateHolder.add(panelTextField);


        JPanel END_panelDateHolder = new JPanel(new GridBagLayout());

        JLabel endLabel = new JLabel("Date de fin de reservation : ");
        endLabel.setFont(new Font("Tahoma", Font.BOLD, 12));

        JPanel panelTextField2 = new JPanel(new GridLayout(0, 3));

        //region TextFields

        JTextField yearEnd = new JTextField("Année");
        yearEnd.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (yearEnd.getText().equals("Année")) {
                    yearEnd.setText("");
                    yearEnd.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (yearEnd.getText().isEmpty()) {
                    yearEnd.setForeground(Color.GRAY);
                    yearEnd.setText("Année");
                }
            }
        });
        JTextField monthEnd = new JTextField("Mois");
        monthEnd.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (monthEnd.getText().equals("Mois")) {
                    monthEnd.setText("");
                    monthEnd.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (monthEnd.getText().isEmpty()) {
                    monthEnd.setForeground(Color.GRAY);
                    monthEnd.setText("Mois");
                }
            }
        });
        JTextField dayEnd = new JTextField("Jour");
        dayEnd.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (dayEnd.getText().equals("Jour")) {
                    dayEnd.setText("");
                    dayEnd.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (dayEnd.getText().isEmpty()) {
                    dayEnd.setForeground(Color.GRAY);
                    dayEnd.setText("Jour");
                }
            }
        });

        //endregion

        gbc.insets = new Insets(0, 0, 0, 10);
        panelTextField2.add(dayEnd, gbc);
        panelTextField2.add(monthEnd, gbc);
        panelTextField2.add(yearEnd, gbc);

        gbc.insets = new Insets(0, 0, 10, 0);
        END_panelDateHolder.add(endLabel, gbc);
        END_panelDateHolder.add(panelTextField2);


        gbc.insets = new Insets(10, 0, 15, 0);
        mainHolder.add(START_panelDateHolder, gbc);
        mainHolder.add(END_panelDateHolder, gbc);

        JPanel boxes = new JPanel(new GridBagLayout());

        JRadioButton locationBox = new JRadioButton("Location");
        JRadioButton returnBox = new JRadioButton("Retour");
        JRadioButton cancelBox = new JRadioButton("Annulation");

        boxes.add(locationBox);
        boxes.add(returnBox);
        boxes.add(cancelBox);

        mainHolder.add(boxes, gbc);


        gbc.insets = new Insets(25, 0, 25, 0);
        JButton button1 = new JButton("Rechercher Scooters");
        button1.setBackground(new Color(59, 89, 182));
        button1.setOpaque(true);
        button1.setBorderPainted(false);
        button1.setForeground(Color.WHITE);
        button1.setFocusPainted(false);
        button1.setPreferredSize(new Dimension(230, 30));
        button1.setFont(new Font("Tahoma", Font.PLAIN, 20));


        mainHolder.add(button1, gbc);

        JLabel errorTxt = new JLabel();
        errorTxt.setFont(new Font("Tahoma", Font.BOLD, 15));
        errorTxt.setForeground(Color.RED);

        ListScooterDynamic pageLocation = new ListScooterDynamic(parc, client, frame, yearStart, monthStart, dayStart, yearEnd, monthEnd, dayEnd, locationBox, returnBox, cancelBox, errorTxt);
        button1.addActionListener(pageLocation);

        mainHolder.add(errorTxt, gbc);

        gbc.weighty = 1;
        add(mainHolder, gbc);
    }
}
