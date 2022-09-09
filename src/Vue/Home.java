package Vue;

import Controllers.Loc_ReturnPageSetup;
import Controllers.PageParcChoice;
import Models.Client;
import Models.Parc;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class Home extends JPanel {

    public Home(Parc parc, Client curClient, JFrame frame, LocalDate date) {


        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;

        JLabel title = new JLabel("Bienvenue dans LOUSCOOT !");
        title.setFont(new Font("Tahoma", Font.BOLD, 36));
        add(title, gbc);

        gbc.anchor = GridBagConstraints.CENTER;

        JPanel panel2 = new JPanel(new GridBagLayout());

        gbc.insets = new Insets(25, 0, 25, 0);
        JButton button1 = new JButton("Réservation");
        button1.setBackground(new Color(59, 89, 182));
        button1.setOpaque(true);
        button1.setBorderPainted(false);
        button1.setForeground(Color.WHITE);
        button1.setFocusPainted(false);
        button1.setPreferredSize(new Dimension(140, 30));
        button1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Loc_ReturnPageSetup pageChoice = new Loc_ReturnPageSetup(parc, curClient, frame);
        button1.addActionListener(pageChoice);

        JButton button2 = new JButton("Parc");
        button2.setBackground(new Color(59, 89, 182));
        button2.setOpaque(true);
        button2.setBorderPainted(false);
        button2.setForeground(Color.WHITE);
        button2.setFocusPainted(false);
        button2.setPreferredSize(new Dimension(140, 30));
        button2.setFont(new Font("Tahoma", Font.PLAIN, 20));

        PageParcChoice pageParc = new  PageParcChoice(parc, curClient, frame);
        button2.addActionListener(pageParc);

        panel2.add(button1, gbc);
        panel2.add(button2, gbc);

        gbc.weighty = 1;
        add(panel2, gbc);
    }
}
