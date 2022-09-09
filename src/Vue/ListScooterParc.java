package Vue;

import Controllers.PageParcChoice;
import Models.Client;
import Models.Parc;
import Models.Scooter;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Vector;

public class ListScooterParc extends JPanel {
    Vector<Scooter> listScooter;
    public ListScooterParc(Parc p, Client c, JFrame f) {

        listScooter = p.getListScooter();

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        JLabel title = new JLabel("Voici tous les scooters du parc !");

        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        gbc.insets = new Insets(10, 0, 0, 0);
        add(title, gbc);


        JPanel cellScooterHolder = new JPanel();
        cellScooterHolder.setMinimumSize(new Dimension(200, 200));
        GridLayout layout = new GridLayout(0, 2);
        layout.setHgap(10);
        layout.setVgap(10);
        cellScooterHolder.setLayout(layout);

        //cellScooterHolder.setLayout(new BoxLayout());

        ScooterCellInfo[] cells = new ScooterCellInfo[listScooter.size() * 2];

        for (int i = 0; i < (listScooter.size()); i++) {

            //System.out.println(Parc.listScooter.get(i).model.label);
            cells[i] = new ScooterCellInfo(listScooter.get(i), LocalDate.now(),LocalDate.now());
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

        PageParcChoice pageParc = new  PageParcChoice(p, c, f);
        button1.addActionListener(pageParc);

        panel2.add(button1);
        add(panel2, gbc);
    }

}


