package Vue;

import Controllers.SearchScooter;
import Models.Client;
import Models.Parc;
import Models.Scooter;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Vector;

public class SelectScooter extends JPanel {
    JTextField inputField;

    public SelectScooter(Parc parc, Vector<Scooter> listScooter, LocalDate startDate, LocalDate endDate, JFrame parentFrame, Client client, Parc.ChoiceClient choice) {


        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        JLabel title = new JLabel("Voici les résultats de votre recherche !");

        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        gbc.insets = new Insets(10, 0, 0, 0);
        add(title, gbc);


        JPanel panel2 = new JPanel(new GridBagLayout());
        inputField = new JTextField();
        inputField.setMinimumSize(new Dimension(100, 20));
        inputField.setPreferredSize(new Dimension(140, 20));

        JButton searchButton = new JButton("Entrer");
        searchButton.setBackground(new Color(59, 89, 182));
        searchButton.setOpaque(true);
        searchButton.setBorderPainted(false);
        searchButton.setForeground(Color.WHITE);
        searchButton.setFocusPainted(false);
        searchButton.setMinimumSize(new Dimension(100, 20));
        searchButton.setPreferredSize(new Dimension(100, 20));
        searchButton.setFont(new Font("Tahoma", Font.PLAIN, 15));

        SearchScooter click = new SearchScooter(parc, listScooter, inputField, startDate, endDate, parentFrame, client, choice);
        searchButton.addActionListener(click);
        gbc.weighty = 1;
        gbc.insets = new Insets(40, 0, 0, 0);
        panel2.add(inputField);
        panel2.add(searchButton);
        add(panel2, gbc);
        gbc.insets = new Insets(0, 0, 50, 0);

        JPanel cellScooterHolder = new JPanel();
        cellScooterHolder.setMinimumSize(new Dimension(200, 200));
        GridLayout layout = new GridLayout(0, 2);
        layout.setHgap(10);
        layout.setVgap(10);
        cellScooterHolder.setLayout(layout);

        ScooterCellInfo[] cells = new ScooterCellInfo[listScooter.size() * 2];

        for (int i = 0; i < (listScooter.size()); i++) {

            cells[i] = new ScooterCellInfo(listScooter.get(i), LocalDate.now(), LocalDate.now());
            cellScooterHolder.add(cells[i], gbc);

        }

        JScrollPane jsp = new JScrollPane(cellScooterHolder);
        jsp.setPreferredSize(new Dimension(400, 350));

        add(jsp, gbc);
    }

}


