package Vue;

import Controllers.ReturnMenuBar;
import Models.Client;
import Models.Parc;

import javax.swing.*;
import java.awt.*;

public class ListScooterClient extends JPanel {

    public ListScooterClient(Parc p, Client c, JFrame f) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        JLabel title = new JLabel("Voici toutes vos reservations ou locations");

        title.setFont(new Font("Tahoma", Font.BOLD, 18));
        gbc.insets = new Insets(10, 0, 0, 0);
        add(title, gbc);


        JPanel cellScooterHolder = new JPanel();
        cellScooterHolder.setMinimumSize(new Dimension(200, 200));
        GridLayout layout = new GridLayout(0, 2);
        layout.setHgap(10);
        layout.setVgap(10);
        cellScooterHolder.setLayout(layout);

        ClientReservation_CellInfo[] cells = new ClientReservation_CellInfo[c.listReservation.size()];

        for (int i = 0; i < c.listReservation.size(); i++) {

            cells[i] = new ClientReservation_CellInfo(c.listReservation.get(i).scooter, c.listReservation.get(i).location.dateDebut,c.listReservation.get(i).location.dateFin);
            cellScooterHolder.add(cells[i], gbc);

        }

        JScrollPane jsp = new JScrollPane(cellScooterHolder);
        jsp.setPreferredSize(new Dimension(350, 400));
        gbc.insets = new Insets(25, 0, 0, 0);
        gbc.weighty = 1;
        add(jsp, gbc);

        JPanel panel2 = new JPanel(new GridBagLayout());

        gbc.insets = new Insets(25, 0, 25, 0);
        gbc.anchor = GridBagConstraints.CENTER;

        JButton button1 = new JButton("Retour");
        button1.setBackground(new Color(182, 59, 59));
        button1.setOpaque(true);
        button1.setBorderPainted(false);
        button1.setForeground(Color.WHITE);
        button1.setFocusPainted(false);
        button1.setPreferredSize(new Dimension(150, 30));
        button1.setFont(new Font("Tahoma", Font.PLAIN, 20));

        ReturnMenuBar homePage = new  ReturnMenuBar(p, c, f);
        button1.addActionListener(homePage);

        panel2.add(button1);
        add(panel2, gbc);
    }

}


