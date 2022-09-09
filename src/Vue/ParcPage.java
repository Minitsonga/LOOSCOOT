package Vue;

import Controllers.ListParcScooter;
import Controllers.ReturnMenuBar;
import Controllers.StatParc;
import Models.Client;
import Models.Parc;

import javax.swing.*;
import java.awt.*;

public class ParcPage extends JPanel {

    public ParcPage(Parc parc, Client client, JFrame frame) {


        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;

        JLabel title = new JLabel("Quelles informations voulez vous avoir ?");
        title.setFont(new Font("Tahoma", Font.BOLD, 28));
        add(title, gbc);

        gbc.anchor = GridBagConstraints.CENTER;

        JPanel panel2 = new JPanel(new GridBagLayout());

        gbc.insets = new Insets(25, 0, 25, 0);
        JButton button1 = new JButton("Résumé du Parc");
        button1.setBackground(new Color(59, 89, 182));
        button1.setOpaque(true);
        button1.setBorderPainted(false);
        button1.setForeground(Color.WHITE);
        button1.setFocusPainted(false);
        button1.setPreferredSize(new Dimension(200, 30));
        button1.setFont(new Font("Tahoma", Font.PLAIN, 20));

        StatParc statParc = new StatParc(parc, client, frame);
        button1.addActionListener(statParc);

        JButton button2 = new JButton("Liste des Scooter");
        button2.setBackground(new Color(59, 89, 182));
        button2.setOpaque(true);
        button2.setBorderPainted(false);
        button2.setForeground(Color.WHITE);
        button2.setFocusPainted(false);
        button2.setPreferredSize(new Dimension(200, 30));
        button2.setFont(new Font("Tahoma", Font.PLAIN, 20));

        ListParcScooter listScooter = new ListParcScooter(parc, client, frame);
        button2.addActionListener(listScooter);

        JButton button3 = new JButton("Retour");
        button3.setBackground(new Color(182, 59, 59));
        button3.setOpaque(true);
        button3.setBorderPainted(false);
        button3.setForeground(Color.WHITE);
        button3.setFocusPainted(false);
        button3.setPreferredSize(new Dimension(120, 30));
        button3.setFont(new Font("Tahoma", Font.PLAIN, 20));

        ReturnMenuBar returnHome = new ReturnMenuBar(parc, client, frame);
        button3.addActionListener(returnHome);

        panel2.add(button1, gbc);
        panel2.add(button2, gbc);
        panel2.add(button3, gbc);

        gbc.weighty = 1;
        add(panel2, gbc);


    }
}
